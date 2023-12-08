// EmployeeRepo class
package com.employeemanagementsystem.repo;

//importing neccessary packages
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.employeemanagementsystem.entity.Employee;

//creating a repo interface which extends JpaRepository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	// defining the findByMethods with the attribute names of the entity class
	public Optional<Employee> findByEmployeeName(String name);
	public Optional<Employee> findByEmail(String email);
	public Optional<Employee> findByAge(Integer age);
	public Optional<Employee> findByPhoneNumber(Long phone);
	public Optional<Employee> findByJobTitle(String title);
	public Optional<Employee> findByHireDate(String date);
	public Optional<Employee> findBySalary(Long salary);

}