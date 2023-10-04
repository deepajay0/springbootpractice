package com.springboot.practice.service.impl;

import com.springboot.practice.dto.StudentDTO;
import com.springboot.practice.entity.Student;
import com.springboot.practice.exception.EmailAlreadyExistException;
import com.springboot.practice.exception.ResourceNotFoundException;
import com.springboot.practice.mapper.UserMapper;
import com.springboot.practice.repository.StudentRepository;
import com.springboot.practice.service.StudentService;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private ModelMapper modelMapper;


    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
//        Student student = UserMapper.mapToStudent(studentDTO);
        Student student = modelMapper.map(studentDTO,Student.class);
        Optional<Student> byEmail = studentRepository.findByEmail(student.getEmail());
        if(byEmail.isPresent()){
            throw new EmailAlreadyExistException("Email Already Exist for this Student");
        }
        Student savedStudent = studentRepository.save(student);
//        StudentDTO studentDTO1 = UserMapper.mapToStudentDto(savedStudent);
        StudentDTO studentDTO1 = modelMapper.map(savedStudent, StudentDTO.class);
        return studentDTO1;
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student byId = studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","id",id));
//        StudentDTO studentDTO = UserMapper.mapToStudentDto(byId.get());
        StudentDTO studentDTO = modelMapper.map(byId, StudentDTO.class);
        return studentDTO;
    }

    @Override
    public List<StudentDTO> getALlStudent() {
        List<Student> allStudent = studentRepository.findAll();
        List<StudentDTO> studentDTOList = allStudent.stream().map(student -> modelMapper.map(student, StudentDTO.class)).collect(Collectors.toList());
        return studentDTOList;
    }

    @Override
    public StudentDTO updateStudent(Long id, StudentDTO studentDTO) {
        Student updatedStudent = studentRepository.findById(id).get();
//        Student student = UserMapper.mapToStudent(studentDTO);
        Student student = modelMapper.map(studentDTO,Student.class);
        updatedStudent.setFirstName(student.getFirstName());
        updatedStudent.setLastName(student.getLastName());
        updatedStudent.setEmail(student.getEmail());
        updatedStudent.setBranch(student.getBranch());
        return modelMapper.map(studentRepository.save(updatedStudent), StudentDTO.class);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
