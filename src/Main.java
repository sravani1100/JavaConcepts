import DAO.DAO;
import controller.EmployeeController;
import modal.Address;
import modal.Employee;
import service.EmployeeService;
import service.IEmployeeService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

        //controller.getAddresses();
        /*List<Employee> employeeList = controller.getEmployeesByDepartment("Computer");
        for(Employee employee : employeeList){
            System.out.println(employee.getName() +" "
                    +employee.getAge() +" "
                    +employee.getDepartment() +" "
                    +employee.getAddress().getCity());
            System.out.println();
        }*/

        /*List<Long> list = controller.getAddresses();
        controller.deleteAddress(list);*/


        /*Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of employees: ");
        int num = sc.nextInt();

        List<Employee> employeeList = new ArrayList<>();
        for(int i = 1; i <= num; i++){

            System.out.println("Employee "+i);

            System.out.println("Name : ");
            String name = sc.next();

            System.out.println("Email : ");
            String email = sc.next();

            System.out.println("PhoneNumber : ");
            String phoneNumber = sc.next();

            System.out.println("Age : ");
            int age = sc.nextInt();

            System.out.println("Department : ");
            String department = sc.next();

            System.out.println("HouseNumber : ");
            String houseNumber = sc.next();

            System.out.println("Street : ");
            String street = sc.next();

            System.out.println("City : ");
            String city = sc.next();

            System.out.println("Pincode : ");
            String pincode = sc.next();

            Address address = new Address();
            address.setHouseNumber(houseNumber);
            address.setStreet(street);
            address.setCity(city);
            address.setPincode(pincode);

            Employee employee = new Employee();
            employee.setName(name);
            employee.setEmail(email);
            employee.setPhoneNumber(phoneNumber);
            employee.setAge(age);
            employee.setDepartment(department);
            employee.setAddress(address);

            employeeList.add(employee);
        }
*/
        List<Employee> employeeList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("C:\\sravani\\github\\Java_Concepts\\JavaConcepts\\src\\resource\\employeeList.csv"))){
            br.readLine();
            String line;

            while((line = br.readLine()) != null){
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] row = line.split(",");


                if (row.length < 9) {
                    System.out.println("Invalid row skipped: " + line);
                    continue;
                }

                Address address = new Address();
                address.setHouseNumber(row[5]);
                address.setStreet(row[6]);
                address.setCity(row[7]);
                address.setPincode(row[8]);

                Employee employee = new Employee();
                employee.setName(row[0].trim());
                employee.setEmail(row[1].trim());
                employee.setPhoneNumber(row[2].trim());
                employee.setAge(Integer.parseInt(row[3]));
                employee.setDepartment(row[4]);
                employee.setAddress(address);

                employeeList.add(employee);
            }
            controller.addEmployeeInBatch(employeeList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Actual error above", e);
        }
    }
}