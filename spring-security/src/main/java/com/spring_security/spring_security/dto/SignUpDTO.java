package com.spring_security.spring_security.dto;

import com.spring_security.spring_security.entities.enums.Permission;
import com.spring_security.spring_security.entities.enums.Roles;
import lombok.Data;

import java.util.Set;

@Data
public class SignUpDTO {

    private String email;

    private String password;

   private String name;

   private Set<Roles> roles;

   private Set<Permission> permissions;

}
