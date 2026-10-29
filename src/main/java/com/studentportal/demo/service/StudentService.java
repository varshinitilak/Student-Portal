package com.studentportal.demo.service;

import java.util.List;
import com.studentportal.demo.model.Student;

public interface StudentService {

    Student createStudents(Student students);

    List<Student> getAllStudents();

    Student getStudent(Integer id);

    void deleteStudent(Integer id);

    Student updateStudent(Student s);
}