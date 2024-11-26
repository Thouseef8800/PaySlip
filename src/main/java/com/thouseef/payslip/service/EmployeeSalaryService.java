package com.thouseef.payslip.service;

import com.thouseef.payslip.dto.SalarySlipResponse;
import com.thouseef.payslip.entity.SalarySlip;
import com.thouseef.payslip.mapper.SalaryMapper;
import com.thouseef.payslip.repo.EmployeeRepo;
import com.thouseef.payslip.repo.SalarySlipRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class EmployeeSalaryService {
    @Autowired
    SalarySlipRepo salaryRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    SalaryMapper mapper;

    public SalarySlipResponse getLastSalary(String emailAddress) {

        return mapper.toSalarySlipResponse(salaryRepo.findByEmployeeId(employeeRepo.findByEmail(emailAddress).getEmployee_id()));
    }

    public List<SalarySlipResponse> getSalaryHistory(String emailAddress) {
        List<SalarySlip> latestSalary = salaryRepo.findHistoryByEmployeeId(employeeRepo.findByEmail(emailAddress).getEmployee_id());
        List<SalarySlipResponse> salaryList = new ArrayList<>();

        for(SalarySlip employeeSalary : latestSalary) {
            salaryList.add(mapper.toSalaryResponse(employeeSalary));
        }
        return salaryList;
    }

}
