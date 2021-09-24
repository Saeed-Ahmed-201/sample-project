package com.sample.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "employee")
public class Employee {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "employee_id")
	    private Long id;
	    
	    @Column(name = "first_name", length = 20)
	    private String firstName;
	    @Column(name = "last_name", length = 25)
	    private String lastName;
	    @Column(name = "email", length = 25, unique = true)
	    private String email;
	    @Column(name = "phone_number", length = 25)
	    private String phoneNumber;
	    @Column(name = "salary", columnDefinition="decimal(8,2)")
	    private double salary;
	    
	    @Temporal(TemporalType.DATE)
	    @Column(name = "hire_date")
	    private Date hireDate;
	    
	    @ManyToOne(fetch = FetchType.EAGER)
	    @JsonBackReference
	    @JoinColumn(name = "department", nullable = false)
	    private Department department;
	    
		public Employee() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Employee(Long id, String firstName, String lastName, String email, String phoneNumber, double salary,
				Date hireDate, Department department) {
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

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		

}
