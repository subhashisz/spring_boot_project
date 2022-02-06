package com.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myapp.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{

}
