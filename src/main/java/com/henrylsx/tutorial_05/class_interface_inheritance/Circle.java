package com.henrylsx.tutorial_05.class_interface_inheritance;

public class Circle extends Shape {
	private double radius;

	@Override
	public double calculateAndPrintCircumference() {
		System.out.println("Calculating circumference for " + this);
		return 2 * Math.PI * radius;
	}

	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	/**
	 * @return the radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Circle [radius=" + radius + "]";
	}

}
