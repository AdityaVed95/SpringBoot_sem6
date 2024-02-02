package com.microservices.MicroServiceTwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api-exp3-part1-service2")
public class ServiceTwo {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("hello")
    public String helloThere() {
        return "Hello from Microservice 2";
    }

    @GetMapping("/communication")
    public String communicateWithMicroserviceOne() {
        // Communicate with MicroserviceOne
        String microserviceOneResponse = restTemplate
                .getForObject("http://localhost:9500/api-exp3-part1-service1/message", String.class);

        return "Communication result: " + microserviceOneResponse;
    }

    @GetMapping("/addStudents")
    public String addStudents() {
        String microserviceOneResponse = restTemplate.getForObject("http://localhost:8080/apiexp2/addStudents",
                String.class);
        return microserviceOneResponse;
    }

    @GetMapping("/getStudents")
    public String getStudents() {
        String microserviceOneResponse = restTemplate.getForObject("http://localhost:8080/apiexp2/getStudents",
                String.class);
        return microserviceOneResponse;
    }

}
