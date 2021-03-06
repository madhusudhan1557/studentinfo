package com.myapp.student.service.implementation;

import java.util.List;


import java.util.Objects;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.student.entity.Faculty;
import com.myapp.student.entity.Student;
import com.myapp.student.repository.FacultyRepository;
import com.myapp.student.repository.StudentRepository;
import com.myapp.student.request.CreateStudentRequest;
import com.myapp.student.request.StudentInQueryRequest;
import com.myapp.student.request.UpdateStudentRequest;
import com.myapp.student.service.StudentService;

@Service
@Transactional
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private FacultyRepository facultyRepo;
	

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student createStudent(CreateStudentRequest studentRequest) {
		Student student = new Student(studentRequest);
        Faculty faculty = new Faculty();
        faculty = facultyRepo.findByTitle(studentRequest.getFaculty());
        student.setFaculty(faculty);
        Student createdStudent = studentRepo.save(student);
	    return createdStudent;
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public Student updateStudent(@Valid UpdateStudentRequest studentRequest, Long id) {

		Student student = studentRepo.findById(id).get();

		if (Objects.nonNull(studentRequest.getFirstname()) && !"".equalsIgnoreCase(studentRequest.getFirstname())) {
			student.setFirstname(studentRequest.getFirstname());
		}
		if (Objects.nonNull(studentRequest.getLastname()) && !"".equalsIgnoreCase(studentRequest.getLastname())) {
			student.setLastname(studentRequest.getLastname());
		}
		if (Objects.nonNull(studentRequest.getEmail()) && !"".equalsIgnoreCase(studentRequest.getEmail())) {
			student.setEmail(studentRequest.getEmail());
		}
		if (Objects.nonNull(studentRequest.getAddress()) && !"".equalsIgnoreCase(studentRequest.getAddress())) {
			student.setAddress(studentRequest.getAddress());
		}
		if (Objects.nonNull(studentRequest.getContact())) {
			student.setContact(studentRequest.getContact());
		}
		return studentRepo.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepo.deleteById(id);
	}

	@Override
	public List<Student> getStudentByFirstname(String firstname) {
		return studentRepo.findByFirstname(firstname);
	}

	@Override
	public List<Student> getStudentByFirstnameAndLastname(String firstname, String lastname) {
		
		return studentRepo.findByFirstnameAndLastname(firstname, lastname);
	}

	@Override
	public List<Student> getStudentByFirstnameOrLastname(String firstname, String lastname) {
		return studentRepo.findByFirstnameOrLastname(firstname, lastname);
	}

	@Override
	public List<Student> getByFirstnameIn(StudentInQueryRequest inRequest) {
		System.out.println(inRequest.getFirstnames());
		return studentRepo.findByFirstnameIn(inRequest.getFirstnames());
	}

	

}
