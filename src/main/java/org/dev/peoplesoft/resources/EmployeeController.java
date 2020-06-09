package org.dev.peoplesoft.resources;

import java.util.List;

import org.dev.peoplesoft.model.Department;
import org.dev.peoplesoft.model.Employee;
import org.dev.peoplesoft.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(value = "/departments/{dept_id}/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping(value = "/")
	public Employee addEmployee(@RequestBody Employee e1,@PathVariable("dept_id") Integer departmentId)
	{
		Department d = new Department();
		d.setDepartmentId(departmentId);
		e1.setDepartment(d);
		employeeService.addEmployee(e1);
		return e1;
	}
	
	@RequestMapping(value = "/{emp_id}")
	public Employee getEmployee(@PathVariable("emp_id") Integer employeeId)
	{
		Employee employee = employeeService.getEmployee(employeeId); 
		//employee.getDepartment().getEmployee().clear();
		return employee;
	}
	
	@RequestMapping(value = "/")
	public List<Employee> getAllEmployeeByDepartmentId(@PathVariable("dept_id") Integer departmentId)
	{
		return employeeService.getAllEmployeeByDepartmentId(departmentId);
	}
	
	@PutMapping(value = "/")
	public void updateEmployee(@RequestBody Employee e1)
	{
		employeeService.updateEmployee(e1);
	}
	
	@DeleteMapping(value = "/")
	public void deleteEmployee(@RequestBody Employee e1)
	{
		employeeService.delete(e1);
	}
	
/*

	
	@RequestMapping(value = "/email/{email}")
	public Employee getEmployeeByEmail(@PathVariable("email") String email)
	{
		return employeeService.getEmployeeByEmail(email);
	}
	
	@RequestMapping(value = "/lastname/{lastname}")
	public Employee getEmployeeByLastname(@PathVariable("lastname") String lastname)
	{
		return employeeService.getEmployeeByLastname(lastname);
	}
	
*/
}