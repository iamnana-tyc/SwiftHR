package com.iamnana.swift_HR_Backend.service;

import com.iamnana.swift_HR_Backend.dto.EmployeeDto;
import com.iamnana.swift_HR_Backend.dto.EmployeeResponse;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    EmployeeResponse saveEmployee(EmployeeDto employeeDto);
    List<EmployeeResponse> getAllEmployee();
    Optional<EmployeeResponse> getEmployeeById(Integer id);
    EmployeeResponse updateEmployee(EmployeeDto employeeDto, Integer id);
    String deleteEmployeeById(Integer id);
}
