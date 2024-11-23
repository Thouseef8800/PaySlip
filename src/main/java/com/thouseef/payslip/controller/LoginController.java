package com.thouseef.payslip.controller;

import com.thouseef.payslip.dto.LoginRequest;
import com.thouseef.payslip.entity.Employee;
import com.thouseef.payslip.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
public class LoginController {
   private final EmployeeService employeeService;

    public LoginController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login (@Valid @RequestBody LoginRequest request){
        System.out.println("at the controller");
        return ResponseEntity.ok(employeeService.login(request));
    }
}
