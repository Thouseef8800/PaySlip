package com.thouseef.payslip.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record SalarySlipResponse (

        @JsonProperty("payment_date")
        Date paymentDate,
        @JsonProperty("salary")
        Double salary,
        @JsonProperty("first_name")
        String firstName,
        @JsonProperty("last_name")
        String lastName

)
{
}
