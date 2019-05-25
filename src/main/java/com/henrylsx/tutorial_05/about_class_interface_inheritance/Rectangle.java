package com.henrylsx.tutorial_05.about_class_interface_inheritance;

public class Rectangle extends Shape{
	private double length=0;
	private double width=0;
	
	@Override
	public double calculateAndPrintCircumference() {
		System.out.println("Calculating circumference for "+ this);
		return length*width;
	}
	
	
	
	//auto-generated getter, setter, constructor and toString	
	
	
	
	public Rectangle() {
		super();
	}
	
	public Rectangle(double length, double width) {
		super();
		this.length = length;
		this.width = width;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}



	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", width=" + width + "]";
	}



}
