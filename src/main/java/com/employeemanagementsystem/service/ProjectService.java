//ProjectService interface
package com.employeemanagementsystem.service;

//importing all neccessary packages
import java.util.List;

import com.employeemanagementsystem.entity.Project;

public interface ProjectService {
	
	// defining all the CRUD and findByMethods of the Project entity class
	public Project getProject(Integer id);
	public List<Project> getAllProjects();
	public String insertProject(Project e);
	public String updateProject(Project e);
	public String deleteProject(Integer id);
	public Project getProjectByName(String name);
	public Project getProjectByStartDate(String startdate);
	public Project getProjectByEndDate(String endate);

}