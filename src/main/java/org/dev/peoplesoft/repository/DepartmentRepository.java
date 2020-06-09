package org.dev.peoplesoft.repository;

import org.dev.peoplesoft.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer>  {

}
