package org.dev.peoplesoft.resources;

import java.util.List;

import org.dev.peoplesoft.model.Department;
import org.dev.peoplesoft.service.DepartmentService;
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
@RequestMapping(value = "/departments")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value = "/{id}")
	public Department getDepartment(@PathVariable("id") Integer departmentId)
	{
		return departmentService.getDepartment(departmentId);
	}
	
	
	@RequestMapping(value = "/")
	public List<Department> getAllDepartment()
	{
		return departmentService.getAllDepartment();
	}
	
	@PostMapping(value = "/")
	public Department addDepartment(@RequestBody Department department)
	{
		departmentService.addDepartment(department);
		return department;
	}
	
	@PutMapping(value = "/")
	public Department updateDepartment(@RequestBody Department department)
	{
		departmentService.updateDepartment(department);
		return department;
	}
	
	@DeleteMapping(value = "/{id}")
	public Department removeDepartment(@RequestBody Department department, @PathVariable("id") Integer departmentId)
	{
		departmentService.removeDepartment(department,departmentId);
		return department;
	}
}