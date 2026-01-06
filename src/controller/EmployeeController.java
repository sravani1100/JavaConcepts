package controller;

import exception.EmployeeNotFoundException;
import modal.Employee;
import service.IEmployeeService;

import java.util.ArrayList;
import java.util.Collections;
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
            System.out.println("controller " +e.getMessage());
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

    public void deleteEmployee(Long id) {
        try{
            employeeService.deleteEmployee(id);
            System.out.println("Employee deleted successfully");
        }catch (EmployeeNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    public List<Long> getAddresses(){
        try {
            return employeeService.getAllAdress();
        }catch (EmployeeNotFoundException e){
            System.out.println("Address table is empty");
            return Collections.emptyList();
        }
    }

    public List<Employee> getEmployeesByDepartment(String name){
        try{
            return employeeService.getEmployeesByDepartment(name);
        }catch (EmployeeNotFoundException e){
            System.out.println("Department not exist");
            return Collections.emptyList();
        }
    }

    public void deleteAddress(List<Long> id){
        try{
            employeeService.deleteAdress(id);
            System.out.println("Deleted successfully");
        }catch (EmployeeNotFoundException e){
            System.out.println("Address batch is empty");
        }
    }

    public List<Employee> addEmployeeInBatch(List<Employee> employees){
        try{

            List<Employee> employeeList = employeeService.addEmployeeInBatch(employees);
            System.out.println("Employyees added successfully");
            return employeeList;

        }catch (EmployeeNotFoundException e){
            System.out.println(e.getMessage()   );
            return Collections.emptyList();
        }
    }
}
