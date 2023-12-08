/*//Employee Entity class
package com.employeemanagementsystem.entity;

//importing the neccessary packages
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@ManyToOne(optional=false,cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	
	@JoinColumn(name = "departmentId")
	private Department department;

	// establishing ManyToMany relationship between employee and project
	@JsonBackReference
	//@JsonIgnore
	@ManyToMany
	@JoinTable(name = "employee_project", joinColumns = @JoinColumn(name = "employeeId"), inverseJoinColumns = @JoinColumn(name = "projectId"))
	private List<Project> projects;
	
}
*/
package com.employeemanagementsystem.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
public class Employee {
    @Id
    private Integer employeeId;
    private String employeeName;
    private String email;
    private Integer age;
    private Long phoneNumber;
    private String hireDate;
    private String jobTitle;
    private Long salary;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    @JsonIgnoreProperties("employees")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "projectId")
    @JsonIgnoreProperties("employees")
    private Project project;
}
