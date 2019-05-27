package com.henrylsx.tutorial_03.about_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.common.io.Files;

public class NioFileReader {
	public static List<String> readFile(String filepath) {
		Path p = Paths.get(filepath);
		File f = p.toFile();
		List<String> output = new ArrayList<String>();
		try {
			BufferedReader br = Files.newReader(f, StandardCharsets.UTF_8);
			String line = "";
			while( (line = br.readLine()) !=null) {
				output.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return output;
	}
	
	public static List<String> readFileUsingJava8TryWithResources(String filepath) {
		Path p = Paths.get(filepath);
		File f = p.toFile();
		List<String> output = new ArrayList<String>();
		try (BufferedReader br = Files.newReader(f, StandardCharsets.UTF_8)){
			String line = "";
			while( (line = br.readLine()) !=null) {
				output.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
}
