package com.thouseef.payslip.mapper;


import com.thouseef.payslip.dto.SalarySlipResponse;
import com.thouseef.payslip.entity.SalarySlip;
import org.springframework.stereotype.Service;

@Service
public class SalaryMapper {
    public SalarySlipResponse toSalarySlipResponse(SalarySlip salary) {
        return new SalarySlipResponse(
                salary.getDisbursementDate(),
                salary.getAmount(),
                salary.getEmployees().getFirst_name(),
                salary.getEmployees().getLast_name()
        );
    }


}
