package com.henrylsx.tutorial_04.enums;

public class DayOfWeekProcessor {
	public static void main(String[] args) {
		System.out.println(DayOfWeek.MONDAY);
		System.out.println(DayOfWeek.MONDAY.dayName);
		System.out.println(DayOfWeek.MONDAY.dayNumber);
	}
	
}


enum DayOfWeek {
	//complex enum behave similar to a java class
	
	//declare the items, they are like creating constants by calling the constructors
	SUNDAY(0,"Sunday"),	
	MONDAY(1,"Monday"),
	TUESDAY(2,"Tuesday"),
	WEDNESDAY(3,"Wednesday"),
	THURSDAY(4,"Thursday"),
	FRIDAY(5,"Friday"),
	SATURDAY(6,"Saturday");
	
	//declare variables
	int dayNumber;
	String dayName;
	
	//declare constructors
	DayOfWeek(int dayNumber, String dayName) {
		this.dayNumber = dayNumber;
		this.dayName = dayName;
	}
}
