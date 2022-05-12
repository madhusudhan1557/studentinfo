package com.myapp.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapp.student.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByFirstname(String firstname);
	List<Student> findByFirstnameAndLastname(String firstname, String lastname);
	List<Student> findByFirstnameOrLastname(String firstname, String lastname);
	List<Student> findByFirstnameIn(List<String> firstnames);
}
