package com.training.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@GetMapping("/students")
	public List<Student> retrieveAllStudents() {
		return studentRepository.findAll();
	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Object> retrieveStudent(@PathVariable Integer id) {
		Optional<Student> student = studentRepository.findById(id);
		if (!student.isPresent())
			throw new StudentNotFoundException("Student is not available with Id -" + id);
		else
			return ResponseEntity.ok(student.get());
	}

	@DeleteMapping("/students/{id}")
	//public void deleteStudent(@PathVariable Integer id) {
	public ResponseEntity<Object> deleteStudent(@PathVariable Integer id) {
		Optional<Student> student = studentRepository.findById(id);
		if (!student.isPresent())
			throw new StudentNotFoundException("Student is not available with Id -" + id);
		else {
			studentRepository.deleteById(id);
			return ResponseEntity.ok(student.get());
		}
		//studentRepository.deleteById(id);
	}

	@PostMapping("/students")
	public ResponseEntity<Object> createStudent(@RequestBody Student student) {
		Student savedStudent = studentRepository.save(student);

		return new ResponseEntity("New Student created with id: "+savedStudent.getId(), HttpStatus.CREATED);

	}
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable Integer id) {

		Optional<Student> studentOptional = studentRepository.findById(id);

		if (!studentOptional.isPresent())
			throw new StudentNotFoundException("Student is not available with Id -" + id);

		student.setId(id);
		Student savedStudent=studentRepository.save(student);

		return ResponseEntity.ok(savedStudent);
	}
}