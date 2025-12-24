package com.example.DataMapping.tutorial.services;


import com.example.DataMapping.tutorial.entities.EmployeeEntity;
import com.example.DataMapping.tutorial.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private  final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeEntity addEmployee(EmployeeEntity employeeEntity){
        return employeeRepository.save(employeeEntity);

    }

    public EmployeeEntity getEmployeeById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }
}
