package com.sample.dto.response;

import java.util.Date;

import com.sample.util.DTOEntity;



public class EmployeeResponseDto implements DTOEntity{
	

    private Long id;
 
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private double salary;
    private Date hireDate;
    private DepartmentInfo department;
    
    
	public EmployeeResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmployeeResponseDto(Long id, String firstName, String lastName, String email, String phoneNumber,
			double salary, Date hireDate, DepartmentInfo department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.hireDate = hireDate;
		this.department = department;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}


	public DepartmentInfo getDepartment() {
		return department;
	}


	public void setDepartment(DepartmentInfo department) {
		this.department = department;
	}
	
}

class DepartmentInfo {
	
	   private Long id;
	   private String departmentName;
  	   
	   public DepartmentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentInfo(Long id, String departmentName) {
		super();
		this.id = id;
		this.departmentName = departmentName;
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

		   
	   
}

