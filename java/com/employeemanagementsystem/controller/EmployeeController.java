//EmployeeController class
package com.employeemanagementsystem.controller;

//importing all neccessary packages and classes
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.service.EmployeeService;

//Controller class(RestController)
@CrossOrigin
@RestController
@RequestMapping("/Employee") // root mapping with the url
public class EmployeeController {
	// Dependency injection of the employeeservice
	@Autowired
	EmployeeService empservice;

	// defining the constructor for defining dependency injection
	public EmployeeController(EmployeeService empservice) {
		super();
		this.empservice = empservice;
	}

	@GetMapping("/getallemployees") // mapping url with getmapping
	// fetching all the employees
	public ResponseEntity<List<Employee>> getall() {
		List<Employee> list = empservice.getAllEmployees();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping("/insertemployee") // mapping url with postmapping
	// inserting the employee
	public ResponseEntity<String> insert(@RequestBody Employee e) {
		String s = empservice.insertEmployee(e);
		return new ResponseEntity<>(s, HttpStatus.CREATED);
	}

	@PutMapping("/updateemployee") // mapping url with putmapping
	// updating the employee
	public ResponseEntity<String> update(@RequestBody Employee e) {
		String s = empservice.updateEmployee(e);
		return new ResponseEntity<>(s, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteemployee/{employeeId}") // mapping url with deletemapping
	// deleting the employee
	public ResponseEntity<String> delete(@PathVariable("employeeId") Integer employeeId) {
		String s = empservice.deleteEmployee(employeeId);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@GetMapping("/getemployeebyid/{employeeId}") // mapping url with getmapping
	// fetching the employee by id
	public ResponseEntity<Employee> get(@PathVariable("employeeId") Integer employeeId) {
		Employee e = empservice.getEmployee(employeeId);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

	@GetMapping("/getemployeebyname/{employeeName}") // mapping url with getmapping
	// fetching the employee by name
	public ResponseEntity<Employee> getEN(@PathVariable("employeeName") String employeeName) {
		Employee e = (Employee) empservice.getEmployeeByName(employeeName);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

	@GetMapping("/getemployeebyemail/{email}") // mapping url with getmapping
	// fetching the employee by email
	public ResponseEntity<Employee> getEE(@PathVariable("email") String email) {
		Employee e = (Employee) empservice.getEmployeeByEmail(email);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

	@GetMapping("/getemployeebyage/{age}") // mapping url with getmapping
	// fetching the employee by age
	public ResponseEntity<Employee> getEA(@PathVariable("age") Integer age) {
		Employee e = (Employee) empservice.getEmployeeByAge(age);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

	@GetMapping("/getemployeebyPhonenumber/{phoneNumber}") // mapping url with getmapping
	// fetching the employee by phonenumber
	public ResponseEntity<Employee> getEP(@PathVariable("phoneNumber") Long phoneNumber) {
		Employee e = (Employee) empservice.getEmployeeByPhoneNumber(phoneNumber);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

	@GetMapping("/getemployeebyjobtitile/{jobTitle}") // mapping url with getmapping
	// fetching the employee by jobtitle
	public ResponseEntity<Employee> getET(@PathVariable("jobTitle") String jobTitle) {
		Employee e = (Employee) empservice.getEmployeeByJobTitle(jobTitle);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

	@GetMapping("/getemployeebyhiredate/{hireDate}") // mapping url with getmapping
	// fetching the employee by hiredate
	public ResponseEntity<Employee> getEHD(@PathVariable("hireDate") String hireDate) {
		Employee e = (Employee) empservice.getEmployeeByHireDate(hireDate);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

	@GetMapping("/getemployeebysalary/{salary}") // mapping url with getmapping
	// fetching the employee by salary
	public ResponseEntity<Employee> getES(@PathVariable("salary") Long salary) {
		Employee e = (Employee) empservice.getEmployeeBySalary(salary);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

}
