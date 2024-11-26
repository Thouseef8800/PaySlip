package com.thouseef.payslip.service;


import com.thouseef.payslip.dto.EmployeeRequest;
import com.thouseef.payslip.dto.EmployeeResponse;
import com.thouseef.payslip.dto.LoginRequest;
import com.thouseef.payslip.entity.Employee;
import com.thouseef.payslip.helper.JWTHelper;
import com.thouseef.payslip.mapper.EmployeeMapper;
import com.thouseef.payslip.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    @Autowired
    private final EmployeeRepo employeeRepo;
    @Autowired
    private final EmployeeMapper employeeMapper;
    @Autowired
    private final JWTHelper jwtService;

    @Autowired
    AuthenticationManager authManager;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public EmployeeResponse createEmployee(EmployeeRequest request) {
        Employee employee = employeeMapper.toEmployee(request);
        employee.setPassword(encoder.encode(employee.getPassword()));
        return employeeMapper.toEmployeeResponse(employeeRepo.save(employee));
    }


    public String login(LoginRequest request) {
        Authentication authentication=authManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(request.email());

        return "Fail";
    }
}
