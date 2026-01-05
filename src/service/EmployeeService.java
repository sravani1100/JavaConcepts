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
        List<Employee> employeeList = idao.findAll();
        if(employeeList.isEmpty()){
            throw new EmployeeNotFoundException("No employee found!");
        }
        return employeeList;
    }

    @Override
    public Employee addEmployee(Employee employee) {

        return idao.insertEmployee(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {

        Employee existingEmployee = idao.findEmployeeById(employee.getId());

        if(existingEmployee == null){
            throw new EmployeeNotFoundException("Employee not found");
        }

        Address address = idao.findEmployeeById(employee.getId()).getAddress();
        if(address == null){
            throw new EmployeeNotFoundException("Employee has no address");
        }

        address.setHouseNumber(employee.getAddress().getHouseNumber());
        address.setStreet(employee.getAddress().getStreet());
        address.setCity(employee.getAddress().getCity());
        address.setPincode(employee.getAddress().getPincode());

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setPhoneNumber(employee.getPhoneNumber());
        existingEmployee.setAge(employee.getAge());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setAddress(address);

        return idao.updateEmployee(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        if(idao.findEmployeeById(id) == null){
            throw new EmployeeNotFoundException("No employee found with id " +id +"please enter existing employee id");
        }
        idao.deleteEmployeeById(id);
    }

    @Override
    public List<Long> getAllAdress() {
        List<Long> idList = idao.findAddress();
        if(idList.isEmpty()){
            throw new EmployeeNotFoundException("Address is empty");
        }
        return idList;
    }
}
