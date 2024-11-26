package com.thouseef.payslip.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmployeeResponse (
        @JsonProperty("first_name")
        String first_name,
        @JsonProperty("last_name")
        String last_name,
        @JsonProperty("email")
        String email,
        @JsonProperty("title")
        String title,
        @JsonProperty("photograph_path")
        String photographPath,
        @JsonProperty("department")
        long department

)
{

}
