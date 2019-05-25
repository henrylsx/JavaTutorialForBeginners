package com.henrylsx.tutorial_05.about_class_interface_inheritance;

import com.henrylsx.tutorial_04.about_enum.Color;

public class ColoredCircle extends Circle implements MyCustomSerializationToFile, Cloneable{
	Color color =null;	//use color from the previous tutorial, could use from java.awt.Color also

	@Override	//implementation of MyCustomSerializationToFile interface
	public void serialize(String outputPath) {
		System.out.println("Serialize");
	}
	
	@Override	//implementation of Cloneable interface
	public ColoredCircle clone() {
		ColoredCircle aClone =  new ColoredCircle();
		aClone.setRadius(this.getRadius());
		return aClone;
	}
	
	
	
	@Override
	public String toString() {
		return "ColoredCircle [radius=" + this.getRadius()  + ", color=" + color + "]";
	}

	//create a constructor that call the parent circle to set the radius, then we set the color
	public ColoredCircle(double radius, Color color) {
		super(radius);
		this.color = color;
	}
	
	
	
	
	//Auto-generated getter setters
	
	public ColoredCircle() {
		super();
	}
	
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */


}
