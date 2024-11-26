package com.thouseef.payslip.service;

import com.thouseef.payslip.dto.SalarySlipResponse;
import com.thouseef.payslip.entity.SalarySlip;
import com.thouseef.payslip.mapper.SalaryMapper;
import com.thouseef.payslip.repo.EmployeeRepo;
import com.thouseef.payslip.repo.SalarySlipRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeSalaryService {
    @Autowired
    SalarySlipRepo salaryRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    SalaryMapper mapper;

    public SalarySlipResponse getLastSalary(String emailAddress) {

        return mapper.toSalarySlipResponse(salaryRepo.findByEmployeeId((int) employeeRepo.findByEmail(emailAddress).getEmployee_id()));
    }

    public List<SalarySlipResponse> getSalaryHistory(String emailAddress) {
        List<SalarySlip> latestSalary = salaryRepo.findHistoryByEmployeeId((int) employeeRepo.findByEmail(emailAddress).getEmployee_id());
        List<SalarySlipResponse> salaryList = new ArrayList<>();

        for(SalarySlip employeeSalary : latestSalary) {
            salaryList.add(mapper.toSalarySlipResponse(employeeSalary));
        }
        return salaryList;
    }

}
