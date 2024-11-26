package com.thouseef.payslip.mapper;


import com.thouseef.payslip.dto.EmployeeRequest;
import com.thouseef.payslip.dto.EmployeeResponse;
import com.thouseef.payslip.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {
    public Employee toEmployee(EmployeeRequest request) {
        Employee employee = new Employee();
        employee.setFirst_name(request.first_name());
        employee.setLast_name(request.last_name());
        employee.setEmail(request.email());
        employee.setPassword(request.password());
        employee.setTitle(request.title());
        employee.setPhotographPath(request.photographPath());
        employee.setDepartment(request.department());

        return employee;
    }

    public EmployeeResponse toEmployeeResponse(Employee employee) {
        return new EmployeeResponse(
                employee.getFirst_name(),
                employee.getLast_name(),
                employee.getEmail(),
                employee.getTitle(),
                employee.getPhotographPath(),
                employee.getDepartment()
        );
    }
}

