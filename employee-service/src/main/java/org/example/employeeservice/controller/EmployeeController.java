package org.example.employeeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.employeeservice.VO.ResponseTemplateVO;
import org.example.employeeservice.entity.Employee;
import org.example.employeeservice.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    //@CircuitBreaker(name="employeeService", fallbackMethod = "employeeServiceFallBackMethod")
    public Employee saveEmployee(@RequestBody Employee employee) {
        log.info("inside saveEmployee of EmployeeController");
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/{id}")
    //@CircuitBreaker(name="employeeService", fallbackMethod = "employeeServiceFallBackMethod")
    public ResponseTemplateVO getUserWithDepatment(@PathVariable("id") Long employeeId) {
        log.info("inside getUserWithDepatment of EmployeeController");
        return employeeService.getUserWithDepatment(employeeId);
    }

    public ResponseEntity<String> employeeServiceFallBackMethod(Exception e) {
        //return "employee service is down, please try again later";
        return new ResponseEntity<String>("employee service is down", HttpStatus.OK);
    }
}
