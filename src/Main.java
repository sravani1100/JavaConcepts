import DAO.DAO;
import modal.Address;
import modal.Employee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*Address address = new Address();
        address.setHouseNumber("T2-203");
        address.setStreet("Krishna colony");
        address.setCity("Bhupalpally");
        address.setPincode("506169");

        Employee employee = new Employee();
        employee.setName("Sagar");
        employee.setEmail("sagar@gmail.com");
        employee.setPhoneNumber("9666531267");
        employee.setAge(35);
        employee.setDepartment("Manager");
        employee.setAddress(address);

        DAO dao = new DAO();
        dao.insertEmployee(employee);*/


        Employee employee = new Employee();
        DAO dao = new DAO();
        /*employee = dao.findEmployeeById(1L);
        System.out.println(employee.getName() +"\n"
                            +employee.getEmail() +"\n"
                            +employee.getPhoneNumber() +"\n"
                            +employee.getAge() +"\n"
                            +employee.getDepartment() +"\n"
                            +employee.getAddress().getHouseNumber() +"\n"
                            +employee.getAddress().getStreet() +"\n"
                            +employee.getAddress().getCity() +"\n"
                            +employee.getAddress().getPincode());*/

        /*employee = dao.findEmployeeByName("Ashwitha");
        System.out.println(employee.getName() +"\n"
                +employee.getAge() +"\n"
                +employee.getDepartment() +"\n"
                +employee.getAddress().getCity() );
*/

        //dao.deleteEmployeeById(1L);
        //System.out.println(dao.findAddressById(2L));


        List<Employee> employeeList = new ArrayList<>();
        employeeList = dao.findAll();
        for(Employee employe : employeeList){
            System.out.println(employe.getName() +" "
                    +employe.getAge() +" "
                    +employe.getDepartment() +" "
                    +employe.getAddress().getCity());
            System.out.println();
        }


    }
}