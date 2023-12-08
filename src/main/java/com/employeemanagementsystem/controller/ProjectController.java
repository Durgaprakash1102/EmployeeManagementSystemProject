//ProjectController class
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

import com.employeemanagementsystem.entity.Project;
import com.employeemanagementsystem.service.ProjectService;

//Controller class(RestController)
@CrossOrigin
@RestController
@RequestMapping("/Project")// root mapping with the url
public class ProjectController {
	// Dependency injection of the projectservice
	@Autowired
	ProjectService pjtservice;

	// defining the constructor for defining dependency injection
	public ProjectController(ProjectService pjtservice) {
		super();
		this.pjtservice = pjtservice;
	}

	@GetMapping("/getallprojects")// mapping url with getmapping
	// fetching all the projects
	public ResponseEntity<List<Project>> getall() {
		List<Project> list = pjtservice.getAllProjects();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping("/insertproject")// mapping url with postmapping
	// inserting the projects
	public ResponseEntity<String> insert(@RequestBody Project p) {
		String s = pjtservice.insertProject(p);
		return new ResponseEntity<>(s, HttpStatus.CREATED);
	}

	@PutMapping("/updateproject")// mapping url with putmapping
	// updating the projects
	public ResponseEntity<String> update(@RequestBody Project p) {
		String s = pjtservice.updateProject(p);
		return new ResponseEntity<>(s, HttpStatus.CREATED);
	}

	@DeleteMapping("/deleteproject/{projectId}")// mapping url with deletemapping
	// deleting the project
	public ResponseEntity<String> delete(@PathVariable("projectId") Integer projectId) {
		String s = pjtservice.deleteProject(projectId);
		return new ResponseEntity<>(s, HttpStatus.OK);
	}

	@GetMapping("/getprojectbyid/{projectId}")// mapping url with getmapping
	// fetching the project by id
	public ResponseEntity<Project> getPI(@PathVariable("projectId") Integer projectId) {
		Project p = pjtservice.getProject(projectId);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@GetMapping("/getprojectbyname/{projectName}")// mapping url with getmapping
	// fetching the project by name
	public ResponseEntity<Project> getPN(@PathVariable("projectName") String projectName) {
		Project p = pjtservice.getProjectByName(projectName);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@GetMapping("/getprojectbystartdate/{startDate}")// mapping url with getmapping
	// fetching the project by startdate
	public ResponseEntity<Project> getPSD(@PathVariable("startDate") String startDate) {
		Project p = pjtservice.getProjectByStartDate(startDate);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

	@GetMapping("/getprojectbyenddate/{endDate}")// mapping url with getmapping
	// fetching the project by enddate
	public ResponseEntity<Project> getPED(@PathVariable("endDate") String endDate) {
		Project p = pjtservice.getProjectByEndDate(endDate);
		return new ResponseEntity<>(p, HttpStatus.OK);
	}

}
