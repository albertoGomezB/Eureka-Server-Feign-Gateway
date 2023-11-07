package com.agb.departmentservice.client;

import com.agb.departmentservice.entity.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient(name = "employee-service")
public interface FeignClientEmployees {

    @GetMapping("/employees")
    @ResponseStatus(HttpStatus.OK)
    List<Employee> findAllEmployees ();
}
