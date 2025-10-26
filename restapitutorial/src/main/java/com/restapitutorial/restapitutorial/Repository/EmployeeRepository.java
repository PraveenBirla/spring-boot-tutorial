package com.restapitutorial.restapitutorial.Repository;

import com.restapitutorial.restapitutorial.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity , Long> {

}
