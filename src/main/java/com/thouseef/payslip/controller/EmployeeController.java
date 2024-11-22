package com.thouseef.payslip.controller;

import com.thouseef.payslip.dto.EmployeeResponse;
import com.thouseef.payslip.entity.Employee;
import com.thouseef.payslip.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable("id") long id) {
      return ResponseEntity.ok(employeeService.retrieveEmployee(id));
  }
}
