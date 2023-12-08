/*//Project entity class
package com.employeemanagementsystem.entity;

//importing neccessary packages
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
//	 @JsonManagedReference
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;
	
}
*/
// Project entity class
package com.employeemanagementsystem.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
public class Project {
    @Id
    private Integer projectId;
    private String projectName;
    private String startDate;
    private String endDate;

    @OneToMany(mappedBy = "project")
   
    @JsonIgnoreProperties("project")
    private List<Employee> employees;
}

