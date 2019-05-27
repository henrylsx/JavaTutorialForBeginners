package com.henrylsx.tutorial_03.about_io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.google.common.io.Files;

public class NioFileWriter {
	public static void writeToFile(String filepath, List<String> content) {
		Path p = Paths.get(filepath);
		File f = p.toFile();
		PrintWriter pw = null;
		try {
			BufferedWriter bw = Files.newWriter(f, StandardCharsets.UTF_8);
			try {
				pw = new PrintWriter(bw);
				for (String line : content) {
					pw.println(line);
				}
			} finally {
				try {
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pw.close();
		}
	}
	
	public static void writeToFileWithTryWithResources(String filepath, List<String> content) {
		Path p = Paths.get(filepath);
		File f = p.toFile();
		try (BufferedWriter bw = Files.newWriter(f, StandardCharsets.UTF_8)){	
			try (PrintWriter pw = new PrintWriter(bw)){
				for (String line : content) {
					pw.println(line);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//better way is to capture all exceptions using java monad library. Example look at better-java-monads in github
	}
}
