package com.acme.alumno.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acme.alumno.exception.ResourceNotFoundException;
import com.acme.alumno.model.Student;
import com.acme.alumno.repository.StudentRepository;


@RestController
@RequestMapping("/api")
public class StudentController {

 public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

 // @Autowired
 private StudentRepository studentRepository;

 public StudentController(StudentRepository studentRepository) {
  this.studentRepository = studentRepository;
 }

 @ResponseBody
 @RequestMapping(path = "/hello")
 public String sayHello() {
  return HELLO_TEXT;
 }

 @PostMapping("/saveStudent")
 public ResponseEntity<String> saveStudent(@RequestBody Student student) {
  studentRepository.save(student);
  return ResponseEntity.ok(student.toString());
 }

 @GetMapping("/getStudents")
 public ResponseEntity<List<Student>> getStudents() {
  List<Student> students = studentRepository.findAll();
  return ResponseEntity.ok(students);
 }

 @PutMapping("/updateStudent/{id}")
 public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
 Student student = studentRepository.findById(id)
   .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));
 
 student.setName(studentDetails.getName());
 student.setCareer(studentDetails.getCareer());
 student.setEmail(studentDetails.getEmail());
 student.setPhone(studentDetails.getPhone());
 student.setDocument(studentDetails.getDocument());
 
 Student updatedStudent = studentRepository.save(student);
 return ResponseEntity.ok(updatedStudent);
 }

 @DeleteMapping("/deleteStudent/{id}")
 public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
  studentRepository.deleteById(id);
  return ResponseEntity.noContent().build();
 }

}
