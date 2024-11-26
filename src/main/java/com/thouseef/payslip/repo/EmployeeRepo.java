package com.thouseef.payslip.repo;

import com.thouseef.payslip.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Employee findByEmail(String username);


}
