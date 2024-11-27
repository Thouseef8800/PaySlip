package com.thouseef.payslip.mapper;


import com.thouseef.payslip.dto.SalaryResponse;
import com.thouseef.payslip.entity.EmployeeSalary;
import org.springframework.stereotype.Service;

@Service
public class SalaryMapper {
    public SalaryResponse toSalaryResponse(EmployeeSalary salary) {
        return new SalaryResponse(
                salary.getPaymentDate(),
                salary.getAmount(),
                salary.getDescription()
        );
    }
}
