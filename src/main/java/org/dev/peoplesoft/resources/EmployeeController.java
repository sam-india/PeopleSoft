package org.dev.peoplesoft.resources;

import java.util.List;

import org.dev.peoplesoft.model.Employee;
import org.dev.peoplesoft.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value = "/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value = "/{id}")
	public Employee getEmployee(@PathVariable("id") Integer employeeId)
	{
		return employeeService.getEmployee(employeeId);
	}
	
	@RequestMapping(value = "/")
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployeeEM();
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody Employee e1)
	{
		employeeService.addEmployee(e1);
		return e1;
	}
}
