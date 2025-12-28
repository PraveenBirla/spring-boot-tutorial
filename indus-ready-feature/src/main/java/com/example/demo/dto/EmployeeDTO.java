package com.example.demo.dto;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {

    private  Long Id;


    private String name ;


    private String email;


    private int age ;


    private String role;


    private LocalDate joining;


    private  Double salary;


    private Boolean isActive;


}
