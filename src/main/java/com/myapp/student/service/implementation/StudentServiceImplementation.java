package com.myapp.student.service.implementation;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.student.entity.Student;
import com.myapp.student.repository.StudentRepository;
import com.myapp.student.request.CreateStudentRequest;
import com.myapp.student.request.UpdateStudentRequest;
import com.myapp.student.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student createStudent(CreateStudentRequest studentRequest) {
		Student student = new Student(studentRequest);
		return student = studentRepo.save(student);
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
		return studentRepo.getByFirstname(firstname);
	}

	@Override
	public List<Student> getStudentByFirstnameAndLaststname(String firstname, String lastname) {
		
		return studentRepo.getByFirstnameAndLastname(firstname, lastname);
	}

	

}
