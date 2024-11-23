package com.thouseef.payslip.repo;

import com.thouseef.payslip.entity.SalarySlip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalarySlipRepo extends JpaRepository<SalarySlip, Integer> {
    Optional<SalarySlip> findById(Integer integer);
}
