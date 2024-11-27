package com.thouseef.payslip.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record EmployeeRequest(
        @NotNull(message = "Employee should be present")
        @NotEmpty(message = "Employee should be present")
        @NotBlank(message = "Employee should be present")

        String firstName,

        String lastName,

        @NotNull(message = "Employee email is required")
        @Email(message = "Email must be in correct format")

        String email,

        @NotNull(message = "Password should be present")
        @NotEmpty(message = "Password should be present")
        @NotBlank(message = "Password should be present")
        @Size(min = 6, max = 12)

        String password,


        String title,


        String photographPath,


        int department
) {

}

