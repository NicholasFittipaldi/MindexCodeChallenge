package com.mindex.challenge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingStructureService;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {
	
	@Autowired
    private EmployeeRepository employeeRepository;

	@Override
	public ReportingStructure getReportingStructure(String employeeId) {
		Employee employee = employeeRepository.findByEmployeeId(employeeId);
		ReportingStructure reportingStructure = new ReportingStructure(employee, getReports(employee.getEmployeeId()));
		
		return reportingStructure;
	}
	
	@Override
	public int getReports(String employeeId) {
		Employee employee = employeeRepository.findByEmployeeId(employeeId);
		int reports = 0;
		
		if (employee.getDirectReports() != null) {
			reports = employee.getDirectReports().size();
			
			for (Employee e : employee.getDirectReports()) {
				reports = reports + getReports(e.getEmployeeId());
			}
		}
		else 
			return reports;
		
		return reports;
	}
}
