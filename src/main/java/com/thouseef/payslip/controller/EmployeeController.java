package com.thouseef.payslip.controller;

import com.thouseef.payslip.dto.EmployeeRequest;
import com.thouseef.payslip.dto.EmployeeResponse;
import com.thouseef.payslip.entity.Employee;
import com.thouseef.payslip.entity.SalarySlip;
import com.thouseef.payslip.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


  @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@RequestBody @Valid EmployeeRequest request) {
        return ResponseEntity.ok(employeeService.createEmployee(request));
  }



}
