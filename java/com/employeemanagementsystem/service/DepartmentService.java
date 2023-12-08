//DepartmentService interface
package com.employeemanagementsystem.service;

//importing all the neccessary packages
import java.util.List;

import com.employeemanagementsystem.entity.Department;

public interface DepartmentService {

	// defining all the CRUD and findByMethods of the Department entity class
	public Department getDepartment(Integer id);
	public List<Department> getAllDepartments();
	public String insertDepartment(Department d);
	public String updateDepartment(Department d);
	public String deleteDepartment(Integer id);
	public Department getDepartmentByName(String name);
	public Department getDepartmentByLocation(String location);

}
