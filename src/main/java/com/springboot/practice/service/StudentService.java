package com.springboot.practice.service;

import com.springboot.practice.dto.StudentDTO;
import com.springboot.practice.entity.Student;

import java.util.List;

public interface StudentService {
    public StudentDTO createStudent(StudentDTO student);

    public StudentDTO getStudentById(Long id);

    public List<StudentDTO> getALlStudent();

    public StudentDTO updateStudent(Long id,StudentDTO student);

    public void deleteStudent(Long id);
}
