package com.agb.employeeservice.service;

import com.agb.employeeservice.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAllEmployees();

    Employee findEmployeeById (Long id);

    Employee saveEmployee (Employee employee);

    Employee updateEmployee (Employee employee, Long id);

    void deleteEmployeeById(Long id);
}
