package com.example.demo;

import com.example.demo.client.EmployeeClient;
import com.example.demo.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    EmployeeClient employeeClient;

	@Test
    void getallemployee(){
       List<EmployeeDTO> employeeDTOList = employeeClient.getAllEmployee();
        System.out.println(employeeDTOList);
    }




    @Test
     void createnewEmployee(){
        EmployeeDTO employeeDTO = new EmployeeDTO(null , "praveen" , "praveen@gmail.com" , 20
          ,"USER" , LocalDate.now(),Double.valueOf(90000), true );
        EmployeeDTO employeeDTOSaved = employeeClient.createEmployee(employeeDTO);

        System.out.println(employeeDTO);
    }

    @Test
    void getEmployeeById(){
        EmployeeDTO employeeDTO = employeeClient.getEmployeeById(1L);
        System.out.println(employeeDTO);

    }
}
