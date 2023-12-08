//DepartmentController class
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

import com.employeemanagementsystem.entity.Department;
import com.employeemanagementsystem.service.DepartmentService;

//Controller class(RestController)
@CrossOrigin
@RestController
@RequestMapping("/Department") // root mapping with the url
public class DepartmentController {
	// Dependency injection of the departmentservice
	@Autowired
	DepartmentService dptservice;

	// defining the constructor for defining dependency injection
	public DepartmentController(DepartmentService dptservice) {
		super();
		this.dptservice = dptservice;
	}

	@GetMapping("/getalldepartments") // mapping url with getmapping
	// fetching all the departments
	public ResponseEntity<List<Department>> getall() {
		List<Department> list = dptservice.getAllDepartments();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping("/insertdepartment") // mapping url with postmapping
	// inserting the departments
	public ResponseEntity<String> insert(@RequestBody Department d) {
		String s = dptservice.insertDepartment(d);
		return new ResponseEntity<>(s, HttpStatus.CREATED);
	}

	@PutMapping("/updatedepartment") // mapping url with putmapping
	// updating the department
	public ResponseEntity<String> update(@RequestBody Department d) {
		String s = dptservice.updateDepartment(d);
		return new ResponseEntity<>(s, HttpStatus.CREATED);
	}

	@DeleteMapping("/deletedepartment/{departmentId}") // mapping url with deletemapping
	// deleting the department
	public ResponseEntity<String> delete(@PathVariable("departmentId") Integer departmentId) {
		String s = dptservice.deleteDepartment(departmentId);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@GetMapping("/getdepartmentbyid/{departmentId}") // mapping url with getmapping
	// fetching the department by id
	public ResponseEntity<Department> get(@PathVariable("departmentId") Integer departmentId) {
		Department d = dptservice.getDepartment(departmentId);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}

	@GetMapping("/getdepartmentbyname/{departmentName}") // mapping url with getmapping
	// fetching the department by name
	public ResponseEntity<Department> getDN(@PathVariable("departmentName") String departmentName) {
		Department d = dptservice.getDepartmentByName(departmentName);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}

	@GetMapping("/getdepartmentbylocation/{location}") // mapping url with getmapping
	// fetching the department by location
	public ResponseEntity<Department> getDL(@PathVariable("location") String location) {
		Department d = dptservice.getDepartmentByLocation(location);
		return new ResponseEntity<>(d, HttpStatus.OK);
	}

}
