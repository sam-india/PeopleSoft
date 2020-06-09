package org.dev.peoplesoft.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.dev.peoplesoft.model.Employee;
import org.dev.peoplesoft.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	EmployeeRepository employeeRepository; 
	
	public void addEmployee(Employee employee)
	{
		employeeRepository.save(employee);
	}
	
	public void updateEmployee(Employee employee)
	{
		employeeRepository.save(employee);
	}
	
	public Employee getEmployee(Integer employeeId) 
	{
		return employeeRepository.findById(employeeId).get();
	}
	
	public void delete(Employee employee)
	{
		employeeRepository.delete(employee);
	}
	
	public List<Employee> filterEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		List<Employee> filteredAndSortedemployees = new ArrayList<Employee>();
		employees.stream()
		.filter(employee -> employee.getDepartment().getDepartmentId() != null && employee.getDepartment().getDepartmentId() == 50)
		.sorted((e1,e2) -> e1.getFirstName().compareTo(e2.getFirstName()))
		.sorted((e1,e2) -> e1.getManagerId().compareTo(e2.getManagerId()))
		.forEachOrdered(emp -> filteredAndSortedemployees.add(emp));
		
		//.collect(Collectors.toList());
		return filteredAndSortedemployees;
	}
	
	public List<Employee> getAllEmployeeEM() {
		List<Employee> employees = new ArrayList<Employee>();
		TypedQuery<Employee> queries = entityManager.createNamedQuery("Employee.findAllEmployeesByLastNameLength", Employee.class);
		queries.setParameter("length", 3L);
		employees = queries.getResultList();
		return employees;
	}

	public Employee getEmployeeByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}

	public Employee getEmployeeByLastname(String lastName) {
		return employeeRepository.findEmployeesByLastName(lastName);
	}

	public List<Employee> getAllEmployeeByDepartmentId(Integer departmentId) {
		return employeeRepository.findEmployeesByDepartmentId(departmentId);
	}
	
	/*
	 	{
//		Employee e = new Employee(101,"Steven", "King", "SKING", "515.123.4567", new Date("1987-06-17 00:00:00.0"), 
//						"AD_PRES", BigDecimal.valueOf(24000.00), BigDecimal.valueOf(0.0), 0, (short)90);
//		
		/*
		 * Employee e1 = new Employee(); e1.setEmpId(101); e1.setFirstName("Steven");
		 * e1.setLastName("Steven"); e1.setEmail("SKING");
		 * e1.setPhoneNumber("515.123.4567"); try { e1.setHireDate(new
		 * SimpleDateFormat("YYYY-MM-DD HH:mm:ss").parse("1987-06-17 00:00:00")); }
		 * catch (ParseException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } e1.setJobId("AD_PRES");
		 * e1.setSalary(BigDecimal.valueOf(24000.00));
		 * e1.setCommissionPct(BigDecimal.valueOf(0.0)); e1.setManagerId(0);
		 * e1.setDepartmentId((short) 90); return e1;
		 */
		
}
