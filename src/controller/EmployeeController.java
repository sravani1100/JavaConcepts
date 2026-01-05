package controller;

import exception.EmployeeNotFoundException;
import modal.Employee;
import service.IEmployeeService;

import java.util.List;

public class EmployeeController{
    private final IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService){
        this.employeeService = employeeService;
    }

    public Employee getEmployeeById(Long id) {
        try{
            return employeeService.getEmployeeById(id);
        }catch (EmployeeNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Employee getEmployeeByName(String name) {
        try{
            return employeeService.getEmployeeByName(name);
        }catch (EmployeeNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Employee> getAllEmployees() {
        try{
            return employeeService.getAllEmployees();
        }catch (EmployeeNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Employee addEmployee(Employee employee) {
        try{
            return employeeService.addEmployee(employee);
        }catch (EmployeeNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Employee updateEmployee(Employee employee) {
        try{
            return employeeService.updateEmployee(employee);
        }catch (EmployeeNotFoundException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void deleteEmployee(Employee employee) {
        try{
            employeeService.deleteEmployee(employee);
            System.out.println("Employee deleted successfully");
        }catch (EmployeeNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
