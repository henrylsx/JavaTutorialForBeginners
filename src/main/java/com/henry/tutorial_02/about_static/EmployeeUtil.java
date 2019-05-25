package com.henry.tutorial_02.about_static;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeUtil {
	public static List<Employee> employeeWithEvenNumberEmployeeid(List<Employee> employees) {
		//when a method is declared static, you have to call it by the class name and not create the object and call using the object
		return employees.stream().filter(e -> e.getEmployeeId() % 2 == 0 ).collect(Collectors.toList());
	}
}
