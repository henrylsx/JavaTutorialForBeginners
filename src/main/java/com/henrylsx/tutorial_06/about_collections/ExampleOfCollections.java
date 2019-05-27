package com.henrylsx.tutorial_06.about_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.henrylsx.tutorial_02.about_static.Employee;

public class ExampleOfCollections {
	public static void main(String[] args) {
		//java collections type are array, ArrayList, HashMap, HashSet, Queue, Stack  (There are other variations like Hashtable, TreeSet, TreeMap, PriorityQueue etc)
		String[] arrayOfString = new String[3];	//predefine the size
		arrayOfString[0] = "Hello";	
		arrayOfString[2] = "World";	///access them by the index
		for(String s:arrayOfString) {
			System.out.println(s);	//notice that arrayOfString[1] is null, so you can have array list 3 but 2 object inside
		}
		
		List<String> listOfString = Arrays.asList("Henry","John","Leon");
		//listOfString.add("Karthik");	//original list is immutable, we can't add

		System.out.println(listOfString.getClass());
		List<String> listOfString2 = new ArrayList<String>();	//this is a mutable list
		listOfString2.addAll(listOfString);
		listOfString2.add("Karthik");
		listOfString2.add(2, "Tom");
		printListOfString(listOfString2);
		
		
		//difference between list, map ,and set
		//list is ordered, and can have duplicates
		//set is not ordered and cannot have duplicates (all duplicates are automatically removed)
		//map is a key value pair (the key cannot have duplicates)
		
		System.out.println("------------SET EXAMPLE");
		Set<String> mySet = new HashSet<String>();
		mySet.add("Hello");
		mySet.add("Hello");
		mySet.add("World");
		
		System.out.println(mySet.size());
		mySet.stream().forEach(System.out::println);
		
		System.out.println("------------MAP EXAMPLE");
		Map<Integer,Employee> employeeIdMap = new HashMap<Integer,Employee>();

		Employee e1 = new Employee(1,"Tom");
		Employee e2 = new Employee(2,"Harry");
		Employee e3 = new Employee(3,"John");
		List employeeList = Arrays.asList(e1,e2,e3);

		employeeIdMap.put(e1.getEmployeeId(), e1);
		employeeIdMap.put(e2.getEmployeeId(), e2);
		employeeIdMap.put(e3.getEmployeeId(), e3);
		employeeIdMap.keySet().stream().forEach(System.out::println);
		employeeIdMap.values().stream().forEach(System.out::println);
		
	
		
		System.out.println(employeeIdMap.get(1));	//the complexity for lookup in hashmap is O(1) for best case and O(n) for worst case
		//a map is basically a bucket of arraylist
		//the hashcode will determine where which bucket the item will be stored
		//and then if two objects have the same hashcode(), they will reside within the same bucket of arraylist
		//the map implementation will compare using the equals() method to find out which item is the matching item
		//if two object have the same hashcode, they may not be equal
		//if two object are equal, they always have to have same hashcode
		
		
		//for stack the most common use is to identify balanceness of brackets, xml tags, etc
		
	}
	
	public static void printListOfString(List<String> inputString) {	//this is actually not very good because we are restricting to list of string only
		inputString.stream().forEach(System.out::println);
	}
	
	public static void printListOfAnything(List<?> inputList) {
		
	}
}
