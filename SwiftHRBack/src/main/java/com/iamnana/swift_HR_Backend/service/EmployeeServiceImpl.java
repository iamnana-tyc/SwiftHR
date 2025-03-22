package com.iamnana.swift_HR_Backend.service;

import com.iamnana.swift_HR_Backend.dto.EmployeeDto;
import com.iamnana.swift_HR_Backend.dto.EmployeeResponse;
import com.iamnana.swift_HR_Backend.mapper.EmployeeMapper;
import com.iamnana.swift_HR_Backend.model.Employee;
import com.iamnana.swift_HR_Backend.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeResponse saveEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.mapToEmployee(employeeDto);
        Employee saveEmployee = employeeRepository.save(employee);
        return employeeMapper.mapToEmployeeResponse(saveEmployee);
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {
        return employeeRepository.findAll()
                .stream()
                .map(employeeMapper::mapToEmployeeResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeResponse> getEmployeeById(Integer id) {
        return employeeRepository.findById(id).map(employeeMapper::mapToEmployeeResponse);
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeDto employeeDto, Integer id) {
        Employee findEmployee = employeeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employee could not be found."));

        findEmployee.setFirstname(employeeDto.firstname());
        findEmployee.setLastname(employeeDto.lastname());
        findEmployee.setWorkEmail(employeeDto.workEmail());
        findEmployee.setDesignation(employeeDto.designation());

        Employee saveUpdate = employeeRepository.save(findEmployee);

        return employeeMapper.mapToEmployeeResponse(saveUpdate);
    }

    @Override
    public String deleteEmployeeById(Integer id) {
         employeeRepository.deleteById(id);
        return "Employee successfully deleted.";
    }
}
