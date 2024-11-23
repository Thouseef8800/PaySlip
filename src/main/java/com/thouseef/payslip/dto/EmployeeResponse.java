package com.thouseef.payslip.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmployeeResponse (
        @JsonProperty("id")
        long id,

        @JsonProperty("first_name")
        String first_name,

        @JsonProperty("last_name")
        String last_name,

        @JsonProperty("email")
        String email

)
{

}
