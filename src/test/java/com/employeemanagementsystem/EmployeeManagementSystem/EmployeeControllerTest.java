//EmployeeControllerTest class for junit testing
package com.employeemanagementsystem.EmployeeManagementSystem;
//importing neccessary packages and classes
import com.employeemanagementsystem.controller.EmployeeController;
import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeControllerTest {
    private EmployeeController employeeController;

    //creating mock bean for employeeservice
    @Mock
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        employeeController = new EmployeeController(employeeService);
    }

    //creating methods for testing the methods of the controller class and verifying the expected and actual output
    @Test
    void testGetAllEmployees() {
        List<Employee> employees = Arrays.asList(new Employee(), new Employee());
        Mockito.when(employeeService.getAllEmployees()).thenReturn(employees);

        ResponseEntity<List<Employee>> responseEntity = employeeController.getall();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employees, responseEntity.getBody());
    }

    @Test
    void testInsertEmployee() {
        Employee employee = new Employee();
        Mockito.when(employeeService.insertEmployee(employee)).thenReturn("Employee inserted successfully.");

        ResponseEntity<String> responseEntity = employeeController.insert(employee);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Employee inserted successfully.", responseEntity.getBody());
    }

    @Test
    void testUpdateEmployee() {
        Employee employee = new Employee();
        Mockito.when(employeeService.updateEmployee(employee)).thenReturn("Employee updated successfully.");

        ResponseEntity<String> responseEntity = employeeController.update(employee);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("Employee updated successfully.", responseEntity.getBody());
    }

    @Test
    void testDeleteEmployee() {
        Integer employeeId = 1;
        Mockito.when(employeeService.deleteEmployee(employeeId)).thenReturn("Employee deleted successfully.");

        ResponseEntity<String> responseEntity = employeeController.delete(employeeId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Employee deleted successfully.", responseEntity.getBody());
    }

    @Test
    void testGetEmployeeById() {
        Integer employeeId = 1;
        Employee employee = new Employee();
        Mockito.when(employeeService.getEmployee(employeeId)).thenReturn(employee);

        ResponseEntity<Employee> responseEntity = employeeController.get(employeeId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employee, responseEntity.getBody());
    }

    @Test
    void testGetEmployeeByName() {
        String employeeName = "TestEmployee";
        Employee employee = new Employee();
        Mockito.when(employeeService.getEmployeeByName(employeeName)).thenReturn(employee);

        ResponseEntity<Employee> responseEntity = employeeController.getEN(employeeName);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employee, responseEntity.getBody());
    }

    @Test
    void testGetEmployeeByEmail() {
        String email = "test@example.com";
        Employee employee = new Employee();
        Mockito.when(employeeService.getEmployeeByEmail(email)).thenReturn(employee);

        ResponseEntity<Employee> responseEntity = employeeController.getEE(email);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employee, responseEntity.getBody());
    }

    @Test
    void testGetEmployeeByAge() {
        Integer age = 30;
        Employee employee = new Employee();
        Mockito.when(employeeService.getEmployeeByAge(age)).thenReturn(employee);

        ResponseEntity<Employee> responseEntity = employeeController.getEA(age);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employee, responseEntity.getBody());
    }

    @Test
    void testGetEmployeeByPhoneNumber() {
        Long phoneNumber = 1234567890L;
        Employee employee = new Employee();
        Mockito.when(employeeService.getEmployeeByPhoneNumber(phoneNumber)).thenReturn(employee);

        ResponseEntity<Employee> responseEntity = employeeController.getEP(phoneNumber);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employee, responseEntity.getBody());
    }

    @Test
    void testGetEmployeeByJobTitle() {
        String jobTitle = "Engineer";
        Employee employee = new Employee();
        Mockito.when(employeeService.getEmployeeByJobTitle(jobTitle)).thenReturn(employee);

        ResponseEntity<Employee> responseEntity = employeeController.getET(jobTitle);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employee, responseEntity.getBody());
    }

    @Test
    void testGetEmployeeByHireDate() {
        String hireDate = "2023-01-15";
        Employee employee = new Employee();
        Mockito.when(employeeService.getEmployeeByHireDate(hireDate)).thenReturn(employee);

        ResponseEntity<Employee> responseEntity = employeeController.getEHD(hireDate);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employee, responseEntity.getBody());
    }

    @Test
    void testGetEmployeeBySalary() {
        Long salary = 50000L;
        Employee employee = new Employee();
        Mockito.when(employeeService.getEmployeeBySalary(salary)).thenReturn(employee);

        ResponseEntity<Employee> responseEntity = employeeController.getES(salary);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(employee, responseEntity.getBody());
    }
}
