package com.thouseef.payslip.mapper;

import com.thouseef.payslip.dto.SalarySlipResponse;
import com.thouseef.payslip.entity.SalarySlip;

public class SalaryHistoryMapper {
    public SalarySlipResponse toSalarySlipResponse(SalarySlip salary) {
        return new SalarySlipResponse(
                salary.getDisbursementDate(),
                salary.getAmount(),
                salary.getEmployees().getFirst_name(),
                salary.getEmployees().getLast_name()
        );
    }
}
