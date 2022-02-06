package com.myapp.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.exception.DepartmentNotFoundException;
import com.myapp.model.Department;
import com.myapp.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		logger.info("saveDepartment() ----> {}", logger.getName());
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		logger.info("fetchDepartment() ----> {}", logger.getName());
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) {
		logger.info("fetchDepartmentById() ----> {}", logger.getName());
		/*
		 * Optional<Department> department =
		 * departmentRepository.findById(departmentId); if (!department.isPresent()) {
		 * logger.info("...............EXCEPTION............"); throw new
		 * DepartmentNotFoundException("Department Not Available"); }
		 */

		return departmentRepository.findById(departmentId).orElseThrow();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		logger.info("deleteDepartmentById() ----> {}", logger.getName());
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		logger.info("deleteDepartmentById() ----> {}", logger.getName());
		Department departmentObj = departmentRepository.findById(departmentId).get();
		if (Objects.nonNull(department.getDepartmentName()) && "".equals(department.getDepartmentName())) {
			departmentObj.setDepartmentName(department.getDepartmentName());
		}
		if (Objects.nonNull(department.getDepartmentAddress()) && "".equals(department.getDepartmentAddress())) {
			departmentObj.setDepartmentAddress(department.getDepartmentAddress());
		}
		if (Objects.nonNull(department.getDepartmentCode()) && "".equals(department.getDepartmentCode())) {
			departmentObj.setDepartmentCode(department.getDepartmentCode());
		}
		return departmentRepository.save(departmentObj);
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		logger.info("fetchDepartmentByName()-----> {}", logger.getName());
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

}
