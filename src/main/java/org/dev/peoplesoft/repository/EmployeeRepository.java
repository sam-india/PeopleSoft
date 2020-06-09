package org.dev.peoplesoft.repository;

import java.util.List;

import org.dev.peoplesoft.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>  {

	Employee findByEmail(String email);
	
	Employee findEmployeesByLastName(String lastName);
	
	List<Employee> findEmployeesByDepartmentId(Integer departmentId);
}
