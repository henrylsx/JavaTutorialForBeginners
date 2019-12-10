package com.henrylsx.tutorial_08.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.henrylsx.tutorial.sharedclasses.Employee;

public class StreamExample {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee(1, "John"), new Employee(2, "Henry"),
				new Employee(3, "Tom"));
		// list, set, map or any other collection in java are monads - functional
		// pattern which can accept map function and flatMap function

//		employees.parallelStream().forEach(System.out::println); //parallel processing, you'll see them printed not in the sequential order

		employees.stream().filter(e -> { // multiline lambda expression
			System.out.println(e); // println doesn't get printed unless you call collect because stream is lazy
			return e.getEmployeeId() == 1;
		});
//		.collect(Collectors.toList());	

		Stream<Employee> es = employees.stream().filter(e -> e.getEmployeeId() == 2)
				.filter(e -> e.getEmployeeName().contains("Henry")); // doesn't process immediately because stream is
																		// lazy
		// the thing inside the filter is actually a lambda expression
		// lambda expression is basically a nameless function

//		System.out.println(es.count());
		// forEach(), collect(), count() will actually execute the stream and then close
		// it

		// collect to list
		List<Employee> empList = es.collect(Collectors.toList());
		System.out.println("empList:" + empList);
		// collect to array
		Employee[] empArr = empList.stream().toArray(Employee[]::new);
		// collect to set
		Set<Employee> empSet = empList.stream().collect(Collectors.toSet());
		// collect to map
		Map<Integer, Employee> empMap = empList.stream()
				.collect(Collectors.toMap(Employee::getEmployeeId, Function.identity()));
		empMap.entrySet().stream().forEach(entry -> 
		System.out.println("Hashmap entry key:" + entry.getKey()));

		System.out.println(
				"Employee Henry exist: " + empList.stream().anyMatch(e -> e.getEmployeeName().equals("Henry")));

		// PARALLEL STREAM EXAMPLE
		Set<Integer> employeeIds = employees.parallelStream().map(e -> e.getEmployeeId()).collect(Collectors.toSet());
		System.out.println(employeeIds.size());

		List<Employee> employees2 = Arrays.asList(new Employee(4, "Timothy"), new Employee(5, "George"),
				new Employee(6, "Sarah"));

		List<List<Employee>> listOfListOfEmployees = Arrays.asList(employees, employees2);

		// FLATMAP EXAMPLE
		List<Integer> id2 = listOfListOfEmployees.stream().flatMap(e -> e.stream().map(p -> p.getEmployeeId()))
				.collect(Collectors.toList());
		System.out.println(id2.size());
		System.out.println(id2.getClass());
		id2.forEach(System.out::println);

	}

}
