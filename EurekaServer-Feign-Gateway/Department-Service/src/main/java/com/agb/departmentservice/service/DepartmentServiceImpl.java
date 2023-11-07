package com.agb.departmentservice.service;

import com.agb.departmentservice.entity.Department;
import com.agb.departmentservice.exceptions.DepartmentNotFoundException;
import com.agb.departmentservice.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Department> findAllDepartments() {

        List<Department> departments = departmentRepository.findAll();

        if(departments.isEmpty()) {
            throw new DepartmentNotFoundException("No departments found");
        }
        return departments;
    }

    @Override
    @Transactional(readOnly = true)
    public Department findDepartmentById(Long id) {

        Optional<Department> existingDepartment = departmentRepository.findById(id);

        return existingDepartment.orElseThrow( ()
                -> new DepartmentNotFoundException("Department with this id not found" + id));

    }

    @Override
    public Department saveDepartment(Department department) {

        try{
            return departmentRepository.save(department);

        } catch (Exception e) {
            throw new DepartmentNotFoundException("Error saving department, the department already exists ");
        }

    }

    @Override
    public Department updateDepartment(Department department, Long id) {

        Optional<Department> existingDepartment = departmentRepository.findById(id);

        if (existingDepartment.isPresent()) {

            department.setId(id);
            return departmentRepository.save(department);

        } else {

            throw new DepartmentNotFoundException("Department with this id not found to delete" + id);
        }
    }

    @Override
    public void deleteDepartmentById(Long id) {

        Optional<Department> existingDepartment = departmentRepository.findById(id);

        if (existingDepartment.isPresent()) {
            departmentRepository.deleteById(id);

        } else {
            throw new DepartmentNotFoundException("Department with this id not found" + id);
        }

    }
}
