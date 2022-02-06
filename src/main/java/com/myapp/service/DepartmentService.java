package com.myapp.service;

import java.util.List;

import com.myapp.exception.DepartmentNotFoundException;
import com.myapp.model.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);

	List<Department> fetchDepartmentList();

	Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	void deleteDepartmentById(Long departmentId);

	Department updateDepartment(Long departmentId, Department department);

	Department fetchDepartmentByName(String departmentName);
}
