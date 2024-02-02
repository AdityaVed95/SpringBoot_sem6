package com.microservices.StudentMicroServiceThree;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apiexp2")
// This is a controller class
public class StudentRestController {
    ArrayList<Students> myStudentsList = new ArrayList<>();

    // http://localhost:8080/api/getStudents

    @GetMapping("/addStudents")
    public List<Students> addStudents() {
        myStudentsList.add(new Students("Aditya", "Ved"));
        myStudentsList.add(new Students("Ravindra", "Buddy"));
        return myStudentsList;
    }

    @GetMapping("/getStudents")
    public List<Students> getStudents() {
        return myStudentsList;
    }

    @GetMapping("/deleteFirstStudent")
    public List<Students> deleteFirstStudent() {
        myStudentsList.remove(0);
        return myStudentsList;
    }

    // if the browser sends a DELETE REQUEST then : @DeleteMapping should be used.
    // the annotation is used to say which http method is being used : get, post ,
    // delete etc.
}
