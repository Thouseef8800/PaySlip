package com.thouseef.payslip.entity;

import com.thouseef.payslip.entity.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "salary_slip")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalarySlip {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;


  private long employee;

  @Column(nullable = false)
  private Double amount;

  @Past(message = "The disbursement date must be a past date")
  @Column(nullable = false)
  private LocalDate disbursementDate;

  @Column(nullable = false)
  private String month;

}

