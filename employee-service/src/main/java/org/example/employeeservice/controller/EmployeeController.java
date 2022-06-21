package org.example.employeeservice.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.example.employeeservice.VO.Department;
import org.example.employeeservice.VO.ResponseTemplateVO;
import org.example.employeeservice.entity.Employee;
import org.example.employeeservice.mapper.EmployeeModelMapper;
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

    @Autowired
    private EmployeeModelMapper mapper;

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

    @GetMapping("/getTestValues/{id}")
    public ResponseTemplateVO getEmployeeTest(@PathVariable("id") Long employeeId) {
        log.info("inside saveEmployee of EmployeeController");
        Employee emp = new Employee();
        emp.setEmployeeId(1);
        //emp.setEmail("test@gmail.com");
        emp.setDepartmentId(1L);
        emp.setFirstName("Testfirstname");
        emp.setLastName("Lastname");

        //ResponseTemplateVO vo = new ResponseTemplateVO();
        Department department = new Department();
        department.setDepartmentId(1L);
        department.setDepartmentName("Science");
        department.setDepartmentCode("SC01");
        department.setDepartmentAddress("main street");

        return mapper.mapResponseTemplateVO(emp, department);

    }
}
