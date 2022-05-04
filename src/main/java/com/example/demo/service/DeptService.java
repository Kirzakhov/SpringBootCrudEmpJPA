package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;

public interface DeptService {

	public Department saveDept(Department dept);
	
	public List<Department> fetchDeptList();

	public Department fetchDeptById(Long did) throws DepartmentNotFoundException;

	public String deleteDeptById(Long did);

	public Department updateDept(Long did, Department dept);

	public Department fetchDeptByName(String deptName);

	public List<Department> fetchDeptByIdGreaterThan(Long id);
	
}
