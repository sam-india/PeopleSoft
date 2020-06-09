package org.dev.peoplesoft.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="departments")
@SequenceGenerator(
		sequenceName = "DEPT_SEQ_STORE", name = "DEPT_SEQ", initialValue = 100
		)
//@NamedQuery(name="Department.findAll", query="SELECT d FROM Department d")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "departmentId")
public class Department implements Serializable {

	private static final long serialVersionUID = -8406023587477837020L;

	public Department() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPT_SEQ_STORE")
	@Column(name="DEPARTMENT_ID")
	private Integer departmentId;

	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	
	@Column(name="MANAGER_ID")
	private Integer managerId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	//@JsonIdentityReference(alwaysAsId = true)
	//	@JsonIgnore
	@JsonManagedReference
	private List<Employee> employee;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	
	
	}