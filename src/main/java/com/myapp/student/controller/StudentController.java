package com.myapp.student.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.student.entity.Student;
import com.myapp.student.request.CreateStudentRequest;
import com.myapp.student.request.StudentInQueryRequest;
import com.myapp.student.request.UpdateStudentRequest;
import com.myapp.student.response.StudentResponse;
import com.myapp.student.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/get")
	public List<StudentResponse> getAllStudents() {
		List<Student> studentList = studentService.getAllStudents();
		List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
		studentList.stream().forEach(student -> {
			studentResponse.add(new StudentResponse(student));
		});
		return studentResponse;
	}

	@GetMapping("/getByFirstName/{firstname}")
	public List<StudentResponse> getStudentByFirstname(@PathVariable("firstname") String firstname) {
		List<Student> studentList = studentService.getStudentByFirstname(firstname);
		List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
		studentList.stream().forEach(student -> {
			studentResponse.add(new StudentResponse(student));
		});

		return studentResponse;
	}
    
	@GetMapping("/getByFirstnameAndLastname/{firstname}/{lastname}")
	public List<StudentResponse>
	getStudentByLastnameAndFirstname(@PathVariable("firstname") String firstname, @PathVariable("lastname") String lastname) {
	 List<Student> studentList = studentService.getStudentByFirstnameAndLastname(firstname, lastname);
	 List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
	 studentList.stream().forEach(student -> {
		 studentResponse.add(new StudentResponse(student));
	 });
	 return studentResponse;
	}
	
     @GetMapping("/getByFirstnameIn")
     public List<StudentResponse> getByFirstnameIn(@RequestBody StudentInQueryRequest inRequest) {
    	 List<Student> studentList = studentService.getByFirstnameIn(inRequest);
    	 List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
    	 studentList.stream().forEach(student -> {
    		 studentResponse.add(new StudentResponse(student));
    	 });
    	 return studentResponse;
     }
	
	@GetMapping("/getByFirstnameOrLastname/{firstname}/{lastname}")
	public List<StudentResponse> getStudentByFirstnameOrLastname(@PathVariable("firstname") String firstname,
			@PathVariable("lastname") String lastname) {
		List<Student> studentList = studentService.getStudentByFirstnameOrLastname(firstname, lastname);
		List<StudentResponse> studentResponse = new ArrayList<StudentResponse>();
		
		studentList.stream().forEach(student -> {
			studentResponse.add(new StudentResponse(student));
		});
		return studentResponse;
	}

	@PostMapping("/create")
	public Student createStudent(@Valid @RequestBody CreateStudentRequest studentRequest) {
		return studentService.createStudent(studentRequest);

	}

	@GetMapping("/get/{id}")
	public StudentResponse getStudentById(@PathVariable("id") Long id) {
		Student student = studentService.getStudentById(id);
		return new StudentResponse(student);
	}

	@PutMapping("/update/{id}")
	public Student updateStudent(@Valid @RequestBody UpdateStudentRequest studentRequest, @PathVariable("id") Long id) {
		return studentService.updateStudent(studentRequest, id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		studentService.deleteStudent(id);
		return "Student Deleted" + " with id : " + id.toString();
	}

}
