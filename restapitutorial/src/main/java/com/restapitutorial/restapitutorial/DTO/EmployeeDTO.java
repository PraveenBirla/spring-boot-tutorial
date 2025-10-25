package com.restapitutorial.restapitutorial.DTO;

import java.time.LocalDate;

public class EmployeeDTO {

    private  Long Id;

    private String name ;

    private String email;

    private int age ;

    private LocalDate joining;

    private Boolean isActive;


    public  EmployeeDTO(){

    }


    public EmployeeDTO(Long id, String name, String email, int age, LocalDate joining, Boolean isActive) {
        Id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.joining = joining;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getJoining() {
        return joining;
    }

    public void setJoining(LocalDate joining) {
        this.joining = joining;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
