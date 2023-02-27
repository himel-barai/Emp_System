package com.Emp_System.main.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Emp_System.main.entity.Employee;
import com.Emp_System.main.repository.EmpRepository;
@Service
public class EmpService {
	
	@Autowired
	 private EmpRepository empRepo;

	public void addEmployee(Employee employee) {

		empRepo.save(employee);
	}
	
	public Employee getEmployeeById(int id) {
		Optional<Employee> e = empRepo.findById(id);
		if(e.isPresent()) {
			return e.get();
		}
		return null;
	}
	
	public void deleteEmp(int id) {
		empRepo.deleteById(id);
	}
}
