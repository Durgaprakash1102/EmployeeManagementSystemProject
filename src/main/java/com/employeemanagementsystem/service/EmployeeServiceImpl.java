//EmployeeServiceImpl classs
package com.employeemanagementsystem.service;

//Importing all the neccessary packages and classes
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagementsystem.entity.Employee;
import com.employeemanagementsystem.repo.EmployeeRepo;

//service class
@Service
//EmployeeServiceImpl which implements EmployeeService interface 
public class EmployeeServiceImpl implements EmployeeService {
	// dependency injection of employeerepo interface
	@Autowired
	EmployeeRepo emprepo;

	// defining constructor for dependency injection
	public EmployeeServiceImpl(EmployeeRepo emprepo) {
		super();
		this.emprepo = emprepo;
	}

	// overriding all the methods in the EmployeeService interface and giving implementation for the methods
	@Override
	public Employee getEmployee(Integer id) {
		Optional<Employee> e = emprepo.findById(id);
		Employee e1 = e.get();
		return e1;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = emprepo.findAll();
		return list;
	}

	@Override
	public String insertEmployee(Employee e) {
		emprepo.save(e);
		return "One Employee Record has been inserted";
	}

	@Override
	public String updateEmployee(Employee e) {
		emprepo.save(e);
		return "One Employee Record has been updated";
	}

	@Override
	public String deleteEmployee(Integer id) {
		emprepo.deleteById(id);
		return "one employee recored has been deleted";
	}

	@Override
	public Employee getEmployeeByName(String name) {
		Optional<Employee> e = emprepo.findByEmployeeName(name);
		Employee e1 = e.get();
		return e1;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
		Optional<Employee> e = emprepo.findByEmail(email);
		Employee e1 = e.get();
		return e1;
	}

	@Override
	public Employee getEmployeeByAge(Integer age) {
		Optional<Employee> e = emprepo.findByAge(age);
		Employee e1 = e.get();
		return e1;
	}

	@Override
	public Employee getEmployeeByPhoneNumber(Long phone) {
		Optional<Employee> e = emprepo.findByPhoneNumber(phone);
		Employee e1 = e.get();
		return e1;
	}

	@Override
	public Employee getEmployeeByJobTitle(String title) {
		Optional<Employee> e = emprepo.findByJobTitle(title);
		Employee e1 = e.get();
		return e1;
	}

	@Override
	public Employee getEmployeeByHireDate(String date) {
		Optional<Employee> e = emprepo.findByHireDate(date);
		Employee e1 = e.get();
		return e1;
	}

	@Override
	public Employee getEmployeeBySalary(Long salary) {
		Optional<Employee> e = emprepo.findBySalary(salary);
		Employee e1 = e.get();
		return e1;
	}

}
