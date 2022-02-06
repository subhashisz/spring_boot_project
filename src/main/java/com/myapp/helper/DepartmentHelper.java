package com.myapp.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myapp.exception.DepartmentNotFoundException;
import com.myapp.model.Department;
import com.myapp.service.DepartmentServiceImpl;

@Component
public class DepartmentHelper {
	
	private Logger logger=LoggerFactory.getLogger(DepartmentHelper.class);

	@Autowired
	private DepartmentServiceImpl departmentService;

	public Department saveDepartment(Department department) {
		logger.info("saveDepartment() ----> {}",logger.getName());
		return departmentService.saveDepartment(department);
	}

	public List<Department> fetchDepartmentList() {
		logger.info("fetchDepartment() ----> {}",logger.getName());
		return departmentService.fetchDepartmentList();
	}

	public Department fetchDepartmentById(Long departmentId)  {
		logger.info("fetchDepartmentById() ----> {}",logger.getName());
		return departmentService.fetchDepartmentById(departmentId);
	}

	public void deleteDepartmentById(Long departmentId) {
		logger.info("deleteDepartmentById() ----> {}",logger.getName());
		departmentService.deleteDepartmentById(departmentId);
	}

	public Department updateDepartment(Long departmentId,Department department) {
		logger.info("deleteDepartmentById() ----> {}",logger.getName());
		return departmentService.updateDepartment(departmentId,department);
	}

	public Department fetchDepartmentByName(String departmentName) {
		logger.info("fetchDepartmentByName() ----> {}",logger.getName());
		return departmentService.fetchDepartmentByName(departmentName);
	}

}
