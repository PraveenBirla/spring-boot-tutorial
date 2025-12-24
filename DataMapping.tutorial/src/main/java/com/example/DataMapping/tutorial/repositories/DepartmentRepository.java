package com.example.DataMapping.tutorial.repositories;

import com.example.DataMapping.tutorial.entities.DepartmentEntity;
import com.example.DataMapping.tutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity ,Long> {
    DepartmentEntity findByManager(EmployeeEntity employeeEntity);

}
