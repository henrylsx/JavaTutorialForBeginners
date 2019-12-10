package com.henrylsx.tutorial_01.language;

import java.time.LocalDate;
import java.util.Date;

import com.henrylsx.tutorial.sharedclasses.DepartmentProcessor;
import com.henrylsx.tutorial_01.language.scope.ScopeExample;

public class LanguageBasics {
	
	@SuppressWarnings("unused")	//just informing the IDE to supress warnings of unused variables
	public static void main(String[]args ) {
		/* PRIMITIVE VARIABLE TYPES, declare name with camel case starting with small letter, e.g. totalEmployeeCount
		 * ---------------------------
		 * */
		byte byt = 127;	//8 bit number, -128 to 127 or -2^7 to 2^7
		short sht = 32767;	//16 bit number,	-32768 to 32767
		int i=0;	//32 bit number, -2^31 to 2^31
		long l = 2;	//64 bit number,	-2^63 to 2^63
		int[] iArr = {1,2,3};	//any variable type with square bracket is array, can't mix the type.
		System.out.println("iArr first" +iArr[0] + ",iArr last:" + iArr[iArr.length-1]); 	// index start from 0
		boolean bool = true;	//true false
		double d = 1.0d; //decimal numbers using 32 bit
		float f = 1.0f;	//decimal numbers using 64 bit
		char c = 'c'; //character, use single quote
		String str = "Str"; //string, just an array of characters
		System.out.println("str 2nd char:"+str.charAt(2));	//character at index 2

		Date date = new Date(); //java date, return current date
		System.out.println(date.getTime());	//convert date to milliseconds since Unix epoch time (1 January 1970 00:00:00)
		LocalDate localDate = LocalDate.now();	//new java 8 Date API, best to use this now, read more https://www.baeldung.com/java-8-date-time-intro
		
		/* VARIABLE SCOPE EXAMPLE
		 * ---------------------------
		 * */
		ScopeExample sc = new ScopeExample();
		int tmp = sc.pub;	//can access public variable
//		tmp = sc.defaultScope;	// no scope means package scope, can't access from different package
		new ScopeSubclassExample().printProtectedVarValue();	//protected can be accessed by subclass
//		tmp = sc.priv;	//cannot access private variable
		DepartmentProcessor dp = new DepartmentProcessor();
		
		/* CONSTANTS
		 * ---------------------------
		 * */
		final int MAX_HTTP_TIMEOUT = 60;	//declare constants with all capital letter
		
		/* BRANCHING 
		 * ---------------------------
		 * */
		if(i==0) {
			System.out.println("i is 0");
		}else if(i==1) {
			System.out.println("i is 1");
		}else {
			System.out.println("i is other stuff");
		}
		
		/* LOOPING 
		 * ---------------------------
		 * */
		//using for
		for(int a=0;a<3;a++) {
			System.out.println("For loop");
			System.out.println(a);
		}
		//there is while also, but best to avoid them
		int whileCounter = 0;
		while(whileCounter!=3) {
			System.out.println("While loop");
			System.out.println(whileCounter++);
		}
		
	}
	

}

class ScopeSubclassExample extends ScopeExample {
	public void printProtectedVarValue() {
		System.out.println("Protected var is :" + super.prot);
	}
}