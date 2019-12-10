package com.henrylsx.tutorial_13.javachanges;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Java8Changes {
	public static void main(String[] args) {
		streamAndLambda();
		new MyCustomClassWithDefaultMethod<String>().myLambda(a -> a.toString());
		//default methods allows lambda, e.g. within Iterable and Collections interface
		useOfOptional();
		useOfDateTimeApi();
		//Change to Java Memory Management
		//Previously Heap is YoungGen+OldGen+PermGen now PermGen replaced with Metaspace
		
	}

	public static void streamAndLambda() {
		List<String> l = Arrays.asList("str1", "str2");
		l.stream().forEach(System.out::println);
		l.stream().map(str -> str.length());
	}
	
	public static void useOfOptional() {
		List<Optional<String>> listOfOptionals = new ArrayList<Optional<String>>();
		listOfOptionals.add(Optional.of("first"));
		listOfOptionals.add(Optional.ofNullable("second"));
		listOfOptionals.add(Optional.ofNullable(null));
		listOfOptionals.add(Optional.empty());
		listOfOptionals.stream().forEach(a -> {
			System.out.println("IsPresent:" + a.isPresent());
		});
	}
	
	public static void useOfDateTimeApi() {
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());

	}
}

@FunctionalInterface // permit only exactly one abstract method, but many default methods as you like
interface MyFirstFunctionalInterface {
	public void firstFunction();
//	public void secondFunction();	

	default void move() {
		System.out.println("This is just a default move function that does not do anything");
	}

	default void copy() {
		System.out.println("This is just a default copy function that does not do anything");
	}
}

interface MyCustomInterface<T> {
	default void myLambda(Consumer<? super T> action) {
		System.out.println(action);
		System.err.println(action);
	}
}

class MyCustomClassWithDefaultMethod<T> implements MyCustomInterface<T> {
	
}