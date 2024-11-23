package com.thouseef.payslip.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record EmployeeRequest (

    @JsonProperty("id")
    long id,

    @NotNull(message = "first name id should not be NULL")
    @NotEmpty(message = "first name id should not be empty")
    @NotBlank(message = "first name id should not be blank")
    @JsonProperty("first_name")
    String first_name,

    @JsonProperty("last_name")
    String last_name,


    @JsonProperty("email")
    String email,


    @NotNull(message = "Password is mandatory")
    @JsonProperty("password")
    String password



)
{

}


