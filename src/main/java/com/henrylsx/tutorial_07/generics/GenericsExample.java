package com.henrylsx.tutorial_07.generics;

import java.util.ArrayList;
import java.util.List;

import com.henrylsx.tutorial.sharedclasses.Employee;
import com.henrylsx.tutorial.sharedclasses.Manager;

public class GenericsExample {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<Employee>();
		List<Manager> managers = new ArrayList<Manager>();

		Employee e1 = new Employee(1, "John");
		Employee e2 = new Employee(2, "Tom");
		Manager m1 = new Manager(3, "Harry");
		employees.add(e1);
		employees.add(e2);
		managers.add(m1);

		checkManager(e1); // works
		checkManager(m1); // works

		checkManagerList(employees);
//		checkManagerList(managers);	//doesn't work because List<Manager> is not a subclass of List<Employee>
		
		checkManagerListImproved(employees);
		checkManagerListImproved(managers);	//now it works
		
		checkSuperOfEmployees(employees);
//		checkSuperOfEmployees(managers);
		checkSuperOfEmployees(new ArrayList<Object>());

	}

	public static void checkManager(Employee employee) { // anything that is subclass of employee can be passed in

	}

	public static void checkManagerList(List<Employee> employees) { // anything that is subclass of List<Employee>
		// note that List<Manager> is not a subclass of List<Employee>
		// ArrayList<Employee> is a subclass of List<Employee>
		// FinalArrayList<Employee> is a subclass of ArrayList<Employee> and is okay to
		// be used as well
	}
	
	//it complains about method erasure
//	public static void checkManagerList(List<Manager> managers) { 
//		
//	}
	
	public static void checkManagerListImproved(List<? extends Employee> employees) {
		
	}
	
	public static void checkSuperOfEmployees(List<? super Employee> employees) {
	
	}
}
