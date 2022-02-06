package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.myapp.model.Course;
import com.myapp.model.Student;
import com.myapp.model.Teacher;
import com.myapp.repository.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;

	public List<Course> findAllCourses() {
		return courseRepository.findAll();
	}

	public Course saveCourseWithTeacher(Teacher teacher, Course course) {
		return courseRepository.save(Course.builder().title(course.getTitle()).credit(course.getCredit())
				.teacher(Teacher.builder().firstName(teacher.getFirstName()).lastName(teacher.getLastName()).build())
				.build());
	}

	public void findAllPagination() {
		Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords = PageRequest.of(0, 2);

		List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
		long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
		long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

	}

	public void findAllSorting() {
		Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
		Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

		List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

	}

	public void findByTitleContaining() {
		Pageable firstPageTenRecords = PageRequest.of(0, 10);
		List<Course> courses = courseRepository.findByTitleContaining("J", firstPageTenRecords).getContent();

	}

	public void saveCourseWithStudentAndTeacher() {

		Teacher teacher = Teacher.builder().firstName("Samuel").lastName("Morgan").build();
		Student student = Student.builder().firstName("Michael").lastName("Jackson").emailId("michael@gmail.com")
				.build();

		Course course = Course.builder().title("ML").credit(12).teacher(teacher).build();
		course.addStudents(student);

		courseRepository.save(course);
	}
}
