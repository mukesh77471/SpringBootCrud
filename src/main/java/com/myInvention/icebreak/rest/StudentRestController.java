package com.myInvention.icebreak.rest;


import com.myInvention.icebreak.entity.Student;
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

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Mary", "Smith"));
    }

    //define endpoints here for student to get all students

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return theStudents;
    }

    //define endpoint to get student by id

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        if (id >= theStudents.size() || id < 0) {
            throw new StudentNotFoundException("Student not found - " + id);
        }
        return theStudents.get(id);
    }


    //Add exception handler using @ExceptionHandler


}
