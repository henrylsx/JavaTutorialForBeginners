package com.henrylsx.tutorial_10.about_reflections;

import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionsExample {
	// in reflections, we deal a lot with dynamic class loading instead of static
	// class loading i.e. using class.forName to load classes during runtime
	public static void main(String[] args) {
		try {
			Class<?> clazz = Class.forName("com.henrylsx.tutorial_05.class_interface_inheritance.ColoredCircle");
			Object obj = clazz.newInstance();
			System.out.println("Object:" + obj);
			System.out.println("SuperClass: " + clazz.getSuperclass().getName());
			for (Field f : clazz.getDeclaredFields()) {
				if (f.getName().contains("color")) {
					//only can set public field
					f.set(obj, Color.WHITE);
					System.out.println("Object after setting field:" + f + " becomes: "+ obj);
				}
			}
			for(Method m : clazz.getDeclaredMethods()) {
				if(m.getName().contains("setColor")) {
					Object returnValue = m.invoke(obj, Color.BLACK);
					System.out.println("Object after invoking method:" + m + " becomes: "+ obj + " and returnValue is " + returnValue);
				}
			}

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// different from NoClassDefFoundException
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}
}
