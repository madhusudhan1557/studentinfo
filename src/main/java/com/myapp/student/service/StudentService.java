package com.myapp.student.service;

import java.util.List;

import javax.validation.Valid;

import com.myapp.student.entity.Student;
import com.myapp.student.request.CreateStudentRequest;
import com.myapp.student.request.UpdateStudentRequest;

public interface StudentService {

	List<Student> getAllStudents();

	Student createStudent(CreateStudentRequest studentRequest);

	Student getStudentById(Long id);

	Student updateStudent(@Valid UpdateStudentRequest studentRequest, Long id);
   
	void deleteStudent(Long id);

	List<Student> getStudentByFirstname(String firstname);

	List<Student> getStudentByFirstnameAndLaststname(String firstname, String lastname);

}
