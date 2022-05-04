package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Department;

@Repository
public interface DeptRepository extends JpaRepository<Department, Long> {

	Department findBydeptName(String deptName);
	List<Department> findBydeptIdGreaterThan(long id);
}
