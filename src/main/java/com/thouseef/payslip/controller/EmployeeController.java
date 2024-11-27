package com.thouseef.payslip.controller;

import com.thouseef.payslip.config.JwtFilter;
import com.thouseef.payslip.dto.EmployeeRequest;
import com.thouseef.payslip.dto.EmployeeResponse;
import com.thouseef.payslip.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class EmployeeController {
    public final EmployeeService employeeService;

    @Autowired
    JwtFilter jwtFilter;

    @PostMapping("/register")
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeRequest request) {
        return ResponseEntity.ok(employeeService.createEmployee(request));
    }

    @GetMapping("/dashboard/{email}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable String email) {
//        return "Hello";
        return ResponseEntity.ok(employeeService.employeeDetails(email));
    }
}