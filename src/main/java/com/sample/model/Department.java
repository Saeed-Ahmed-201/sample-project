package com.sample.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "department")
public class Department {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "department_id")
	  private Long id;
	  
	  @Column(name = "department_name", length = 30)
	  private String departmentName;
	  
	  @OneToMany(mappedBy = "department",  fetch = FetchType.EAGER, orphanRemoval = true)
	  private List<Employee> employees;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Department(String departmentName) {
	       this.departmentName = departmentName;
	}

	public Department(Long id, String departmentName, List<Employee> employees) {
		super();
		this.id = id;
		this.departmentName = departmentName;
		this.employees = employees;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@JsonManagedReference
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	  
	  

}
