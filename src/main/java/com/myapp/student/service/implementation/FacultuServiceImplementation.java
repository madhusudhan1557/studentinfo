package com.myapp.student.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.student.entity.Faculty;
import com.myapp.student.repository.FacultyRepository;
import com.myapp.student.service.FacultyService;

@Service
public class FacultuServiceImplementation implements FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;
	
	@Override
	public List<Faculty> getAllFaculty() {
		return facultyRepository.findAll();
	}

	@Override
	public Faculty getFacultyById(Long fid) {
		return facultyRepository.findById(fid).get();
	}

}
