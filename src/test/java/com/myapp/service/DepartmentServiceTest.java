package com.myapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.myapp.model.Department;
import com.myapp.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;
	
	@MockBean
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() throws Exception {
		 Department department =Department.builder()
				 .departmentName("IT")
				 .departmentCode("007")
				 .departmentAddress("Bangalore")
				 .departmentId(1L)
				 .build();
		 
		 Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
	}

	@Test
	@DisplayName("Getting Department according to department name")
	//@Disabled
	void whenValidDepartmentName_thenDepartmentShouldFound() {
		String departmentName = "IT";
		Department found = departmentService.fetchDepartmentByName(departmentName);

		assertEquals(departmentName, found.getDepartmentName());

	}

}
