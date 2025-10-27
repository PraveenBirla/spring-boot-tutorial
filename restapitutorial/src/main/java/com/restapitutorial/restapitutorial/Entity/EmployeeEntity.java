package com.restapitutorial.restapitutorial.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="employee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private String name ;

    private String email;

    private int age ;

    private LocalDate joining;

    private Boolean isActive;



}
