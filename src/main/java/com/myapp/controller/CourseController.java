package com.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.helper.CourseHelper;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseHelper courseHelper;

	public void printCourses() {
	}

	public void saveCourseWithTeacher() {
	}

	public void findAllPagination() {
	}

	public void findAllSorting() {
	}

	public void printfindByTitleContaining() {
	}

	public void saveCourseWithStudentAndTeacher() {
	}

}
