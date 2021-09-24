package com.sample.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sample.dto.request.EmployeeRequestDto;
import com.sample.dto.request.UpdateEmployeeRequestDto;
import com.sample.dto.response.EmployeeResponseDto;
import com.sample.exception.CustomException;
import com.sample.model.Department;
import com.sample.model.Employee;
import com.sample.repository.DepartmentRepository;
import com.sample.repository.EmployeeRepository;
import com.sample.util.Mapper;

@Service
public class EmployeeService {
	
	   @Autowired
	   private EmployeeRepository employeeRepository;
	   
	   @Autowired
	   private DepartmentRepository departmentRepository;
	   
	   @Autowired
	   private Mapper mapper;
	   
	   public Employee addEmployee(EmployeeRequestDto employee) throws CustomException {
		   try {
		      Employee newEmployee= (Employee) mapper.convertToEntity(new Employee(), employee);
		      Department department = departmentRepository.findById(employee.getDepartmentId()).get();
		      newEmployee.setDepartment(department);
		      return employeeRepository.save(newEmployee);
		   }
		   catch(DataIntegrityViolationException ex) {
			   throw new CustomException("Email address already exists");
		   }
		   catch(Exception ex) {
			   System.out.println(ex.getMessage());
			   throw new CustomException("Not found such element of department so kindly provide valid department");
		   }
	  }
	   
	  public boolean deleteEmployee(Long employeeId) {		    
		     boolean recordExist = false;
		     if(employeeRepository.existsById(employeeId)) {
		    	 employeeRepository.deleteById(employeeId);
		    	 recordExist = true;
		     }
		     return recordExist;
	  }
	   
	  	  
	  public EmployeeResponseDto retrieveSingleEmployee(Long employeeId) {
		   EmployeeResponseDto employee = null;
		   Optional<Employee> emp = employeeRepository.findById(employeeId);
		   if(emp.isPresent()) {
			   employee = (EmployeeResponseDto) mapper.convertToDto(emp.get(), new EmployeeResponseDto());			   
		   }
		   return employee;
	  }
	  
	  public List<EmployeeResponseDto> retrieveAllEmployees(Pageable pageable){
		  List<EmployeeResponseDto> list = new ArrayList<>();
		  List<Employee> employees = employeeRepository.findAll(pageable).getContent();
		  employees.forEach(employee -> {
			  EmployeeResponseDto employeeDto = (EmployeeResponseDto) mapper.convertToDto(employee, new EmployeeResponseDto());
			  list.add(employeeDto);
		  });
	      return list;
	  }
	  
	  
	  public boolean updateEmployee(UpdateEmployeeRequestDto employee) throws CustomException {
		     boolean recordExist = false;
		       try {
		         if(employeeRepository.existsById(employee.getId())) {		    	 
				     Employee updateEmployee = employeeRepository.findById(employee.getId()).get();
		             Department department = departmentRepository.findById(employee.getDepartmentId()).get();
				     updateEmployee.setFirstName(employee.getFirstName());
				     updateEmployee.setLastName(employee.getLastName());
				     updateEmployee.setEmail(employee.getEmail());
				     updateEmployee.setPhoneNumber(employee.getPhoneNumber());
				     updateEmployee.setSalary(employee.getSalary());
				     updateEmployee.setDepartment(department);
				     employeeRepository.save(updateEmployee);		     
				     recordExist = true;
			     }
		       }
		         catch(Exception ex) {
					   throw new CustomException("Could not updated record because department not exists!");
				   }
		     return recordExist;
		     
	  }

}
