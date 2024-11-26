package com.thouseef.payslip.repo;

import com.thouseef.payslip.entity.SalarySlip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalarySlipRepo extends JpaRepository<SalarySlip, Integer> {
    @Query("select s from SalarySlip s where s.employee_id=?1 order by s.disbursementDate desc")
    SalarySlip findByEmployeeId(int employeeId);

    @Query("select s from SalarySlip s where s.employee_id=?1 order by s.disbursementDate desc")
    List<SalarySlip> findHistoryByEmployeeId(int employeeId);
}
