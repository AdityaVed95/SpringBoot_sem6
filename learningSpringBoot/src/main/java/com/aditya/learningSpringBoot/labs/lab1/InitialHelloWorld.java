package com.aditya.learningSpringBoot.labs.lab1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class InitialHelloWorld {

    @GetMapping("/initialHello")
    public String say() {
        return "Hello There !!!";
    }
}
