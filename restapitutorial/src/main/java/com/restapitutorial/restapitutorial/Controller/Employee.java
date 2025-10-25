package com.restapitutorial.restapitutorial.Controller;


import com.restapitutorial.restapitutorial.DTO.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employee")
public class Employee {

//    @GetMapping(path="/secretmessage")
//    public String getSecretString(){
//        return "hello";
//    }


    @GetMapping(path = "/{employeeId}")
    //use @PathVariable is used when  parameter is essential part  of URL
    public EmployeeDTO getEmployee(@PathVariable Long employeeId) {
           return new EmployeeDTO(employeeId , "praveen" , "praveen@gmail.com" , 19 , LocalDate.of(2025 , 12 , 4) , true );
    }

//      @GetMapping(path = "/{employeeId}")
//    public EmployeeDTO getEmployee(@PathVariable(name="employeeId") Long  Id) {
//        return new EmployeeDTO( Id, "praveen" , "praveen@gmail.com" , 19 , LocalDate.of(2025 , 12 , 4) , true );
//    }


    @GetMapping
     // use query parameter when this is optional
     public String getAllemployee(@RequestParam(required = false)  Integer age , @RequestParam(required = false)  String byAge ){
         return  "age is " + age  + " "  ;
     }


//    @GetMapping()
//    public String getAllemployee(@RequestParam(required = false , name = "inputAge") int age , @RequestParam(required = false)  String byAge ){
//        return  "age is " + age  + " "  ;
//    }

    @PostMapping
    public String addNewemployee(){
        return "add employee";
    }

    @PutMapping
    public  String updateEmployee(){
        return "update the  employee";
    }

}
