//EmployeeService class
package com.employeemanagementsystem.service;

//importing all neccessary packages
import java.util.List;

import com.employeemanagementsystem.entity.Employee;

public interface EmployeeService {
	
	//defining all the CRUD and findByMethods of the Employee entity class
	public Employee getEmployee(Integer id);
	public List<Employee> getAllEmployees();
	public String insertEmployee(Employee e);
	public String updateEmployee(Employee e);
	public String deleteEmployee(Integer id);
	public Employee getEmployeeByName(String name);
	public Employee getEmployeeByEmail(String email);
	public Employee getEmployeeByAge(Integer age);
	public Employee getEmployeeByPhoneNumber(Long phone);
	public Employee getEmployeeByJobTitle(String title);
	public Employee getEmployeeByHireDate(String date);
	public Employee getEmployeeBySalary(Long salary);
	

}
