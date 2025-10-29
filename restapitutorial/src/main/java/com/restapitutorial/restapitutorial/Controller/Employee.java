package com.restapitutorial.restapitutorial.Controller;


import com.restapitutorial.restapitutorial.DTO.EmployeeDTO;
import com.restapitutorial.restapitutorial.Entity.EmployeeEntity;
import com.restapitutorial.restapitutorial.Repository.EmployeeRepository;
import com.restapitutorial.restapitutorial.Services.EmployeeService;
import com.restapitutorial.restapitutorial.excption.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public ResponseEntity<EmployeeDTO> getEmployeeByid(@PathVariable Long employeeId) {
        Optional<EmployeeDTO> employeeDTO =   employeeService.getEmployeeByid(employeeId);

        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                 .orElseThrow( () -> new ResourceNotFoundException("employee not found " +  employeeId));

    }




//      @GetMapping(path = "/{employeeId}")
//    public EmployeeDTO getEmployee(@PathVariable(name="employeeId") Long  Id) {
//        return new EmployeeDTO( Id, "praveen" , "praveen@gmail.com" , 19 , LocalDate.of(2025 , 12 , 4) , true );
//    }



    @GetMapping
     // use query parameter when this is optional
     public ResponseEntity<List<EmployeeDTO>> getAllemployee(@RequestParam(required = false)  Integer age , @RequestParam(required = false)  String byAge ){
         return   ResponseEntity.ok(employeeService.getAllEmployee()) ;
     }



//    @GetMapping()
//    public String getAllemployee(@RequestParam(required = false , name = "inputAge") int age , @RequestParam(required = false)  String byAge ){
//        return  "age is " + age  + " "  ;
//    }



    @PostMapping
    public ResponseEntity<EmployeeDTO> addNewemployee(@RequestBody  EmployeeDTO employeeDTO){
       EmployeeDTO savedEmployee =  employeeService.addEmployee(employeeDTO);
       return new ResponseEntity<>(savedEmployee , HttpStatus.CREATED);

    }


    @PutMapping(path = "/{employeeId}") //used for update whole data
    public  ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable Long employeeId , @RequestBody EmployeeDTO employeeDTO){
        return  ResponseEntity.ok(employeeService.updateEmployeeById(employeeId , employeeDTO)) ;
    }


    @DeleteMapping(path ="/{employeeId}")
    public void deleteEmployeeById(@PathVariable Long employeeId){
          employeeService.deleteEmployeeById(employeeId);
    }

    @PatchMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@PathVariable Long employeeId , @RequestBody Map<String , Object> updates ){
           EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(employeeId , updates);
           if(employeeDTO == null) return  ResponseEntity.notFound().build();
           return ResponseEntity.ok(employeeDTO);
    }


}
