package com.thouseef.payslip.repo;

import com.thouseef.payslip.entity.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepo extends JpaRepository<EmployeeSalary, Integer> {

    @Query("select s from EmployeeSalary s where s.employee_id=?1 order by s.paymentDate desc limit 2")
    List<EmployeeSalary> findByEmployeeId(@Param("employeeId") int employeeId);

    @Query("select s from EmployeeSalary s where s.employee_id=?1 order by s.paymentDate desc")
    List<EmployeeSalary> findHistoryByEmployeeId(int employeeId);
}