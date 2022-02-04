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

	public void printCourses() {
		List<Course> courses = courseRepository.findAll();
		System.out.println("courses = " + courses);
	}

	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder().firstName("Priyanka").lastName("Singh").build();
		Course course = Course.builder().title("Python").credit(6).teacher(teacher).build();

		courseRepository.save(course);
	}

	public void findAllPagination() {
		Pageable firstPagewithThreeRecords = PageRequest.of(0, 3);
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

		List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();
		long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();
		long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

		System.out.println("totalPages = " + totalPages);
		System.out.println("totalElements = " + totalElements);
		System.out.println("courses = " + courses);
	}

	public void findAllSorting() {
		Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));
		Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());
		Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));
		List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
		System.out.println("courses = " + courses);
	}

	public void printfindByTitleContaining() {
		Pageable firstPageTenRecords = PageRequest.of(0, 10);
		List<Course> courses = courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();
		System.out.println("courses = " + courses);
	}

	public void saveCourseWithStudentAndTeacher() {
		Teacher teacher = Teacher.builder().firstName("Lizze").lastName("Morgan").build();
		Student student = Student.builder().firstName("Abhishek").lastName("Singh").emailId("abhishek@gmail.com")
				.build();
		Course course = Course.builder().title("AI").credit(12).teacher(teacher).build();
		course.addStudents(student);
		courseRepository.save(course);
	}

}
