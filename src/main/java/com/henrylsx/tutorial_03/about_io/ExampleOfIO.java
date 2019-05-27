package com.henrylsx.tutorial_03.about_io;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ExampleOfIO {
	public static void main(String[] args) throws IOException {
		List<String> fileContent = BasicFileReader.readFile("C:/Users/henry/OneDrive/Desktop/test.txt");
		fileContent.stream().forEach(System.out::println);
		
		List<String> fileContent2 = NioFileReader.readFile("C:/Users/henry/OneDrive/Desktop/test.txt");
		fileContent2.stream().forEach(System.out::println);
		
		BasicFileWriter.writeToFile("C:/Users/henry/OneDrive/Desktop/test2.txt", Arrays.asList("Hello","Hello","World"));
		BasicFileWriter.writeToFile("C:/Users/henry/OneDrive/Desktop/test3.txt", Arrays.asList("Hello","Hello","World"));
	
	}

	
}
