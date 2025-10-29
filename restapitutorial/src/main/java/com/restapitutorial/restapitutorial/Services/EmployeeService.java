package com.restapitutorial.restapitutorial.Services;


import com.restapitutorial.restapitutorial.DTO.EmployeeDTO;
import com.restapitutorial.restapitutorial.Entity.EmployeeEntity;
import com.restapitutorial.restapitutorial.Repository.EmployeeRepository;
import com.restapitutorial.restapitutorial.excption.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeByid(Long id) {
          Optional<EmployeeEntity> employeeEntity =  employeeRepository.findById(id);

          return employeeEntity.map(employeeEntity1 -> modelMapper.map(employeeEntity1 ,
                    EmployeeDTO.class));
    }


    public  EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {

       EmployeeEntity employeeEntity =  modelMapper.map(employeeDTO , EmployeeEntity.class);
        EmployeeEntity  savedEntity =  employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEntity , EmployeeDTO.class);

    }

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {

        boolean isExist = IsEmployeeExistWithId(employeeId);
        if(!isExist) throw new ResourceNotFoundException("Employee is Not Exist with ID:" + employeeId);

        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO , EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity , EmployeeDTO.class);
    }

    public boolean IsEmployeeExistWithId(Long EmployeeID){
        return employeeRepository.existsById(EmployeeID);
    }

    public List<EmployeeDTO> getAllEmployee() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity , EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public void deleteEmployeeById(Long employeeId) {
        Boolean isExist = IsEmployeeExistWithId(employeeId);
        if(!isExist) throw  new ResourceNotFoundException("employe not found with ID "+employeeId);
        employeeRepository.deleteById(employeeId);
    }

    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
        boolean exist = employeeRepository.existsById(employeeId);
        if(!exist) return  null;
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        updates.forEach((field , value) -> {
            Field fieldToBeUpdate = ReflectionUtils.findRequiredField(EmployeeEntity.class , field);
            fieldToBeUpdate.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdate , employeeEntity , value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity) , EmployeeDTO.class);
    }
}
