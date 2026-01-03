package service;

import modal.Employee;

import java.util.List;

public interface IEmployeeService {

    Employee getEmployeeById(Long id);
    Employee getEmployeeByName(String name);
    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);


}
