package org.db.apn.controller;

import java.util.List;

import javax.validation.Valid;

import org.db.apn.entity.VBSchoolEntity;
import org.db.apn.repository.VBSchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

@RestController
public class VBSchoolControlller {
	
	@Autowired
	public VBSchoolRepository repository;
	
	//extracting all school data
	@RequestMapping(method = RequestMethod.GET,path = "/")
	public List<VBSchoolEntity> getSchools() {
		return repository.findAll();
	}

	//find a School by schoolId
	@GetMapping("/{id}")
	public VBSchoolEntity findBySchoolId(@PathVariable(value = "id") Long id) {
		return 	repository.findById(id).orElseThrow(()->new SchoolNotFoundException(id));
	}
	//Create a School
	@RequestMapping(method = RequestMethod.POST,path = "/createSchool")
	public VBSchoolEntity createSchool(@Valid @RequestBody VBSchoolEntity schoolEntity) {
		return repository.save(schoolEntity);
	}
	
	
	// Update a School
	@PutMapping("/updateSchool/{id}")
	public VBSchoolEntity updateSchool(@PathVariable(value = "id") Long id,
	                                        @Valid @RequestBody VBSchoolEntity schoolDetails) {

		VBSchoolEntity school = repository.findById(id)
	            .orElseThrow(() -> new SchoolNotFoundException(id));
		
		school.setCity(schoolDetails.getCity());
		school.setEndDate(schoolDetails.getEndDate());
		school.setSchoolName(schoolDetails.getSchoolName());
		school.setSize(schoolDetails.getSize());
		school.setStartDate(schoolDetails.getStartDate());
		school.setSyllabus(schoolDetails.getSyllabus());

	    VBSchoolEntity updatedSchool = repository.save(school);
	    return updatedSchool;
	}
	
	// Delete a School
	@DeleteMapping("/deleteSchool/{id}")
	public ResponseEntity<String> deleteSchool(@PathVariable(value = "id") Long schoolId) {
		System.out.println("-----------DELETE---------"+schoolId);
		VBSchoolEntity school = repository.findById(schoolId)
	            .orElseThrow(()->new SchoolNotFoundException(schoolId));

		repository.delete(school);

	    return ResponseEntity.status(HttpStatus.OK).build();
	}

}
