package com.example.demo.entities;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Audited
public class AuditableEntity {

    @CreatedBy
    private String  createdBy;

    @UpdateTimestamp
     private LocalDateTime  updatedTimeDate;

    @CreationTimestamp
    private  LocalDateTime createdTimeDate;

    @LastModifiedBy
    private String  updatedBy;


}
