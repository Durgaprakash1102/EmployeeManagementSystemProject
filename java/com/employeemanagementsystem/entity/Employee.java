//Employee Entity class
package com.employeemanagementsystem.entity;

//importing the neccessary packages
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


import lombok.Data;

//defining the employee entity class 
@Entity
@Data // using lombok dependency by @data annotation
public class Employee {
	// defining the attributes
	@Id
	private Integer employeeId;
	private String employeeName;
	private String email;
	private Integer age;
	private Long phoneNumber;
	private String hireDate;
	private String jobTitle;
	private Long salary;
//	private Integer departmentId;
//	private Integer projectId;

	// establishing ManyToOne relationship between employee and department
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	
	@JoinColumn(name = "departmentId")
	private Department department;

	// establishing ManyToMany relationship between employee and project
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "employeeId"), inverseJoinColumns = @JoinColumn(name = "projectId"))
	private List<Project> projects;
	
}
