package com.thouseef.payslip.repo;

import com.thouseef.payslip.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    @Override
    Optional<Employee> findById(long id);


}