package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data... only once!

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Woofer", "Singh"));
        theStudents.add(new Student("Super", "Mario"));
        theStudents.add(new Student("Tom", "Patel"));
        theStudents.add(new Student("Mary", "Jane"));
    }
    //define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student with specific ID
     @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

         // just index into the list

         // check the studentId

         if((studentId >= theStudents.size()) || (studentId < 0)) {
             throw new StudentNotFoundException("Student not found - " + studentId);
         }
         return theStudents.get(studentId);
    }
}
