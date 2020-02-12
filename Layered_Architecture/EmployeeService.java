package com.ibm.eis.service;

import com.ibm.eis.bean.Employee;

public class EmployeeService implements EmployeeServiceInterface {

	@Override
	public Employee insuranceScheme(Employee employee) {
		if(employee.getSalary() > 5000 && employee.getSalary() < 20000 && employee.getDesignation().equals("System Associate")) {
			employee.setInsurance("Scheme C");
		}
		
		else if(employee.getSalary() >= 20000 && employee.getSalary() < 40000 && employee.getDesignation().equals("Programmer")) {
			employee.setInsurance("Scheme B");
		}
		
		else if(employee.getSalary() >= 40000 && employee.getDesignation().equals("Manager")) {
			employee.setInsurance("Scheme C");
		}
		
		else if(employee.getSalary() < 5000 && employee.getDesignation().equals("Clerk")) {
			employee.setInsurance("No Scheme");
		}
	
		return employee;
	}

	
}
