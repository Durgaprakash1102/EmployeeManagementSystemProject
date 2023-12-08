// DepartmentRepo class
package com.employeemanagementsystem.repo;

//importing neccessary packages
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.employeemanagementsystem.entity.Department;

//creating a repo interface which extends JpaRepository
public interface DepartmentRepo extends JpaRepository<Department, Integer> {

	// defining the findByMethods with the attribute names of the entity class
	public Optional<Department> findByDepartmentName(String departmentname);
	public Optional<Department> findByLocation(String location);

}