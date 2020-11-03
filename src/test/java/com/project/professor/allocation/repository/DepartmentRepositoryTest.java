package com.project.professor.allocation.repository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.model.Department;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
public class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Test
	public void readAll() {
		List<Department> departments = departmentRepository.findAll();
		
		for (Department department : departments) {
			System.out.println(department);
		}
	}
	
	@Test
	public void readById() {
		Long id = 1L;
		
		Optional<Department> optionalDepartment = departmentRepository.findById(id);
		Department department = optionalDepartment.orElse(null);
		
		System.out.println(department);
	}
	
	@Test
	public void create() {
		Department department = new Department();
		department.setId(10L);
		department.setName("Departamento de Teste 2");
		
		Department department2 = departmentRepository.save(department);
		System.out.println(department2);
	}
	
	@Test
	public void update() {
		Department department = new Department();
		department.setId(1L);
		department.setName("Departamento de Teste 3");
		
		Department department2 = departmentRepository.save(department);
		System.out.println(department2);
	}
	
	@Test
	public void deleteAll() {
		departmentRepository.deleteAllInBatch();
	}
	
	@Test
	public void deleteById() {
		Long id = 1L;
		
		departmentRepository.deleteById(id);
	}

}
