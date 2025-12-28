package com.example.demo.client.impl;

import com.example.demo.advices.ApiResponse;
import com.example.demo.client.EmployeeClient;
import com.example.demo.dto.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    Logger log =   LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        try {
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient.get()
                    .uri("employee")
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });
     log.debug("successfully retrieve the employees");
            return employeeDTOList.getData();
        }
        catch (Exception e){
            log.error("Exception occurred in getAllEmployee" , e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        try {
            ApiResponse<EmployeeDTO> employeeDTOApiResponse  = restClient.get()
                    .uri("employee/{employeeId}", employeeId)
                    .retrieve()
                    .body(new ParameterizedTypeReference<>() {
                    });

            return  employeeDTOApiResponse.getData();

        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        try{
            ApiResponse<EmployeeDTO> employeeDTOApiResponse = restClient.post()
                    .uri("employee")
                    .body(employeeDTO)
                    .retrieve()
                    .body(new ParameterizedTypeReference<ApiResponse<EmployeeDTO>>() {
                    });

            return employeeDTOApiResponse.getData();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }


}
