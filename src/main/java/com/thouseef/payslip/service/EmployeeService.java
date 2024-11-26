package com.thouseef.payslip.service;

import com.thouseef.payslip.dto.EmployeeRequest;
import com.thouseef.payslip.dto.EmployeeResponse;
import com.thouseef.payslip.dto.LoginRequest;
import com.thouseef.payslip.entity.Employee;
import com.thouseef.payslip.exception.CustomerNotFoundException;
import com.thouseef.payslip.helper.JWTHelper;
import com.thouseef.payslip.mapper.EmployeeMapper;
import com.thouseef.payslip.repo.EmployeeRepo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final EmployeeMapper employeeMapper;
    private final EncryptionService encryptionService;
    private final JWTHelper jwtHelper;
    private final PasswordEncoder passwordEncoder;
    private final RequestInterceptor requestInterceptor;

    public String createEmployee(EmployeeRequest request) {
        Employee employee = employeeMapper.toEmployee(request);
        if (employee.getPassword() == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }

        String encrypted = passwordEncoder.encode(employee.getPassword());
        employee.setPassword(encrypted);


        employeeRepo.save(employee);
        return "Employee created successfully";
    }
    public Employee getEmployeeById(long id) {
        return employeeRepo.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("Employee with id " + id + " not found")
        );

    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepo.findByEmail(email).orElseThrow(
                () -> new CustomerNotFoundException("Employee with email " + email + " not found")
        );
    }

    public EmployeeResponse retrieveEmployee(long id){
        Employee employee = getEmployeeById(id);
        return employeeMapper.toEmployeeResponse(employee);
    }


    public String login(@Valid LoginRequest request) {
        System.out.println("At the login service");
        Employee employee = getEmployeeByEmail((request.email()));
        if(! encryptionService.validates(request.password(), employee.getPassword())) {
            return "Wrong password";
        }

        return jwtHelper.generateToken(employee.getEmail());

    }

}
