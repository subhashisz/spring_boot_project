package com.myapp.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.myapp.model.Course;
import com.myapp.model.Student;
import com.myapp.model.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository courseRepository;

	@Test
	public void findCourses() {
		List<Course> courses = courseRepository.findAll();
		System.out.println("courses = " + courses);
	}
	// @Test
	/*
	 * public void saveCourseWithTeacher() { Teacher teacher = Teacher.builder()
	 * .firstName("Priyanka") .lastName("Singh") .build();
	 * 
	 * Course course = Course .builder() .title("Python") .credit(6)
	 * .teacher(teacher) .build();
	 * 
	 * courseRepository.save(course); }
	 */
	 
	    @Test
	    public void findAllPagination(){
	    	
	    }

}