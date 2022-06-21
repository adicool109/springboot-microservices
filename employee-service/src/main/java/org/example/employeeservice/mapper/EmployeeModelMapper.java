package org.example.employeeservice.mapper;

import org.example.employeeservice.VO.Department;
import org.example.employeeservice.VO.ResponseTemplateVO;
import org.example.employeeservice.entity.Employee;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface EmployeeModelMapper {

    @Mapping(source = "employeeEntity", target = "employee")
    @Mapping(source = "departmentEntity", target = "department")
    // example only
    @Mapping(source = "employeeEntity", target = "email", qualifiedByName = "getEmployeeEmail")
    ResponseTemplateVO mapResponseTemplateVO(Employee employeeEntity, Department departmentEntity);

    @Named("getEmployeeEmail")
    default String getEmployeeEmail(Employee employeeEntity) {
        if(employeeEntity.getEmail() != null) {
            return employeeEntity.getEmail();
        } else {
            return "test@test.com";
        }
    }
}
