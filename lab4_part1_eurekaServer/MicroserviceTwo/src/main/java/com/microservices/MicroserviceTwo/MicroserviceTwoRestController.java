package com.microservices.MicroserviceTwo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/microservice-two-api")
public class MicroserviceTwoRestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/communication")
    public String communicateWithMicroserviceOne() {
        String microserviceOneResponse = restTemplate
                .getForObject("http://10.0.87.104:8081/microservice-one-api/message", String.class);
        return "Communication result: " + microserviceOneResponse;
    }

}
