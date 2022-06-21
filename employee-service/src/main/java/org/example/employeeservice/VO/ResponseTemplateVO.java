package org.example.employeeservice.VO;

import org.example.employeeservice.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private Employee employee;
    private Department department;

    // test
    private String email;
}
