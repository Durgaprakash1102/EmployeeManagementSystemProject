//DepartmentControllerTest class for junit testing
package com.employeemanagementsystem.EmployeeManagementSystem;

//importing neccessary packages and classes
import com.employeemanagementsystem.controller.DepartmentController;
import com.employeemanagementsystem.entity.Department;
import com.employeemanagementsystem.service.DepartmentService;
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

class DepartmentControllerTest {
	private DepartmentController departmentController;

	// creating mock bean for departmentservice
	@Mock
	private DepartmentService departmentService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		departmentController = new DepartmentController(departmentService);
	}

	// creating methods for testing the methods of the controller class and
	// verifying the expected and actual output
	@Test
	void testGetAllDepartments() {
		List<Department> departments = Arrays.asList(new Department(), new Department());
		Mockito.when(departmentService.getAllDepartments()).thenReturn(departments);

		ResponseEntity<List<Department>> responseEntity = departmentController.getall();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(departments, responseEntity.getBody());
	}

	@Test
	void testInsertDepartment() {
		Department department = new Department();
		Mockito.when(departmentService.insertDepartment(department)).thenReturn("Department inserted successfully.");

		ResponseEntity<String> responseEntity = departmentController.insert(department);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("Department inserted successfully.", responseEntity.getBody());
	}

	@Test
	void testUpdateDepartment() {
		Department department = new Department();
		Mockito.when(departmentService.updateDepartment(department)).thenReturn("Department updated successfully.");

		ResponseEntity<String> responseEntity = departmentController.update(department);

		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("Department updated successfully.", responseEntity.getBody());
	}

	@Test
	void testDeleteDepartment() {
		Integer departmentId = 1;
		Mockito.when(departmentService.deleteDepartment(departmentId)).thenReturn("Department deleted successfully.");

		ResponseEntity<String> responseEntity = departmentController.delete(departmentId);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("Department deleted successfully.", responseEntity.getBody());
	}

	@Test
	void testGetDepartmentById() {
		Integer departmentId = 1;
		Department department = new Department();
		Mockito.when(departmentService.getDepartment(departmentId)).thenReturn(department);

		ResponseEntity<Department> responseEntity = departmentController.get(departmentId);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(department, responseEntity.getBody());
	}

	@Test
	void testGetDepartmentByName() {
		String departmentName = "TestDepartment";
		Department department = new Department();
		Mockito.when(departmentService.getDepartmentByName(departmentName)).thenReturn(department);

		ResponseEntity<Department> responseEntity = departmentController.getDN(departmentName);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(department, responseEntity.getBody());
	}

	@Test
	void testGetDepartmentByLocation() {
		String location = "TestLocation";
		Department department = new Department();
		Mockito.when(departmentService.getDepartmentByLocation(location)).thenReturn(department);

		ResponseEntity<Department> responseEntity = departmentController.getDL(location);

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(department, responseEntity.getBody());
	}
}
