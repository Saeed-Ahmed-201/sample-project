package com.sample;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sample.model.Department;
import com.sample.repository.DepartmentRepository;

@SpringBootApplication
public class SampleApplication implements ApplicationRunner{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		  List<Department> depts = Arrays.asList(new Department("a"), new Department("b"), new Department("c"));
		departmentRepository.saveAll(depts);
	}

}
