package com.iamnana.swift_HR_Backend.repo;

import com.iamnana.swift_HR_Backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
