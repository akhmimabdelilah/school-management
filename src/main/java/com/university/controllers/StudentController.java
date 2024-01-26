package com.university.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.entities.Filiere;
import com.university.entities.Student;
import com.university.services.StudentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		student.setId(0);
		return studentService.create(student);
	}

	@GetMapping
	public List<Student> findAllStudent() {
		return studentService.findAll();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateStudent(@PathVariable int id, @RequestBody Student newStudent) {
		Student oldStudent = studentService.findById(id);
		if (oldStudent == null) {
			return new ResponseEntity<Object>("Student avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			oldStudent.setId(id);
			return ResponseEntity.ok(studentService.update(newStudent));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleStudent(@PathVariable int id) {
		Student student = studentService.findById(id);
		if (student == null) {
			return new ResponseEntity<Object>("Student avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {
			studentService.delete(student);
			return ResponseEntity.ok("Student supprime");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable int id) {
		Student student = studentService.findById(id);
		if (student == null) {
			return new ResponseEntity<Object>("Student avec ID = " + id + " n'existe pas", HttpStatus.BAD_REQUEST);
		} else {

			return ResponseEntity.ok(student);
		}
	}

	@GetMapping("/filieres")
	public List<Student> findByFiliere(@RequestBody Filiere filiere) {
		return studentService.findByFiliere(filiere);
	}

}
