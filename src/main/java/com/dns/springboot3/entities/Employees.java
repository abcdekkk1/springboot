package com.dns.springboot3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employees {

	@Id
	@GeneratedValue
	@Column(name="employeeNumber", length = 11, nullable = false)
	private int employeeNumber;
	@Column(name="lastName", length=50, nullable = false)
	private String lastName;
	@Column(name="firstName",length = 50, nullable= false)
	private String firstName;
	@Column(name="extension",length=10, nullable = false)
	private String extension;
	@Column(name="email", length=100, nullable = false)
	private String email;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="reportsTo")
	private Employees employees;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="officeCode")
	private Offices offices;
	@Column(name="jobTitle", length = 50, nullable = false)
	private String jobTile;
	public int getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employees getEmployees() {
		return employees;
	}
	public void setEmployees(Employees employees) {
		this.employees = employees;
	}
	public Offices getOffices() {
		return offices;
	}
	public void setOffices(Offices offices) {
		this.offices = offices;
	}
	public String getJobTile() {
		return jobTile;
	}
	public void setJobTile(String jobTile) {
		this.jobTile = jobTile;
	}
	
	
}
