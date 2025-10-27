package com.restapitutorial.restapitutorial.DTO;

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

    private String name ;

    private String email;

    private int age ;

    private LocalDate joining;

    private Boolean isActive;



}
