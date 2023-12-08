/*//Department Entity class
package com.employeemanagementsystem.entity;

//importing neccessary packages
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

//defining the department entity class
@Entity
@Data // using lombok dependency by @data annotation
public class Department {
	// defining the attributes
	@Id
	private Integer departmentId;
	private String departmentName;
	private String location;

	// establishing OneToMany relationship between department and employee
	 //@JsonManagedReference
	@OneToMany(mappedBy = "department")
	private List<Employee> employees;
	
}
*/
package com.employeemanagementsystem.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Entity
@Data
public class Department {
    @Id
    private Integer departmentId;
    private String departmentName;
    private String location;

    @OneToMany(mappedBy = "department")
    @JsonIgnoreProperties("department")
    private List<Employee> employees;

}
