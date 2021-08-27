package org.example.departmentservice.service;

import lombok.extern.slf4j.Slf4j;
import org.example.departmentservice.entity.Department;
import org.example.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("------> inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long departmentId) {
        log.info("------> inside getDepartmentById of DepartmentService");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
