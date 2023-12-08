//ProjectRepo class
package com.employeemanagementsystem.repo;

//importing neccessary packages
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employeemanagementsystem.entity.Project;

//creating a repo interface which extends JpaRepository
public interface ProjectRepo extends JpaRepository<Project, Integer> {

	// defining the findByMethods with the attribute names of the entity class
	public Optional<Project> findByProjectName(String name);
	public Optional<Project> findByStartDate(String startdate);
	public Optional<Project> findByEndDate(String endate);

}
