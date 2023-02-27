package com.Emp_System.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Emp_System.main.entity.Employee;
@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
