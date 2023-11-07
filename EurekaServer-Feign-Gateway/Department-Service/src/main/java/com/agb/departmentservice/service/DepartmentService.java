package com.agb.departmentservice.service;

import com.agb.departmentservice.entity.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findAllDepartments();

    Department findDepartmentById(Long id);

    Department saveDepartment(Department department);

    Department updateDepartment(Department department, Long id);

    void deleteDepartmentById(Long id);
}
