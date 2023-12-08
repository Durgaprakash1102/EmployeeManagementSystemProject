//Project entity class
package com.employeemanagementsystem.entity;

//importing neccessary packages
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


import lombok.Data;

//defining project entity class
@Entity
@Data // using lombok dependency by @data annotation
public class Project {
	// defining the attributes
	@Id
	private Integer projectId;
	private String projectName;
	private String startDate;
	private String endDate;

	// establishing ManyToMany relationship between project and employee
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;
	
}
