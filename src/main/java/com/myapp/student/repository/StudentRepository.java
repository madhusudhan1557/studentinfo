package com.myapp.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> getByFirstname(String firstname);
	List<Student> getByFirstnameAndLastname(String firstname, String lastname);
	List<Student> getByFirstnameOrLastname(String firstname, String lastname);
}
