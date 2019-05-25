package com.henry.tutorial_05.about_enum;

public enum DayOfWeek {
	SUNDAY(0,"Sunday"),	//complex enum behave similar to a java class
	MONDAY(1,"Monday"),
	TUESDAY(2,"Tuesday"),
	WEDNESDAY(3,"Wednesday"),
	THURSDAY(4,"Thursday"),
	FRIDAY(5,"Friday"),
	SATURDAY(6,"Saturday");
	
	int dayNumber;
	String dayName;
	
	DayOfWeek(int dayNumber, String dayName) {
		this.dayNumber = dayNumber;
		this.dayName = dayName;
	}
}
