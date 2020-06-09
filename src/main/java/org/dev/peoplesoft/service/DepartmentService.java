package org.dev.peoplesoft.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.dev.peoplesoft.model.Department;
import org.dev.peoplesoft.repository.DepartmentRepository;
import org.dev.peoplesoft.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
	
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	DepartmentRepository departmentRepository; 
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}

	public Department getDepartment(Integer departmentId) {

		return departmentRepository.findById(departmentId).get();
	}

	public void addDepartment(Department department) {
		departmentRepository.save(department);
	}

	public void updateDepartment(Department department) {
		departmentRepository.save(department);		
	}

	public void removeDepartment(Department department, Integer departmentId) {
		departmentRepository.deleteById(departmentId);		
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
