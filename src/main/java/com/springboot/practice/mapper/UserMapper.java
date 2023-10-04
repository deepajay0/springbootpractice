package com.springboot.practice.mapper;

import com.springboot.practice.dto.StudentDTO;
import com.springboot.practice.entity.Student;

public class UserMapper {

    public static StudentDTO mapToStudentDto(Student student){
        StudentDTO studentDTO = new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getBranch()
        );
        return studentDTO;
    }
    public static Student mapToStudent(StudentDTO studentDTO){
        Student student = new Student(
          studentDTO.getId(),
          studentDTO.getFirstName(),
          studentDTO.getLastName(),
          studentDTO.getEmail(), studentDTO.getBranch()
        );
        return student;
    }
}
