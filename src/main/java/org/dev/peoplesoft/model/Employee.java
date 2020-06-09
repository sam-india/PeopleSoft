package org.dev.peoplesoft.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="employees")
@SequenceGenerator(
		sequenceName = "EMP_SEQ_STORE", name = "EMP_SEQ", initialValue = 100
		)
@NamedQueries({
	@NamedQuery(name="Employee.findAllEmployeesByLastNameLength", query="SELECT e FROM Employee e WHERE CHAR_LENGTH(e.lastName) =:length"),
	@NamedQuery(name="Employee.findEmployeesByLastName", query="SELECT e FROM Employee e WHERE e.lastName =:lastName")

})
public class Employee implements Serializable {

	private static final long serialVersionUID = 1549588706958301542L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "EMP_SEQ_STORE")
	@Column(name="EMPLOYEE_ID")
	private Integer empId;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name="EMAIL")
	private String email;

	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="DEPARTMENT_ID", updatable=false, insertable=false)
	private Integer departmentId;

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Employee() {
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="HIRE_DATE")
	private Date hireDate;

	@Column(name="JOB_ID")
	private String jobId;

	@Column(name = "SALARY")
	private BigDecimal salary;

	@Column(name="COMMISSION_PCT")
	private BigDecimal commissionPct;

	@Column(name="MANAGER_ID")
	private Integer managerId;
	
	//@JsonIgnore
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "DEPARTMENT_ID")
	private Department department;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getCommissionPct() {
		return commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}