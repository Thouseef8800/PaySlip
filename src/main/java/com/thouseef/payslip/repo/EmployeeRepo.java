package com.thouseef.payslip.repo;

import com.thouseef.payslip.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Integer> {
    Employees findByEmail(String username);
}
