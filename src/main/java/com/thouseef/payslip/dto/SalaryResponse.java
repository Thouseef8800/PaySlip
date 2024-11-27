package com.thouseef.payslip.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

public record SalaryResponse(

        @JsonFormat(pattern="dd-MM-yyyy")
        LocalDateTime paymentDate,

        int salary,

        String description
) {
}