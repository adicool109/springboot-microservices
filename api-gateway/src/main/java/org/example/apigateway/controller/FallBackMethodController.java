package org.example.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/employeeServiceFallBack")
    public String employeeServiceFallBackMethod() {
        return "employee service is down, please try again later";
    }

    @GetMapping("/departmentServiceFallBack")
    public String departmentServiceFallBackMethod() {
        return "department service is down, please try again later";
    }

    @GetMapping("/defaultFallBack")
    public String defaultMessage() {
        return "service is down, please try again later";
    }
}
