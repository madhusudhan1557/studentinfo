package com.myapp.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.student.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

}
