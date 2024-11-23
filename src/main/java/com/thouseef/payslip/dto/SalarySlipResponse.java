package com.thouseef.payslip.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record SalarySlipResponse (

    @JsonProperty("id")
    long id,


    @JsonProperty("amount")
    Double amount,

    @JsonProperty("disbursementDate")
    LocalDate disbursementDate,


    @JsonProperty("month")
    String month

)
{
}
