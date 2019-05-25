package com.henrylsx.tutorial_05.about_class_interface_inheritance;

public class Square extends Rectangle{
	
//	this method is not required because the super class method implementation will be enough
//	@Override	
//	public double calculateAndPrintCircumference() {
//		System.out.println("Calculating circumference for "+ this);
//		return length*width;
//	}
	
	public Square(double length) {	//Square is just Rectangle with length and width the same
		setLength(length);
		setWidth(length);
	}
	
	//auto-generated getter, setter, constructor and toString	

	public Square() {
		super();
	}
	


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Square [length=" + this.getLength() +"]";
	}

}
