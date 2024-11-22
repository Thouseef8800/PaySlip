package com.thouseef.payslip.mapper;


import com.thouseef.payslip.dto.EmployeeRequest;
import com.thouseef.payslip.dto.EmployeeResponse;
import com.thouseef.payslip.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {
    public Employee toEmployee(EmployeeRequest request) {
        return Employee.builder()
                .id(request.id())
                .first_name(request.first_name())
                .last_name(request.last_name())
                .build();
    }
    public EmployeeResponse toEmployeeResponse(Employee employee) {
        return new EmployeeResponse(employee.getId(), employee.getFirst_name(), employee.getLast_name());
    }
}

