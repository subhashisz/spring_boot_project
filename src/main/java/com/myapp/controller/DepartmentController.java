package com.myapp.controller;

import java.util.List;

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

import com.myapp.exception.DepartmentNotFoundException;
import com.myapp.helper.DepartmentHelper;
import com.myapp.model.Department;

@RestController
//@RequestMapping("/department")
public class DepartmentController {

	private Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentHelper departmentHelper;

	@PostMapping("/departments")
	public Department saveDepartment(@RequestBody Department department) {
		logger.info("saveDepartment() ----> {}", logger.getName());
		return departmentHelper.saveDepartment(department);
	}

	@GetMapping("/departments")
	public List<Department> fetchDepartmentList() {
		logger.info("fetchDepartment() ----> {}", logger.getName());
		return departmentHelper.fetchDepartmentList();
	}

	@GetMapping("/departments/{departmentId}")
	public Department fetchDepartmentById(@PathVariable("departmentId") Long departmentId)  {
		logger.info("fetchDepartmentById() ----> {}", logger.getName());
		return departmentHelper.fetchDepartmentById(departmentId);
	}

	@DeleteMapping("/departments/{departmentId}")
	public void deleteDepartmentById(@PathVariable("departmentId") Long departmentId) {
		logger.info("deleteDepartmentById() ----> {}", logger.getName());
		departmentHelper.deleteDepartmentById(departmentId);
	}

	@PutMapping("/departments/{departmentId}")
	public Department updateDepartment(@PathVariable("departmentId") Long departmentId,
			@RequestBody Department department) {
		logger.info("updateDepartmentById() ----> {}", logger.getName());
		return departmentHelper.updateDepartment(departmentId, department);
	}

	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departmentName) {
		logger.info("fetchDepartmentByName() ----> {}", logger.getName());
		return departmentHelper.fetchDepartmentByName(departmentName);
	}

}
