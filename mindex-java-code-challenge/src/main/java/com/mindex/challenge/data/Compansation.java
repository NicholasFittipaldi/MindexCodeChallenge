package com.mindex.challenge.data;

import java.time.LocalDate;
import java.util.Date;

public class Compansation {
	private String employee;
	private float salary;
	private LocalDate effectiveDate;
	
	public Compansation() {
	}
	
	public String getEmployee() {
		return employee;
	}
	
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	
	public float getSalary() {
		return salary;
	}
	
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}
	
	public void setEffectiveDate(LocalDate localDate) {
		this.effectiveDate = localDate;
	}
}
