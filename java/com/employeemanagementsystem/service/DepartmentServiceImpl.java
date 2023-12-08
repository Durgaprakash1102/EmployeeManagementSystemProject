//DepartmentServiceImpl class
package com.employeemanagementsystem.service;

//Importing all the neccessary packages and classes
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagementsystem.entity.Department;
import com.employeemanagementsystem.repo.DepartmentRepo;

//service class
@Service
//DepartmentServiceImpl which implements DepartmentService interface 
public class DepartmentServiceImpl implements DepartmentService {
	// dependency injection of departmentrepo interface
	@Autowired
	DepartmentRepo deptrepo;

	// defining constructor for dependency injection
	public DepartmentServiceImpl(DepartmentRepo deptrepo) {
		super();
		this.deptrepo = deptrepo;
	}

	// overriding all the methods in the EmployeeService interface and giving implementation for the methods
	@Override
	public Department getDepartment(Integer id) {
		Optional<Department> d = deptrepo.findById(id);
		Department d1 = d.get();
		return d1;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> list = deptrepo.findAll();
		return list;
	}

	@Override
	public String insertDepartment(Department d) {
		deptrepo.save(d);
		return "One Department record inserted";
	}

	@Override
	public String updateDepartment(Department d) {
		deptrepo.save(d);
		return "One Department record updated";
	}

	@Override
	public String deleteDepartment(Integer id) {
		deptrepo.deleteById(id);
		return "One Department record deleted";
	}

	@Override
	public Department getDepartmentByName(String departmentname) {
		Optional<Department> d = deptrepo.findByDepartmentName(departmentname);
		Department d1 = d.get();
		return d1;
	}

	@Override
	public Department getDepartmentByLocation(String location) {
		Optional<Department> d = deptrepo.findByLocation(location);
		Department d1 = d.get();
		return d1;
	}

}
