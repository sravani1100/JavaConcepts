package service;

import DAO.IDAO;
import exception.EmployeeNotFoundException;
import modal.Address;
import modal.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService{
    private final IDAO idao;

    public EmployeeService(IDAO idao) {
        this.idao = idao;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        if(idao.findEmployeeById(id) == null){
            throw new EmployeeNotFoundException("Employee Not found");
        }
        return idao.findEmployeeById(id);
    }

    @Override
    public Employee getEmployeeByName(String name) {
        if(idao.findEmployeeByName(name) == null){
            throw new EmployeeNotFoundException("Employee not found");
        }
        return idao.findEmployeeByName(name);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList = idao.findAll();
        if(employeeList.isEmpty()){
            throw new EmployeeNotFoundException("No employee found!");
        }
        return employeeList;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        if(idao.findEmployeeById(employee.getId()) != null){
            throw new EmployeeNotFoundException("Employee already exists");
        }
        return idao.insertEmployee(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if(idao.findEmployeeById(employee.getId()) == null){
            throw new EmployeeNotFoundException("Employee not found");
        }
        Address address = new Address();
        address = idao.findEmployeeById(employee.getId()).getAddress();
        address.setHouseNumber(employee.getAddress().getHouseNumber());
        address.setStreet(employee.getAddress().getStreet());
        address.setCity(employee.getAddress().getCity());
        address.setPincode(employee.getAddress().getPincode());

        Employee updatedEmployee = new Employee();
        updatedEmployee = idao.findEmployeeById(employee.getId());
        updatedEmployee.setName(employee.getName());
        updatedEmployee.setEmail(employee.getEmail());
        updatedEmployee.setPhoneNumber(employee.getPhoneNumber());
        updatedEmployee.setAge(employee.getAge());
        updatedEmployee.setDepartment(employee.getDepartment());
        updatedEmployee.setAddress(address);

        return idao.updateEmployee(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        if(idao.findEmployeeById(employee.getId()) == null){
            throw new EmployeeNotFoundException("No employee found with id " +employee.getId() +"please enter existing employee id");
        }
        idao.deleteEmployeeById(employee.getId());
    }
}
