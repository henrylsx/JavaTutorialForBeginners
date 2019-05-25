package com.henrylsx.tutorial_05.about_class_interface_inheritance;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface MyCustomSerializationToFile {
	// Interface is just a contract containing constants and abstract methods
	final String DEFAULT_WRITE_PATH = System.getProperty("java.io.tmpdir");

	public abstract void serialize(String outputPath);

	// default method (new feature from Java 8)
	default void serialize() {
		File f = new File(DEFAULT_WRITE_PATH + "/" + this.getClass().getSimpleName() + ".json");
		System.out.println(f.getAbsolutePath());
		ObjectMapper mapper = new ObjectMapper();
		try {
			System.out.println("Object serialized as json is: "+ mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	default Object deserialize(Class<?> clazz) {
		File f = new File(DEFAULT_WRITE_PATH + "/" + this.getClass().getSimpleName() + ".json");
		ObjectMapper mapper = new ObjectMapper();
		Object obj = null;
		try {
			 obj = mapper.readValue(f, clazz);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
//			
}
