package com.ibm.eis.bean;

public class Employee {
	  private int id;
	  private int salary;
	  private String name;
	  private String designation;
	  private String insurance;
	  
	  public Employee(int id, int salary, String name, String designation) {
		super();
		this.id = id;
		this.salary = salary;
		this.name = name;
		this.designation = designation;
	}
	
	  
	  public int getId() {
		return id;
	}
	  public void setId(int  id) {
			this.id = id;
		}
	
	  public String getInsurance() {
		return insurance;
	}


	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}

	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	  
	  @Override
	public String toString() {
		return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + ", designation=" + designation
				+ ", insurance=" + insurance + "]";
	}
}
