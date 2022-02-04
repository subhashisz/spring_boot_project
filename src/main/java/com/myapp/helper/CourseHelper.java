package com.myapp.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.myapp.service.CourseService;

@Component
public class CourseHelper {
	
	@Autowired
	private CourseService courseService;

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
