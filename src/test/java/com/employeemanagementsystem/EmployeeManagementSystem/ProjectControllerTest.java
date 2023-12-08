//ProjectControllerTest class for junit testing
package com.employeemanagementsystem.EmployeeManagementSystem;

//importing neccessary packages and classes
import com.employeemanagementsystem.controller.ProjectController;
import com.employeemanagementsystem.entity.Project;
import com.employeemanagementsystem.service.ProjectService;
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

class ProjectControllerTest {
	private ProjectController projectController;

	// creating mock bean for projectservice
	@Mock
	private ProjectService projectService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		projectController = new ProjectController(projectService);
	}
	
	// creating methods for testing the methods of the controller class and
	// verifying the expected and actual output

	@Test
	void testGetAllProjects() {
		List<Project> projects = Arrays.asList(new Project(), new Project());
		Mockito.when(projectService.getAllProjects()).thenReturn(projects);

		ResponseEntity<List<Project>> responseEntity = projectController.getall();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(projects, responseEntity.getBody());
	}

	@Test
	void testInsertProject() {
		Project project = new Project();
		Mockito.when(projectService.insertProject(project)).thenReturn("Project inserted successfully.");

		ResponseEntity<String> responseEntity = projectController.insert(project);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("Project inserted successfully.", responseEntity.getBody());
	}

	@Test
	void testUpdateProject() {
		Project project = new Project();
		Mockito.when(projectService.updateProject(project)).thenReturn("Project updated successfully.");

		ResponseEntity<String> responseEntity = projectController.update(project);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("Project updated successfully.", responseEntity.getBody());
	}

	@Test
	void testDeleteProject() {
		Integer projectId = 1;
		Mockito.when(projectService.deleteProject(projectId)).thenReturn("Project deleted successfully.");

		ResponseEntity<String> responseEntity = projectController.delete(projectId);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("Project deleted successfully.", responseEntity.getBody());
	}

	@Test
	void testGetProjectById() {
		Integer projectId = 1;
		Project project = new Project();
		Mockito.when(projectService.getProject(projectId)).thenReturn(project);

		ResponseEntity<Project> responseEntity = projectController.getPI(projectId);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(project, responseEntity.getBody());
	}

	@Test
	void testGetProjectByName() {
		String projectName = "TestProject";
		Project project = new Project();
		Mockito.when(projectService.getProjectByName(projectName)).thenReturn(project);

		ResponseEntity<Project> responseEntity = projectController.getPN(projectName);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(project, responseEntity.getBody());
	}

	@Test
	void testGetProjectByStartDate() {
		String startDate = "2023-01-01";
		Project project = new Project();
		Mockito.when(projectService.getProjectByStartDate(startDate)).thenReturn(project);

		ResponseEntity<Project> responseEntity = projectController.getPSD(startDate);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(project, responseEntity.getBody());
	}

	@Test
	void testGetProjectByEndDate() {
		String endDate = "2023-12-31";
		Project project = new Project();
		Mockito.when(projectService.getProjectByEndDate(endDate)).thenReturn(project);

		ResponseEntity<Project> responseEntity = projectController.getPED(endDate);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(project, responseEntity.getBody());
	}
}
