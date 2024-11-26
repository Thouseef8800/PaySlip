package com.thouseef.payslip.entity;

import com.thouseef.payslip.entity.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "salary_slip")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalarySlip {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

   @Column(name ="employee_id",insertable = false,updatable = false,nullable = false)
   private int employee_id;


  @Column(name = "amount")
  private Double amount;

  @Past(message = "The disbursement date must be a past date")
  @Column(name ="disbursementDate",nullable = false)
  private Date disbursementDate;

  @Column(name = "description")
  private String description;

  @ManyToOne
  @JoinColumn(name = "employee_id", nullable = false)
  private Employee employees;


}

