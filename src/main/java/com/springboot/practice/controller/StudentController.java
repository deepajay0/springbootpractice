package com.springboot.practice.controller;

import com.springboot.practice.dto.StudentDTO;
import com.springboot.practice.entity.Student;
import com.springboot.practice.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
@RestController
@RequestMapping("api/student")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save user in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 created"
    )
    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody @Valid StudentDTO studentDTO){
        StudentDTO student1 = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @Operation(
            summary = "GET User by ID REST API",
            description = "GET USER BY ID  REST API is used to get single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 success"
    )
    @GetMapping("{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
        StudentDTO studentById = studentService.getStudentById(id);
        return new ResponseEntity<>(studentById,HttpStatus.OK);
    }
    @Operation(
            summary = "GET All User  REST API",
            description = "GET ALL USER  REST API is used to get all user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 success"
    )
    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudent(){
        List<StudentDTO> aLlStudent = studentService.getALlStudent();
        return new ResponseEntity<>(aLlStudent,HttpStatus.OK);
    }

    @Operation(
            summary = "Update User  REST API",
            description = "UPDATE USER  REST API is used to update single user in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 success"
    )
    @PutMapping
    public ResponseEntity<StudentDTO> updateStudent(@RequestParam Long id,@RequestBody @Valid StudentDTO student){
        StudentDTO updatedStudent = studentService.updateStudent(id, student);
        return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
    }

    @Operation(
            summary = "DELETE User by ID REST API",
            description = "DELETE USER  REST API is used to delete single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 success"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student record deleted",HttpStatus.OK);
    }

}
