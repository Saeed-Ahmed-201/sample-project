package com.sample.dto.request;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.sample.util.DTOEntity;

public class UpdateEmployeeRequestDto implements DTOEntity {
	
	private long id;
     
    @NotBlank(message = "first name can not be blank")
    @Size(min = 3, message = "first name must contain more than two character")
    private String firstName;
    
    @NotBlank(message = "last name can not be blank")
    @Size(min = 3, message = "last name must contain more than two character")
    private String lastName;
    
    @Email(message = "invalid email address")
    private String email;
    
    @Pattern(regexp = "^[0-9\\'-]+$", message = "phone number must contain numbers and dashes")
    private String phoneNumber;
    
    @Range(min = 1, message = "salary must be greater than 0")
    private double salary;
    
    private Date hireDate;
    
    private long departmentId;
    

	public UpdateEmployeeRequestDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public UpdateEmployeeRequestDto(long id,
			@NotBlank(message = "first name can not be blank") @Size(min = 3, message = "first name must contain more than two character") String firstName,
			@NotBlank(message = "last name can not be blank") @Size(min = 3, message = "last name must contain more than two character") String lastName,
			@Email(message = "invalid email address") String email,
			@Pattern(regexp = "^[0-9\\'-]+$", message = "phone number must contain numbers and dashes") String phoneNumber,
			@Range(min = 1, message = "salary must be greater than 0") double salary, Date hireDate,
			long departmentId) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.salary = salary;
		this.hireDate = hireDate;
		this.departmentId = departmentId;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
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


	public long getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}


}
