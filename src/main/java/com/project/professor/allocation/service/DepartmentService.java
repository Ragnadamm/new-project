package com.project.professor.allocation.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.professor.allocation.model.Department;
import com.project.professor.allocation.repository.DepartmentRepository;

@Service
public class DepartmentService {
	
	private DepartmentRepository departmentRepository;

	public DepartmentService(DepartmentRepository departmentRepository) {
		super();
		this.departmentRepository = departmentRepository;
	}
	
	public List<Department> findAll(String name) {
		if (name == null) {
			return departmentRepository.findAll();
		} else {
			return departmentRepository.findByNameContainingIgnoreCase(name);
		}
	}
	
	public Department findById(Long id) {
		return departmentRepository.findById(id).orElse(null);
	}
	
	public Department create(Department department) {
		department.setId(null);
		return departmentRepository.save(department);
	}
	
	public Department update(Department department) {
		return departmentRepository.save(department);
	}
	
	public void deleteById(Long id) {
		try {
			departmentRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteAll() {
		departmentRepository.deleteAllInBatch();
	}
}
