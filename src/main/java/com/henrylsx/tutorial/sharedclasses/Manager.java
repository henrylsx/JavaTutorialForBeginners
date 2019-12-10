package com.henrylsx.tutorial.sharedclasses;

public class Manager extends Employee{
	int managerId; 	//let's say manager also have managerId in addition to employee id
	
	public Manager() {
		super();
	}

	public Manager(int employeeId, String employeeName) {
		super(employeeId, employeeName);
		// TODO Auto-generated constructor stub
	}

}
