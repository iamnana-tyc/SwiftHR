package com.iamnana.swift_HR_Backend.controller;

import com.iamnana.swift_HR_Backend.dto.EmployeeDto;
import com.iamnana.swift_HR_Backend.dto.EmployeeResponse;
import com.iamnana.swift_HR_Backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> saveEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse>> findAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
    }

    @GetMapping("/{employee-id}")
    public ResponseEntity<Optional<EmployeeResponse>> findEmployeeById(
            @PathVariable("employee-id") Integer id){
        return new ResponseEntity<>(employeeService.getEmployeeById(id) ,HttpStatus.OK);
    }

    @PutMapping("/{employee-id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(
            @PathVariable("employee-id") Integer id, @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.updateEmployee(employeeDto, id) ,HttpStatus.OK);
    }

    @DeleteMapping("/{employee-id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable("employee-id") Integer id){
        return new ResponseEntity<>(employeeService.deleteEmployeeById(id), HttpStatus.OK);
    }
}
