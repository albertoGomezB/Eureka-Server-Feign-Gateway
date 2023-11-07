package com.agb.departmentservice.controller;

import com.agb.departmentservice.client.FeignClientEmployees;
import com.agb.departmentservice.entity.Department;
import com.agb.departmentservice.entity.Employee;
import com.agb.departmentservice.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;
    private final FeignClientEmployees feignClientEmployees;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Department> findAllDepartments() {

        return departmentService.findAllDepartments();
    }

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    List<Employee> findAllEmployees () {

        return feignClientEmployees.findAllEmployees();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department findDepartmentById(@PathVariable Long id) {

        return departmentService.findDepartmentById(id);
    }

   @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Department saveDepartment(@RequestBody Department department) {

        return departmentService.saveDepartment(department);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Department updateDepartment(@RequestBody Department department, @PathVariable Long id) {

        return departmentService.updateDepartment(department, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployeeById(@PathVariable Long id) {

        departmentService.deleteDepartmentById(id);
    }


}
