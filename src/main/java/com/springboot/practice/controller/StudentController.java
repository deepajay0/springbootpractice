package com.springboot.practice.controller;

import com.springboot.practice.dto.StudentDTO;
import com.springboot.practice.entity.Student;
import com.springboot.practice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody @Valid StudentDTO studentDTO){
        StudentDTO student1 = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
        StudentDTO studentById = studentService.getStudentById(id);
        return new ResponseEntity<>(studentById,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudent(){
        List<StudentDTO> aLlStudent = studentService.getALlStudent();
        return new ResponseEntity<>(aLlStudent,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StudentDTO> updateStudent(@RequestParam Long id,@RequestBody @Valid StudentDTO student){
        StudentDTO updatedStudent = studentService.updateStudent(id, student);
        return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student record deleted",HttpStatus.OK);
    }

}
