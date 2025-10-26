package com.restapitutorial.restapitutorial.Controller;


import com.restapitutorial.restapitutorial.DTO.EmployeeDTO;
import com.restapitutorial.restapitutorial.Entity.EmployeeEntity;
import com.restapitutorial.restapitutorial.Repository.EmployeeRepository;
import com.restapitutorial.restapitutorial.Services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employee")
public class Employee {

//    @GetMapping(path="/secretmessage")
//    public String getSecretString(){
//        return "hello";
//    }
 private final EmployeeService employeeService;

    public Employee(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/{employeeId}")
    //use @PathVariable is used when  parameter is essential part  of URL
    public EmployeeDTO getEmployeeByid(@PathVariable Long employeeId) {
//           return new EmployeeDTO(employeeId , "praveen" , "praveen@gmail.com" , 19 , LocalDate.of(2025 , 12 , 4) , true );
     return  employeeService.getEmployeeByid(employeeId);

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
    public EmployeeDTO addNewemployee(@RequestBody  EmployeeDTO employeeDTO){
      return  employeeService.addEmployee(employeeDTO);

    }




    @PutMapping
    public  String updateEmployee(){
        return "update the  employee";
    }

}
