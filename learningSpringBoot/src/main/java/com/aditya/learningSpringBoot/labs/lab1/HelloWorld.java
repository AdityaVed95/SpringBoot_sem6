package com.aditya.learningSpringBoot.labs.lab1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class HelloWorld {
    ArrayList<Student> studentsObjects = new ArrayList<>();

    // type this in the url : http://localhost:8080/api/hello
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/hey")
    public String sayHey() {
        return "Hey, Spring Boot!";
    }

    // Updated method to handle dynamic names
    @GetMapping("/{name}")
    public String sayHelloToName(@PathVariable String name) {
        String message = returnHey(name);
        System.out.println("You are in sayHelloToName function");
        return message;
    }

    public String returnHey(String name)
    {
        return "Hello " + name + " !!!!!!!!!!!!!!!!!!!!!!!!!!";
    }

    @GetMapping("/{firstName}/{lastName}")
    public String sayHelloToFullName(@PathVariable String firstName,@PathVariable String lastName) {
        String message = returnHey(firstName + " " + lastName);
        return message;
    }

    @GetMapping("/add/{firstName}/{lastName}")
    public String addFullName(@PathVariable String firstName,@PathVariable String lastName) {
        studentsObjects.add(new Student(firstName,lastName));
        return "Student added successfully to the Array list";
    }

    @GetMapping("/printOneStudentData")
    public String printOneStudentData() {
        // System.out.println(studentsObjects.get(0).firstName);
        System.out.println(studentsObjects.get(0));
        return "Printed successfully , check terminal !!!!";
    }

    @GetMapping("/printAllStudentsData")
    public String printAllStudentsData() {

        String names_string = "";

        for(Student s1 : studentsObjects)
        {
            names_string = names_string + s1.toString();
        }

        System.out.println(names_string);

        return "All Student Data is : \n" + names_string;
    }

    // http://localhost:8080/api/add/aditya/ved
    // http://localhost:8080/api/add/ravindra/buddy
    // http://localhost:8080/api/printOneStudentData
    // http://localhost:8080/api/printAllStudentsData
}