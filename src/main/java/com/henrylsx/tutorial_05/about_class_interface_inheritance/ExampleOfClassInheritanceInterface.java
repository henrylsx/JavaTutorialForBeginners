package com.henrylsx.tutorial_05.about_class_interface_inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.henrylsx.tutorial_04.about_enum.Color;

public class ExampleOfClassInheritanceInterface {
	public static void main(String[] args) {
		//a class can be an abstract class (cannot be instantiated)
		//a class can extend only another class
		//a class can implement many interfaces
		
		List<Shape> shapeList = new ArrayList<Shape>();
		//look at how Rectangle extends Shape, Circle extends Shape, and Square extends Rectangle
		shapeList.addAll(Arrays.asList(new Rectangle(2,3), new Circle(10), new Square(2)));
		for (Shape s: shapeList) {
			System.out.println(s.calculateAndPrintCircumference());
		}

		//ColoredCircle extends Circle, but also implements Cloneable and MyCustomSerializationToFile
		ColoredCircle c = new ColoredCircle(5, Color.WHITE);
		c.serialize();
		System.out.println(c.deserialize(c.getClass()));
	}
}
