package com.myapp.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.student.entity.Faculty;
import com.myapp.student.response.FacultyResponse;
import com.myapp.student.service.FacultyService;

@RestController
@RequestMapping("api/faculty")
public class FacultyController {

	@Autowired
	private FacultyService facultyService;
	
	@GetMapping("/get")
	public List<FacultyResponse> getAllFaculty() {
		List<Faculty> facultyList = facultyService.getAllFaculty();
		List<FacultyResponse> facultyResponse = new ArrayList<FacultyResponse>();
		facultyList.stream().forEach(faculty -> {
			facultyResponse.add(new FacultyResponse(faculty));
		});
		return facultyResponse;
	}
	
	@GetMapping("/get/{fid}")
	public FacultyResponse getFacultyById(@PathVariable Long fid) {
		Faculty faculty = facultyService.getFacultyById(fid);
		return new FacultyResponse(faculty);
	}
}
