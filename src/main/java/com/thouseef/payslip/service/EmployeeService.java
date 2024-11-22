package com.thouseef.payslip.service;

import com.thouseef.payslip.dto.EmployeeRequest;
import com.thouseef.payslip.dto.EmployeeResponse;
import com.thouseef.payslip.entity.Employee;
import com.thouseef.payslip.exception.CustomerNotFoundException;
import com.thouseef.payslip.mapper.EmployeeMapper;
import com.thouseef.payslip.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final EmployeeMapper employeeMapper;

    public String createEmployee(EmployeeRequest request) {
        Employee employee = employeeMapper.toEmployee(request);
        employeeRepo.save(employee);
        return "Employee created successfully";
    }
    public Employee getEmployee(long id) {
        return employeeRepo.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Employee with id " + id + " not found")
        );

    }

    public EmployeeResponse retrieveEmployee(long id){
        Employee employee = getEmployee(id);
        return employeeMapper.toEmployeeResponse(employee);
    }


}
