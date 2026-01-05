import DAO.DAO;
import controller.EmployeeController;
import modal.Address;
import modal.Employee;
import service.EmployeeService;
import service.IEmployeeService;

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
        dao.insertEmployee(employee);


        Employee employee = new Employee();
        DAO dao = new DAO();
        employee = dao.findEmployeeById(1L);
        System.out.println(employee.getName() +"\n"
                            +employee.getEmail() +"\n"
                            +employee.getPhoneNumber() +"\n"
                            +employee.getAge() +"\n"
                            +employee.getDepartment() +"\n"
                            +employee.getAddress().getHouseNumber() +"\n"
                            +employee.getAddress().getStreet() +"\n"
                            +employee.getAddress().getCity() +"\n"
                            +employee.getAddress().getPincode());

        employee = dao.findEmployeeByName("Ashwitha");
        System.out.println(employee.getName() +"\n"
                +employee.getAge() +"\n"
                +employee.getDepartment() +"\n"
                +employee.getAddress().getCity() );

        dao.deleteEmployeeById(1L);
        System.out.println(dao.findAddressById(2L));


        List<Employee> employeeList = new ArrayList<>();
        employeeList = dao.findAll();
        for(Employee employe : employeeList){
            System.out.println(employe.getName() +" "
                    +employe.getAge() +" "
                    +employe.getDepartment() +" "
                    +employe.getAddress().getCity());
            System.out.println();
        }
*/
        DAO dao = new DAO();
        EmployeeService service = new EmployeeService(dao);
        EmployeeController controller = new EmployeeController(service);

        /*Address address = new Address();
        address.setHouseNumber("T2-45");
        address.setStreet("Krishna colony");
        address.setCity("Bhupalpally");
        address.setPincode("506169");

        Employee employee = new Employee();
        employee.setName("Shiva");
        employee.setEmail("shiva@gmail.com");
        employee.setPhoneNumber("9666531246");
        employee.setAge(32);
        employee.setDepartment("Security");
        employee.setAddress(address);

        controller.addEmployee(employee);*/

        /*List<Employee> employeeList = new ArrayList<>();
        employeeList = controller.getAllEmployees();
        for(Employee employee1 : employeeList){
            System.out.println(employee1.getName() +" "
                                +employee1.getEmail()+" "
                                +employee1.getPhoneNumber()+" "
                                +employee1.getAge()+" "
                                +employee1.getDepartment()+" "
                                +employee1.getAddress().getCity()+" "
                                +employee1.getAddress().getPincode());
        }*/

        /*Employee employee = controller.getEmployeeById(9L);
        System.out.println("Employee found By Id " +employee.getId());
        System.out.println(employee.getName() +" "
                +employee.getEmail()+" "
                +employee.getPhoneNumber()+" "
                +employee.getAge()+" "
                +employee.getDepartment()+" "
                +employee.getAddress().getCity()+" "
                +employee.getAddress().getPincode());
        System.out.println();*/

        /*Employee employee = controller.getEmployeeByName("ashwitha");
        System.out.println("Employe with name "+employee.getName());
        System.out.println(employee.getId()+" "
                            +employee.getName()+" "
                            +employee.getAge()+" "
                            +employee.getDepartment()+" "
                            +employee.getAddress().getCity());*/


        /*Employee employeeToBeUpdated = controller.getEmployeeById(5L);
        employeeToBeUpdated.setAge(26);
        employeeToBeUpdated.getAddress().setCity("Srirampur");
        Employee updatedEmployee = controller.updateEmployee(employeeToBeUpdated);
        System.out.println("Updated Employee with Id " +updatedEmployee.getId());
        System.out.println(updatedEmployee.getName() +" "
                +updatedEmployee.getEmail()+" "
                +updatedEmployee.getPhoneNumber()+" "
                +updatedEmployee.getAge()+" "
                +updatedEmployee.getDepartment()+" "
                +updatedEmployee.getAddress().getCity()+" "
                +updatedEmployee.getAddress().getPincode());*/

        //controller.deleteEmployee(6L);


        /*System.out.println("After delete : \n" );

        List<Employee> employeeList = controller.getAllEmployees();;
        for(Employee employe : employeeList){
            System.out.println(employe.getName() +" "
                    +employe.getAge() +" "
                    +employe.getDepartment() +" "
                    +employe.getAddress().getCity());
            System.out.println();
        }*/

        controller.getAddresses();

    }
}