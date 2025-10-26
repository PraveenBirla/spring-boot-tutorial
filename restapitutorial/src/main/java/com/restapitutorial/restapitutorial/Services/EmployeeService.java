package com.restapitutorial.restapitutorial.Services;


import com.restapitutorial.restapitutorial.DTO.EmployeeDTO;
import com.restapitutorial.restapitutorial.Entity.EmployeeEntity;
import com.restapitutorial.restapitutorial.Repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO getEmployeeByid(Long id) {
          EmployeeEntity employeeEntity =  employeeRepository.findById(id).orElse(null);
        ModelMapper mapper = new ModelMapper();
        return mapper.map(employeeEntity , EmployeeDTO.class);
    }


    public  EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        ModelMapper mapper = new ModelMapper();
       EmployeeEntity employeeEntity =  mapper.map(employeeDTO , EmployeeEntity.class);
        EmployeeEntity  savedEntity =  employeeRepository.save(employeeEntity);
        return mapper.map(savedEntity , EmployeeDTO.class);

    }
}
