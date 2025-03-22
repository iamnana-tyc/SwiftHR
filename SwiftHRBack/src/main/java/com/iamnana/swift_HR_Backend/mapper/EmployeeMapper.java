package com.iamnana.swift_HR_Backend.mapper;

import com.iamnana.swift_HR_Backend.dto.EmployeeDto;
import com.iamnana.swift_HR_Backend.dto.EmployeeResponse;
import com.iamnana.swift_HR_Backend.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {
    public Employee mapToEmployee(EmployeeDto employeeDto){

        Employee employee = new Employee();
        employee.setFirstname(employeeDto.firstname());
        employee.setLastname(employeeDto.lastname());
        employee.setWorkEmail(employeeDto.workEmail());
        employee.setDesignation(employeeDto.designation());
        return employee;
    }

    public EmployeeResponse mapToEmployeeResponse(Employee employee){
        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getWorkEmail(),
                employee.getDesignation()
        );
    }
}
