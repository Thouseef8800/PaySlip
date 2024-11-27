package com.thouseef.payslip.controller;

import com.thouseef.payslip.dto.SalaryResponse;
import com.thouseef.payslip.service.EmployeeSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeSalaryController {
    @Autowired
    EmployeeSalaryService employeeSalaryService;

    @GetMapping("/salary/{email}")
    public ResponseEntity<List<SalaryResponse>> getLastSalary(@PathVariable String email){
        return ResponseEntity.ok(employeeSalaryService.getLastSalary(email));
    }

    @GetMapping("/salaryHistory/{email}")
    public ResponseEntity<List<SalaryResponse>> getSalaryHistory(@PathVariable String email){
        return ResponseEntity.ok(employeeSalaryService.getSalaryHistory(email));
    }
}