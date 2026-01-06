package com.restapitutorial.restapitutorial.repository;

import com.restapitutorial.restapitutorial.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity , Long> {
      List<EmployeeEntiy> findByEmail(String email);
}
