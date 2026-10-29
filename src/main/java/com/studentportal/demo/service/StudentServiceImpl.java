package com.studentportal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentportal.demo.model.Student;
import com.studentportal.demo.repo.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepo studentRepo;

    // Create multiple students
    @Override
    public Student createStudents(Student students) {
        return studentRepo.save(students);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudent(Integer id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public void deleteStudent(Integer id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student updateStudent(Student s) {
        return studentRepo.save(s);
    }
}