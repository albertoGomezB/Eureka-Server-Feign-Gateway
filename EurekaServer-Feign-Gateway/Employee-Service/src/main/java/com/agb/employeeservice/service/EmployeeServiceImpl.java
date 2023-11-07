package com.agb.employeeservice.service;

import com.agb.employeeservice.entity.Employee;
import com.agb.employeeservice.exception.EmployeeNotFoundException;
import com.agb.employeeservice.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        if(employees.isEmpty()) {
            throw new EmployeeNotFoundException("No employees found");
        }
        return employees;
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findEmployeeById(Long id) {

       Optional<Employee> existingEmployee = employeeRepository.findById(id);

       return existingEmployee.orElseThrow(()
               -> new EmployeeNotFoundException("Employee with this id not found " + id));
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        try {
            return employeeRepository.save(employee);

        } catch (Exception e) {

            throw new EmployeeNotFoundException("Error saving employee, the employee already exists ");
        }
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {

        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if (existingEmployee.isPresent()) {

            employee.setId(id);
            return employeeRepository.save(employee);

        } else {
            throw new EmployeeNotFoundException("Employee with this id not found to update " + id);
        }
    }

    @Override
    public void deleteEmployeeById(Long id) {

        Optional<Employee> existingEmployee = employeeRepository.findById(id);

       if (existingEmployee.isPresent()) {
              employeeRepository.deleteById(id);

         } else {
              throw new EmployeeNotFoundException("Employee with this id not found to delete " + id);
       }
    }
}
