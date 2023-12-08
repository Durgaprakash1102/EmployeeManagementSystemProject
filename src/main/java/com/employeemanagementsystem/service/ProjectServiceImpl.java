//ProjectServiceImpl classs
package com.employeemanagementsystem.service;

//Importing all the neccessary packages and classes
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employeemanagementsystem.entity.Project;
import com.employeemanagementsystem.repo.ProjectRepo;

//service class
@Service
//ProjectServiceImpl which implements ProjectService interface 
public class ProjectServiceImpl implements ProjectService {
	// dependency injection of projectrepo interface
	@Autowired
	ProjectRepo pjtrepo;

	// defining constructor for dependency injection
	public ProjectServiceImpl(ProjectRepo pjtrepo) {
		super();
		this.pjtrepo = pjtrepo;
	}

	// overriding all the methods in the EmployeeService interface and giving
	// implementation for the methods
	@Override
	public Project getProject(Integer id) {
		Optional<Project> p = pjtrepo.findById(id);
		Project p1 = p.get();
		return p1;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> list = pjtrepo.findAll();
		return list;
	}

	@Override
	public String insertProject(Project p) {
		pjtrepo.save(p);
		return "One Project record inserted successfully";
	}

	@Override
	public String updateProject(Project p) {
		pjtrepo.save(p);
		return "One Project record updated successfully";
	}

	@Override
	public String deleteProject(Integer id) {
		pjtrepo.deleteById(id);
		return "One Project record deleted successfully";
	}

	@Override
	public Project getProjectByName(String name) {
		Optional<Project> p = pjtrepo.findByProjectName(name);
		Project p1 = p.get();
		return p1;
	}

	@Override
	public Project getProjectByStartDate(String startdate) {
		Optional<Project> p = pjtrepo.findByStartDate(startdate);
		Project p1 = p.get();
		return p1;
	}

	@Override
	public Project getProjectByEndDate(String endate) {
		Optional<Project> p = pjtrepo.findByEndDate(endate);
		Project p1 = p.get();
		return p1;
	}

}
