package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.service.DeptService;

@RestController
public class DeptController {
	@Autowired
	DeptService deptService;
	
	//Loggers are helpful for debugging application
	private final Logger LOGGER = LoggerFactory.getLogger(DeptController.class);

	
	@PostMapping("departments")
	public Department saveDepartment(@Valid @RequestBody Department dept) {
		LOGGER.info("Inside save Department");
		return deptService.saveDept(dept);
	}
	@GetMapping("departments")
	public List<Department> getDepartment(){
		LOGGER.info("Inside fetch Department List");
		return deptService.fetchDeptList();
	}
	@GetMapping("departments/id/{id}")
	public Department getDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
		LOGGER.info("Inside fetch Department by Id");
		return deptService.fetchDeptById(id);
	}
	@GetMapping("departments/idgt/{id}")
	public List<Department> getDepartmentByIdGreaterThan(@PathVariable Long id) {
		return deptService.fetchDeptByIdGreaterThan(id);
	}
	
	@GetMapping("departments/name/{deptName}")
	public Department getDepartmentByName(@PathVariable String deptName) {
		return deptService.fetchDeptByName(deptName);
	}
	
	
	@PutMapping("departments/{id}")
	public Department updateDepartment(@PathVariable Long id, @RequestBody Department dept) {
		return deptService.updateDept(id, dept);
	}
	@DeleteMapping("departments/{id}")
	public String deleteDepartmentById(@PathVariable Long id) {
		return deptService.deleteDeptById(id);
	}
}
