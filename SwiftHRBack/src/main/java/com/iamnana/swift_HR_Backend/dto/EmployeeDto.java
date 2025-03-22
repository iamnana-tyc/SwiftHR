package com.iamnana.swift_HR_Backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record EmployeeDto(
        @NotNull(message = "Enter the firstname.")
        String firstname,
        @NotNull(message = "Enter the lastname.")
        String lastname,
        @Email(message = "Use the correct email format.")
        String workEmail,
        @NotNull(message = "Enter the role.")
        String designation


) {
}
