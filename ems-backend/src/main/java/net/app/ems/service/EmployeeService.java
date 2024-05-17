package net.app.ems.service;

import net.app.ems.dto.EmployeeDto;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

   EmployeeDto createEmployee(EmployeeDto employeeDto);

   EmployeeDto getEmployeeById(UUID employeeId);

   List<EmployeeDto> getAllEmployees();

   EmployeeDto updateEmployee(UUID employeeId, EmployeeDto employeeDto);

   void deleteEmployee(UUID employeeId);
}