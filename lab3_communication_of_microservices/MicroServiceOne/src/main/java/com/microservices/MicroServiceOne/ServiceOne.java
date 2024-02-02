package com.microservices.MicroServiceOne;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-exp3-part1-service1")
// This is a controller class

public class ServiceOne {

    @GetMapping("/message")
    public String getMessage() {
        return "Hello from Microservice One";
    }

}
