package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepo;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentRepo studentRepo;
	 
	@PostMapping("/students")
	public String createNewStudent( @RequestBody Student student) {
		studentRepo.save(student);
		return "Employee Created in Database";
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> studList=new ArrayList();
		studentRepo.findAll().forEach(studList::add);
		return new ResponseEntity<List<Student>>(studList,HttpStatus.OK);
		
	}
	
	@GetMapping("/students/{roll_no}")
	public ResponseEntity<Student> getStudentById(@PathVariable long roll_no){
		Optional<Student> stud=studentRepo.findById(roll_no);
		if(stud.isPresent()) {
			return new ResponseEntity<Student>(stud.get(),HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
		
		
		}
	
	@PutMapping("/students/{roll_no}")
	public String updateStudentById(@PathVariable long roll_no,@RequestBody Student student) {
		Optional<Student>stud=studentRepo.findById(roll_no);
		if(stud.isPresent()) {
			Student exitStud=stud.get();
			exitStud.setDOB(student.getDOB());
			exitStud.setMarks(student.getMarks());
			exitStud.setName(student.getName());
			
			studentRepo.save(exitStud);
			return "Student Details against Id"+roll_no+"updated";
		}else {
			return "Student Details Not Found";
		}
		
		
	}
	@DeleteMapping("students/{roll_no}")
	public String deleteStudentById(@PathVariable long roll_no) {
		studentRepo.deleteById(roll_no);
		return "Student delete Successfully";
	}
	
	@DeleteMapping("students")
	public String deleteAllStudents() {
		studentRepo.deleteAll();
		return "Student Data deleted Successfully";
		
	}
	
	}
	 

