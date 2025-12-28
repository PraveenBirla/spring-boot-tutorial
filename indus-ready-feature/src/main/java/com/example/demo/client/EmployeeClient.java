package com.example.demo.client;

import com.example.demo.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {


    List<EmployeeDTO> getAllEmployee();

       EmployeeDTO getEmployeeById(Long EmployeeId);

      EmployeeDTO createEmployee(EmployeeDTO employeeDTO);
}
