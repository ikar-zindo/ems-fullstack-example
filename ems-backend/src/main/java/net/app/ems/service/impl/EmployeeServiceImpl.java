package net.app.ems.service.impl;

import lombok.AllArgsConstructor;
import net.app.ems.dto.EmployeeDto;
import net.app.ems.entity.Employee;
import net.app.ems.exception.ResourceNotFoundException;
import net.app.ems.exception.errorMessage.ErrorMessage;
import net.app.ems.mapper.EmployeeMapper;
import net.app.ems.repository.EmployeeRepository;
import net.app.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

   private EmployeeRepository employeeRepository;

   // CREATE
   @Override
   public EmployeeDto createEmployee(EmployeeDto employeeDto) {

      Employee savedEmployee = employeeRepository.save(EmployeeMapper.mapToEmployee(employeeDto));
      return EmployeeMapper.mapToEmployeeDto(savedEmployee);
   }

   // READ
   @Override
   public EmployeeDto getEmployeeById(UUID employeeId) throws ResourceNotFoundException {

      if (employeeId != null) {
         Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
//              .orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.EMPLOYEE_IS_NOT_EXIST + employeeId));

         if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            return EmployeeMapper.mapToEmployeeDto(employee);

         } else {
            throw new ResourceNotFoundException(ErrorMessage.EMPLOYEE_IS_NOT_EXIST + employeeId);
         }
      } else {
         throw new ResourceNotFoundException(ErrorMessage.ID_CANNOT_BE_NULL);
      }
   }

   @Override
   public List<EmployeeDto> getAllEmployees() {
      List<Employee> employees =  employeeRepository.findAll();
      return employees.stream()
              .map(EmployeeMapper::mapToEmployeeDto)
              .collect(Collectors.toList());
   }

   @Override
   public EmployeeDto updateEmployee(UUID employeeId, EmployeeDto updatedEmployeeDto) throws ResourceNotFoundException {

      Employee employee = employeeRepository.findById(employeeId)
              .orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.EMPLOYEE_IS_NOT_EXIST + employeeId));

      employee.setFirstName(updatedEmployeeDto.getFirstName());
      employee.setLastName(updatedEmployeeDto.getLastName());
      employee.setEmail(updatedEmployeeDto.getEmail());

      Employee updatedEmployee = employeeRepository.save(employee);

      return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
   }

   @Override
   public void deleteEmployee(UUID employeeId) {
      Employee employee = employeeRepository.findById(employeeId)
              .orElseThrow(() -> new ResourceNotFoundException(ErrorMessage.EMPLOYEE_IS_NOT_EXIST + employeeId));

      employeeRepository.deleteById(employeeId);
   }
}