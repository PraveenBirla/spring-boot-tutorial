package com.example.DataMapping.tutorial.services;

import com.example.DataMapping.tutorial.entities.DepartmentEntity;
import com.example.DataMapping.tutorial.entities.EmployeeEntity;
import com.example.DataMapping.tutorial.repositories.DepartmentRepository;
import com.example.DataMapping.tutorial.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private  final DepartmentRepository departmentRepository ;

    private final EmployeeRepository employeeRepository ;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public  DepartmentEntity createNewDepartment(DepartmentEntity departmentEntity){
        return  departmentRepository.save(departmentEntity);
    }

    public DepartmentEntity getDepartmentById(Long id){
        return departmentRepository.findById(id).orElseGet(null);
    }

    public DepartmentEntity assignManagerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return  departmentEntity.flatMap(department ->
            employeeEntity.map(employeeEntity1 -> {
                department.setManager(employeeEntity1);
                return departmentRepository.save(department);
            })).orElse(null);
    }

    public DepartmentEntity getAssignedDepartmentOfManager(Long employeeId) {
         //Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        // return employeeEntity.map(EmployeeEntity::getManagedDepartment).orElse(null);
      EmployeeEntity employeeEntity = EmployeeEntity.builder()
              .id(employeeId).build();
        return departmentRepository.findByManager(employeeEntity);
    }

    public DepartmentEntity assignWorkerToDepartment(Long departmentId, Long employeeId) {
              Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
              Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

              return departmentEntity.flatMap( department ->
                      employeeEntity.map( employee -> {
                           employee.setWorkerDepartment(department);
                           employeeRepository.save(employee);


                           return  department;
                      })).orElse(null) ;

    }

    public DepartmentEntity assignFreelancerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        return departmentEntity.flatMap( department ->
                employeeEntity.map( employee -> {
                    employee.getFreelanceDepartments().add(department);
                    employeeRepository.save(employee);

                     department.getFreelancers().add(employee);
                    return  department;
                })).orElse(null) ;
    }
}
