package com.thouseef.payslip.controller;

import com.thouseef.payslip.config.JwtFilter;
import com.thouseef.payslip.dto.SalarySlipResponse;
import com.thouseef.payslip.service.EmployeeSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class EmployeeSalaryController {
    @Autowired
    EmployeeSalaryService employeeSalaryService;

    @Autowired
    JwtFilter jwtFilter;

    @GetMapping("/")
    public ResponseEntity<SalarySlipResponse> getLastSalary(){
        return ResponseEntity.ok(employeeSalaryService.getLastSalary(jwtFilter.getEmailAddress()));
    }

    @GetMapping("/salary/History")
    public ResponseEntity<List<SalarySlipResponse>> getSalaryHistory(){
        return ResponseEntity.ok(employeeSalaryService.getSalaryHistory(jwtFilter.getEmailAddress()));
    }
}
