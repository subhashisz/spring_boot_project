package com.myapp.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.myapp.model.Course;
import com.myapp.model.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {

	@Autowired
	CourseMaterialRepository courseMaterialRepository;

	//@Test
	public void saveCourseMaterial() {
		Course course = Course.builder().title("DSA").credit(5).build();
		CourseMaterial courseMaterial = CourseMaterial.builder().url("www.google.com").course(course).build();
		courseMaterialRepository.save(courseMaterial);
	}

	//@Test
	public void findAllCourses() {
		List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
		System.out.println(courseMaterials);
	}

}
