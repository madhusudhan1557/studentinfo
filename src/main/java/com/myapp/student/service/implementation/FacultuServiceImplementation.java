package com.myapp.student.service.implementation;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.student.entity.Faculty;
import com.myapp.student.repository.FacultyRepository;
import com.myapp.student.request.CreateFacultyRequest;
import com.myapp.student.request.UpdateFacultyRequest;
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

	@Override
	public Faculty createFaculty(CreateFacultyRequest facultyRequest) {
		Faculty faculty = new Faculty(facultyRequest);
		return facultyRepository.save(faculty);
	}

	@Override
	public Faculty updateFaculty(UpdateFacultyRequest facultyRequest, Long fid) {
		Faculty newFaculty = facultyRepository.findById(fid).get();
		if(Objects.nonNull(facultyRequest.getTitle()) && !"".equalsIgnoreCase(facultyRequest.getTitle())) {
			newFaculty.setTitle(facultyRequest.getTitle());
		}
		return facultyRepository.save(newFaculty);
	}

}
