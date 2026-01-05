package DAO;

import modal.Address;
import modal.Employee;

import java.util.List;

public interface IDAO {

    Employee insertEmployee(Employee employee);
    Employee findEmployeeById(Long id);
    Employee findEmployeeByName(String name);
    List<Employee> findAll();
    void deleteEmployeeById(Long id);
    boolean findAddressById(Long id);
    Employee updateEmployee(Employee employee);
}
