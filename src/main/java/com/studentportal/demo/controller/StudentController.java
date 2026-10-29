package com.studentportal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentportal.demo.model.Student;
import com.studentportal.demo.service.StudentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Student Portal";
    }

    // Create multiple students
    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student students) {
        return studentService.createStudents(students);
    }

    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudent/{sid}")
    public Student getStudent(@PathVariable Integer sid) {
        return studentService.getStudent(sid);
    }

    @DeleteMapping("/deleteStudent/{sid}")
    public String deleteStudent(@PathVariable Integer sid) {
        studentService.deleteStudent(sid);
        return "Deleted Successfully";
    }

    @PutMapping("/updateStudent/{sid}")
    public Student updateStudent(@RequestBody Student s,
                                 @PathVariable Integer sid) {
        Student studentFromDB = studentService.getStudent(sid);

        studentFromDB.setAge(s.getAge());
        studentFromDB.setCity(s.getCity());
        studentFromDB.setFirstname(s.getFirstname());
        studentFromDB.setLastname(s.getLastname());
        studentFromDB.setTotalmarks(s.getTotalmarks());

        return studentService.updateStudent(studentFromDB);
    }
}