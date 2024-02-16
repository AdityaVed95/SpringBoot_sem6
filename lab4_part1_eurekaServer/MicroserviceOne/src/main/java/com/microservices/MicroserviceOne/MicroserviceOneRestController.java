package com.microservices.MicroserviceOne;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/microservice-one-api")
public class MicroserviceOneRestController {

    @GetMapping("/message")
    public String getMessage() {
        return "Hello from Microservice One";
    }
}
