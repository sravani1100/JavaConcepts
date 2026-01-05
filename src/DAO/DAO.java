package DAO;

import exception.EmployeeNotFoundException;
import modal.Address;
import modal.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements IDAO{

    @Override
    public Employee insertEmployee(Employee employee){
        String employeeQuery =
                "INSERT INTO employees(name, email, phoneNumber, age, department,address_id) VALUES(?, ?, ?, ?, ?, ?)";

        String addressQuery = "INSERT INTO address(houseNumber, street, city, pincode) VALUES(?, ?, ?, ?)";

        try(Connection connection = DBConnection.connectDB()){

            connection.setAutoCommit(false);

            PreparedStatement addressPS = connection.prepareStatement(addressQuery, Statement.RETURN_GENERATED_KEYS);
            Address address = employee.getAddress();
            addressPS.setString(1, address.getHouseNumber());
            addressPS.setString(2, address.getStreet());
            addressPS.setString(3, address.getCity());
            addressPS.setString(4, address.getPincode());
            addressPS.executeUpdate();

            ResultSet rs = addressPS.getGeneratedKeys();
            rs.next();
            int addressId = rs.getInt(1);

            PreparedStatement ps = connection.prepareStatement(employeeQuery);
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getPhoneNumber());
            ps.setInt(4, employee.getAge());
            ps.setString(5, employee.getDepartment());
            ps.setInt(6, addressId);

            ps.executeUpdate();

            connection.commit();

            System.out.println("Rows Inserted");

            return employee;

        }catch(SQLException e){
            System.out.println("Insertion of employee failed" +e);
            return null;
        }
    }

    @Override
    public Employee findEmployeeById(Long id){

        String query = "Select e.id, e.name, e.email, e.phoneNumber, e.age, e.department, a.id, a.houseNumber, a.street, a.city, a.pincode " +
                "from employees e "+
                "join address a "+
                "on e.address_id = a.id "+
                "where e.id = ?";

        try(Connection connection = DBConnection.connectDB()) {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                Address address = new Address();
                address.setId(rs.getLong("id"));
                address.setHouseNumber(rs.getString("houseNumber"));
                address.setStreet(rs.getString("street"));
                address.setCity(rs.getString("city"));
                address.setPincode(rs.getString("pincode"));

                Employee employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhoneNumber(rs.getString("phoneNumber"));
                employee.setAge(rs.getInt("age"));
                employee.setDepartment(rs.getString("department"));
                employee.setAddress(address);

                return employee;
            }

        } catch (Exception e) {
            throw new EmployeeNotFoundException("Employee not found with id "+id);
        }
        return null;
    }

    @Override
    public Employee findEmployeeByName(String name) {

        String query = "select e.id, e.name, e.age, e.department, a.city " +
                "from employees e " +
                "join address a " +
                "on e.address_id = a.id " +
                "where TRIM(LOWER(e.name)) = TRIM(LOWER(?))";

        try (Connection connection = DBConnection.connectDB()) {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                throw new EmployeeNotFoundException("Employee not found with name " + name);
            }

                Address address = new Address();
                address.setCity(rs.getString("city"));

                Employee employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employee.setDepartment(rs.getString("department"));
                employee.setAddress(address);

                return employee;


        } catch (Exception e) {
            throw new EmployeeNotFoundException("Employee not found with name " + name);
        }
    }

    @Override
    public List<Employee> findAll(){
        List<Employee> employeeList = new ArrayList<>();

        String query = "Select e.name, e.email, e.phoneNumber, e.age, e.department, a.city, a.pincode " +
                "from employees e " +
                "join address a " +
                "on e.address_id = a.id ";

        try(Connection connection = DBConnection.connectDB()){

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Address address = new Address();
                address.setCity(rs.getString("city"));
                address.setPincode(rs.getString("pincode"));

                Employee employee = new Employee();
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setPhoneNumber(rs.getString("phoneNumber"));
                employee.setAge(rs.getInt("age"));
                employee.setDepartment(rs.getString("department"));
                employee.setAddress(address);

                employeeList.add(employee);
            }
        } catch (Exception e) {
            throw new EmployeeNotFoundException("employee not found");
        }
        return employeeList;
    }

    @Override
    public void deleteEmployeeById(Long id){
        String findAddress = "Select address_id from employees where id = ?";
        String employeeQuery = "Delete from employees where id = ?";
        String addressQuery = "Delete from address where id = ?";

        try(Connection connection = DBConnection.connectDB()){

            connection.setAutoCommit(false);
            Long address_id;
            try(PreparedStatement ps = connection.prepareStatement(findAddress)){

                ps.setLong(1, id);
                ResultSet rs = ps.executeQuery();
                if(!rs.next()){
                    throw new EmployeeNotFoundException("Address not found");
                }
                address_id = rs.getLong("address_id");
            }
            try(PreparedStatement ps = connection.prepareStatement(employeeQuery)){

                ps.setLong(1, id);
                ps.executeUpdate();
            }
            try(PreparedStatement ps = connection.prepareStatement(addressQuery)){

                ps.setLong(1, id);
                ps.executeUpdate();
            }
            connection.commit();

        }catch (Exception e){
            System.out.println("Deleting employee failed" +e.getMessage());
        }
    }

    @Override
    public List<Long> findAddress(){
        String query = "select id from address";
        String deleteQuery = "Delete from address where id = ?";
        List<Long> idList = new ArrayList<>();

        try(Connection connection = DBConnection.connectDB()){

            try(PreparedStatement ps = connection.prepareStatement(query)){
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    if(rs.getLong("id") == 6 || rs.getLong("id") == 17){
                        continue;
                    }
                    idList.add(rs.getLong("id"));
                }

            }

            try(PreparedStatement ps = connection.prepareStatement(deleteQuery)){
                if(idList.isEmpty()){
                    throw new EmployeeNotFoundException("Address list is empty");
                }
                for(Long id : idList){
                    ps.setLong(1, id);
                    ps.addBatch();
                }
                ps.executeBatch();
            }

        }catch(Exception e){
            throw new EmployeeNotFoundException("Employee not found");
        }
        return idList;
    }

    @Override
    public Employee updateEmployee(Employee employee){
        String employeeQuery = "update employees " +
                "set name = ?, email = ?, phoneNumber = ?, age = ?, department = ? " +
                "where id = ?" ;
        String addressQuery = "update address " +
                "set houseNumber = ?, street = ?, city = ?, pincode = ? " +
                "where id = ?";

        try (Connection connection = DBConnection.connectDB()){

            connection.setAutoCommit(false);

            try(PreparedStatement ps = connection.prepareStatement(addressQuery)){

                ps.setString(1, employee.getAddress().getHouseNumber());
                ps.setString(2, employee.getAddress().getStreet());
                ps.setString(3, employee.getAddress().getCity());
                ps.setString(4, employee.getAddress().getPincode());
                ps.setLong(5, employee.getAddress().getId());
                ps.executeUpdate();
            }

            try(PreparedStatement ps = connection.prepareStatement(employeeQuery)){

                ps.setString(1, employee.getName());
                ps.setString(2, employee.getEmail());
                ps.setString(3, employee.getPhoneNumber());
                ps.setInt(4, employee.getAge());
                ps.setString(5, employee.getDepartment());
                ps.setLong(6, employee.getId());
                ps.executeUpdate();
            }

            connection.commit();

            return employee;

        } catch (SQLException e) {
            throw new RuntimeException("Updating employee failed", e);
        }
    }

    public void deleteAddressInBatch(List<Long> addressId){

        String query = "Delete from address where id = ?";
        try(Connection connection = DBConnection.connectDB()){
            PreparedStatement ps = connection.prepareStatement(query);

            for(Long id : addressId){
                if(id == 6 || id == 17){
                    continue;
                }
                ps.setLong(1, id);
                ps.addBatch();
            }

            ps.executeBatch();

        } catch (Exception e) {
            System.out.println("BatchDelete failed");
        }
    }
    
}
