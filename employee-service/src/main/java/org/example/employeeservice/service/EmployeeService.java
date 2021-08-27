package org.example.employeeservice.service;

import org.example.employeeservice.VO.Department;
import org.example.employeeservice.VO.ResponseTemplateVO;
import org.example.employeeservice.entity.Employee;
import org.example.employeeservice.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Employee saveEmployee(Employee employee) {
        log.info("inside saveEmployee of EmployeeService");
        return employeeRepository.save(employee);
    }

    public ResponseTemplateVO getUserWithDepatment(Long employeeId) {
        log.info("inside getUserWithDepatment of EmployeeService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"
                + employee.getDepartmentId()
                , Department.class);
        vo.setEmployee(employee);
        vo.setDepartment(department);
        return vo;
    }
}
