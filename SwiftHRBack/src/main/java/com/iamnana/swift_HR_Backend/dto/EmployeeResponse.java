package com.iamnana.swift_HR_Backend.dto;

public record EmployeeResponse(
        Integer id,
        String firstname,
        String lastname,
        String workEmail,
        String designation
) {
}
