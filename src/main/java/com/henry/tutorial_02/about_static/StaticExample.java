package com.henry.tutorial_02.about_static;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StaticExample {
	static int employeeCount = 0;	//this is a static variable
	
	
	static {	//this is a static block
		employeeCount = 2;	//try to comment me and rerun
		DepartmentProcessor.departmentCount = 2;
		String helloWorld = "Hello World";	//no use to define variable in static block, can't access from anywhere
	}
	
	public static List<Employee> employeeWithEvenNumberEmployeeid(List<Employee> employees) {	//this is a static method
		//when a method is declared static, you have to call it by the class name and not create the object and call using the object
		return employees.stream().filter(e -> e.getEmployeeId() % 2 == 0 ).collect(Collectors.toList());
		//however, creating method as static often cause you issue that you cannot test the function
		//which is why we move them to a separate Utility class
	}
	
	public void testHelloWorld() {	//non static method only belongs to object
		System.out.println("Hello World");
	}
	
	public static void main(String[] args) {
		System.out.println(employeeCount);
		StaticExample.employeeCount  = 3;
		System.out.println(employeeCount);
		
		//so what happen here ? which one gets written? so best is to avoid having static variable in the first place
		System.out.println("Department count is : "+ DepartmentProcessor.departmentCount);

		List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.addAll(Arrays.asList(new Employee(1,"Henry"), new Employee(2,"Jiawen")));	//calling a static method Arrays.asList
		
		String.valueOf(true);	//calling static String.valueOf by the class
		String s = new String("Henry");
		s.valueOf(true);		//calling static String.valueof by the object gets you a warning
		
		//EmployeeProcessor.testHelloWorld()
		new StaticExample().testHelloWorld();
	}
}
