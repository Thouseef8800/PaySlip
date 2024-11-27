package com.thouseef.payslip.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record EmployeeResponse(

        String firstName,

        String lastName,

        String email,

        String title,

        String department){
}