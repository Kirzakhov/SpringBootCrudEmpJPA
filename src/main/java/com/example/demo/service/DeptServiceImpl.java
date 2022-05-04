package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;
import com.example.demo.repository.DeptRepository;

@Service
public class DeptServiceImpl implements DeptService{
	@Autowired
	DeptRepository repo;
	@Override
	public Department saveDept(Department dept) {
		repo.save(dept);
		return dept;
	}
	@Override
	public List<Department> fetchDeptList() {
		List<Department> list = repo.findAll();
		return list;
	}
	@Override
	public Department fetchDeptById(Long did) throws DepartmentNotFoundException {
		Optional<Department> dept = repo.findById(did);
		if(!dept.isPresent())
			throw new DepartmentNotFoundException("Department not found");
		else
			return dept.get();
	}
	@Override
	public String deleteDeptById(Long did) {
		if(repo.existsById(did)) {
			repo.deleteById(did);
			return "Data deleted succesfully";
		}
		return "Data not present";
	}
	@Override
	public Department updateDept(Long did, Department dept) {
		Department depDB=repo.findById(did).get();
		if(Objects.nonNull(dept.getDeptName()) && !"".equalsIgnoreCase(dept.getDeptName())) {
			depDB.setDeptName(dept.getDeptName());
			
		}
		if(Objects.nonNull(dept.getDeptAddress()) && !"".equalsIgnoreCase(dept.getDeptAddress())) {
			depDB.setDeptAddress(dept.getDeptAddress());
			System.out.println(dept.getDeptAddress());
		}
		return repo.save(depDB);
	}
	@Override
	public Department fetchDeptByName(String deptName) {
		Department d= repo.findBydeptName(deptName);
		return d;
	}
	@Override
	public List<Department> fetchDeptByIdGreaterThan(Long id) {
		return repo.findBydeptIdGreaterThan(id);
	}

}
