package com.henrylsx.tutorial_05.class_interface_inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.Color;

public class ExampleOfClassInheritanceInterface {

	/*
	 * SOLID/DRY/KISS PRINCIPLES
	 * 
	 * Single Responsibility Principle: Every interface, class, or
	 * method we define should have a clearly defined goal. In essence, it should
	 * ideally do one thing and do that well. This effectively leads to smaller
	 * methods and classes which are also testable.
	 * 
	 * Open-Closed Principle: The code
	 * that we write should ideally be open for extension but closed for
	 * modification. What this effectively means is that a class should be written
	 * in a manner that there should not be any need to modify it. However, it
	 * should allow for changes through inheritance or composition.
	 * 
	 * Liskov Substitution Principle: What this principle states is that every subclass or
	 * derived class should be substitutable for their parent or base class. This
	 * helps in reducing coupling in the codebase and hence improve reusability
	 * across. 
	 * 
	 * Interface Segregation Principle: Implementing an interface is a way
	 * to provide a specific behavior to our class. However, a class must not need
	 * to implement methods that it does not require. What this requires us to do is
	 * to define smaller, more focused interfaces. 
	 * 
	 * Dependency Inversion Principle:
	 * According to this principle, classes should only depend on abstractions and
	 * not on their concrete implementations. This effectively means that a class
	 * should not be responsible for creating instances for their dependencies.
	 * Rather, such dependencies should be injected into the class.
	 * 
	 * DRY: Don't Repeat Yourself by copy pasting code everywhere
	 * KISS: Keep It Simple and Stupid
	 */

	public static void main(String[] args) {
		// a class can be an abstract class (cannot be instantiated)
		// a class can extend only another class
		// a class can implement many interfaces

		List<Shape> shapeList = new ArrayList<Shape>();
		// look at how Rectangle extends Shape, Circle extends Shape, and Square extends
		// Rectangle
		shapeList.addAll(Arrays.asList(new Rectangle(2, 3), new Circle(10), new Square(2)));
		for (Shape s : shapeList) {
			System.out.println(s.calculateAndPrintCircumference());

		}

		// ColoredCircle extends Circle, but also implements Cloneable and
		// MyCustomSerializationToFile
		ColoredCircle c = new ColoredCircle(5, Color.WHITE);
		c.serialize();
		System.out.println(c.deserialize(c.getClass()));
	}
}
