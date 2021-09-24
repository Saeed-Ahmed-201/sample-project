package com.sample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dto.request.EmployeeRequestDto;
import com.sample.dto.request.UpdateEmployeeRequestDto;
import com.sample.dto.response.EmployeeResponseDto;
import com.sample.exception.CustomException;
import com.sample.model.Employee;
import com.sample.service.EmployeeService;
import com.sample.util.Mapper;
import com.sample.util.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/employee")
@Api(value = "Employee Rest Controller", description ="Employee rest controller deals with the basic crud operation url")
public class EmployeeController {
	   @Autowired
	   private EmployeeService employeeService;
	   
	   @Autowired
	   private Mapper mapper;
	   
	   @ApiOperation(value = "Adds/Creates new employee into database")
	   @ApiResponses(value = {
			                   @ApiResponse(code = 201, message = "Return 200 status on success"),
			                   @ApiResponse(code = 400, message = "Return 400 status on bad request"),})
	   @PostMapping(value = "/add")
	   public ResponseEntity<?> addEmployee(@Valid @RequestBody EmployeeRequestDto employee) throws CustomException {
		   
		     if(employeeService.addEmployee(employee) != null) {
		    	 return ResponseEntity
		    			 .status(201)
		    			 .body(new Response("Record Added!", 201));
		     }
		     return ResponseEntity
	    			 .status(400)
	    			 .body(new Response("Something went bad!", 400));
		   
	   }
	   
	   @ApiOperation(value = "Deletes single record of employee given id from database")
	   @ApiResponses(value = {
			                   @ApiResponse(code = 201, message = "Return 201 status on success"),
			                   @ApiResponse(code = 400, message = "Return 400 status on bad request"),})
	   @DeleteMapping("/delete/{id}")
	   public ResponseEntity<?> deleteEmployee(@PathVariable(name = "id") Long employeeId) {
		      if(employeeService.deleteEmployee(employeeId)) {
		    	  return ResponseEntity
		    			  .status(201)
		    			  .body(new Response("Successfully deleted employee", 201));
		      }
		      return ResponseEntity
		    		  .status(404)
		    		  .body(new Response("Record does not exists", 404));
	   }
	   
	   @ApiOperation(value = "Retrieves/Selects single record of employee given id from database")
	   @ApiResponses(value = {
			                   @ApiResponse(code = 201, message = "Return 201 status on success"),
			                   @ApiResponse(code = 400, message = "Return 404 status if record not found"),})
	   @GetMapping("/record/{id}")
	   public ResponseEntity<?> retrieveSingleEmployee(@PathVariable(name = "id") Long employeeId) throws CustomException{
		      EmployeeResponseDto employee = employeeService.retrieveSingleEmployee(employeeId);
		      if(employee != null) {
		    	  return ResponseEntity
		    			  .status(201)
		    			  .body(employee);
		      }
		      return ResponseEntity
		    		  .status(404)
		    		  .body(new Response("Record does not exists with id : " + employeeId, 404));
	   }
	   
	   @ApiOperation(value = "Retrieves/Selects all employees from database using two parameters page and size")
	   @ApiResponses(value = {
			                   @ApiResponse(code = 201, message = "Return 201 status on success"),
			                   @ApiResponse(code = 400, message = "Return 404 status on not found any record"),})
	   @GetMapping("/all")
	   public ResponseEntity<?> retrieveAllEmployees(@RequestParam(name = "page", defaultValue = "0") int page,
			   @RequestParam(name = "size", defaultValue = "2") int size){
		      
		   Pageable pageable = PageRequest.of(page, size, Direction.DESC, "id");
		   List<EmployeeResponseDto> employees = employeeService.retrieveAllEmployees(pageable);
		   if(!employees.isEmpty()) {
			   return ResponseEntity
					   .status(201)
					   .body(employees);
		   }
		   return ResponseEntity
		    		  .status(404)
		    		  .body(new Response("0 records exists", 404));  
	   }
	   
	   @PutMapping(value = "/update")
	   public ResponseEntity<?> updateEmployee(@Valid @RequestBody UpdateEmployeeRequestDto employee) throws CustomException{
		      if(employeeService.updateEmployee(employee)) {
		    	  return ResponseEntity
		    			  .status(201)
		    			  .body(new Response("Successfully updated employee", 201));
		      }
		      return ResponseEntity
	    			  .status(404)
	    			  .body(new Response("Employee does not contain", 404));
	   }
	   
	   

}
