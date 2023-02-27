package com.Emp_System.main.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Emp_System.main.entity.Employee;
import com.Emp_System.main.repository.EmpRepository;
import com.Emp_System.main.service.EmpService;

@Controller
public class EmpController {
	@Autowired
	private EmpService empService;

	@Autowired
	private EmpRepository empRepository;

	

	/*
	 * @GetMapping("/") public String home() { return "index"; }
	 */

	@GetMapping("/add_emp")
	public String add_emp() {
		return "add_emp";
	}

	@PostMapping("/register")
	public String registerEmployee(@ModelAttribute Employee employee, HttpSession session) {
		System.out.println(employee);
		empService.addEmployee(employee);
		
		session.setAttribute("msg", "Employee data added successfully");
		System.out.println(employee);
		return "redirect:/";
	}

	

	@GetMapping("/")
	public String getEmployee(Model model) {
		List<Employee> employees = empRepository.findAll();
		model.addAttribute("employees", employees);
		return "index.html";
	}

	@GetMapping("/add_emp2")
	public String addEmployee() {
		
		return "add_emp";
	}

	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Employee emp = empService.getEmployeeById(id);
		model.addAttribute("model", emp);
		return "edit";
	}

	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee employee, HttpSession session) {

		empService.addEmployee(employee);
		session.setAttribute("msg", "Employee data update successfully.");
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {
		empService.deleteEmp(id);
		session.setAttribute("msg", "Emplloyee data deleted sucecssfully.");
		return "redirect:/";
	}

}
