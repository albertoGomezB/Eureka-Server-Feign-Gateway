package com.agb.employeeservice.controller;

import com.agb.employeeservice.entity.Employee;
import com.agb.employeeservice.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findAllEmployees () {

        return employeeService.findAllEmployees();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee findEmployeeById (@PathVariable Long id) {

        return employeeService.findEmployeeById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Employee saveEmployee (@RequestBody Employee employee) {

        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee updateEmployee (@RequestBody Employee employee,@PathVariable Long id) {

        return employeeService.updateEmployee(employee, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployeeById (@PathVariable Long id) {

        employeeService.deleteEmployeeById(id);
    }


}
