package com.henrylsx.tutorial_06.about_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ExampleOfCollections {
	public static void main(String[] args) {
		//java collections type are array, vector, list, map, set
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
		
		Vector<String> vectorOfString = new Vector<String>();
		
	}
	
	public static void printListOfString(List<String> inputString) {	//this is actually not very good because we are restricting to list of string only
		inputString.stream().forEach(System.out::println);
	}
	
	public static void printListOfAnything(List<?> inputList) {
		
	}
}
