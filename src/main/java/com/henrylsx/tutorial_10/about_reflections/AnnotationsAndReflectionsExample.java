package com.henrylsx.tutorial_10.about_reflections;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationsAndReflectionsExample {
	public static void main(String[] args) {
		
	}
	
	public void run() {
		
	}
	
	@Loggable
	public void loggableMethod() {
		
	}
	
}

@Retention(RetentionPolicy.RUNTIME) //retain both in source code and runtime
@Target(ElementType.METHOD)	//assignable to method
@interface Loggable{
	
}