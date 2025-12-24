package com.example.DataMapping.tutorial.controllers;

import com.example.DataMapping.tutorial.entities.EmployeeEntity;
import com.example.DataMapping.tutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private  final EmployeeService employeeService ;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable Long employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeEntity addEmployee(@RequestBody EmployeeEntity employeeEntity){
        return employeeService.addEmployee(employeeEntity);
    }
}
