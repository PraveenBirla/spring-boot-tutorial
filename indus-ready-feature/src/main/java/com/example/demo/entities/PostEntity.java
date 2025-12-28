package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name="posts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Audited
public class PostEntity  extends AuditableEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String title;

    private String description;

}
