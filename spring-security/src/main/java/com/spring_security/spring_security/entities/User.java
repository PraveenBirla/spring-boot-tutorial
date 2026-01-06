package com.spring_security.spring_security.entities;


import com.spring_security.spring_security.entities.enums.Permission;
import com.spring_security.spring_security.entities.enums.Roles;
import com.spring_security.spring_security.utils.PermissionMapping;
import jakarta.persistence.*;
import lombok.*;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Builder
public class User  implements UserDetails {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id ;

       @Column(unique = true)
       private String email;

       private String password;

       private String name;

       @ElementCollection(fetch = FetchType.EAGER)
       @Enumerated(EnumType.STRING)
       private Set<Roles> roles ;

        @ElementCollection(fetch = FetchType.EAGER)
       @Enumerated(EnumType.STRING)
       private Set<Permission> permissions;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       Set<SimpleGrantedAuthority> authorities = new HashSet<>();

       roles.forEach(
              roles1 -> { Set<SimpleGrantedAuthority> permissions =
                       PermissionMapping.getAuthorityForRole(roles1);
                  authorities.add(new SimpleGrantedAuthority("ROLE_" + roles1.name()));
                authorities.addAll(permissions);
              }
       );
        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return  this.password ;
    }

    @Override
    public String getUsername() {
        return  this.email;
    }
}
