package net.app.ems.conroller;

import lombok.AllArgsConstructor;
import net.app.ems.dto.EmployeeDto;
import net.app.ems.exception.errorMessage.ErrorMessage;
import net.app.ems.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

   private EmployeeService employeeService;

   // Build Add Employee REST API
   @PostMapping()
   public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {

      EmployeeDto savedEmployeeDto = employeeService.createEmployee(employeeDto);
      return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
   }

   // Build Get Employee REST API
   // 0000018f-8342-8b53-7885-aa32138a46ea
   // 0000018f-8386-69d9-8214-19dc49804b9e
   // 0000018f-85f8-e7ae-9a26-4431bc5345d0
   // 0000018f-85fa-35b5-196a-5770a1b241fb
   @GetMapping("/{id}")
   public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") UUID employeeId) {
      EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
      return ResponseEntity.ok(employeeDto);
   }

   // Build Get All Employees REST API
   @GetMapping
   public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
      List<EmployeeDto> employeesDto = employeeService.getAllEmployees();
      return ResponseEntity.ok(employeesDto);
   }

   // Build Update Employee REST API
   @PutMapping("/{id}")
   public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") UUID employeeId,
                                                     @RequestBody EmployeeDto updateEmployee) {

      EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updateEmployee);
      return ResponseEntity.ok(employeeDto);
   }

   // Build Delete Employee REST API
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteEmployee(@PathVariable("id") UUID employeeId) {
      employeeService.deleteEmployee(employeeId);
      return ResponseEntity.ok(ErrorMessage.EMPLOYEE_DELETED);
   }
}
