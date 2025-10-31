package com.restapitutorial.restapitutorial.dto;

import com.restapitutorial.restapitutorial.annotation.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private  Long Id;

    @NotBlank(message="name is not blank")
    @Size(min=3 , max = 10 , message = "the size of name feild is between 3 to 10")
    private String name ;

   @NotBlank(message = "email of employee cannot null")
    @Email(message = "Email should be a valid email")
    private String email;

   @NotNull
    @Max(value = 80, message = "Age cannot be greater than 80")
    @Min(value = 18, message="Age cannot be lesser than 18")
    private int age ;

    @NotBlank(message = "role of employee cannot be blank")
//    @Pattern(regexp = "^(ADMIN|USER)$" , message = "role of employee is not correct")
    @EmployeeRoleValidation
    private String role;


    @PastOrPresent(message = "dateofjoining of employee cannot in the future")
    private LocalDate joining;

    @NotNull
    @Positive(message = "salary of Employee should not be positive")
    @Digits(integer = 6 , fraction = 2 , message = "the salary can be in the form xxxxxx.yy")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private  Double salary;

   @AssertTrue
    private Boolean isActive;


}
