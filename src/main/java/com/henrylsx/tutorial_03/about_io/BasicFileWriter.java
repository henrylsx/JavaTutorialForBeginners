package com.henrylsx.tutorial_03.about_io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class BasicFileWriter {
	public static void writeToFile(String filepath, List<String> content) throws IOException {
		File f = new File(filepath);
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter pw = null;
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			for (String line : content) {
				pw.println(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pw.close();
			bw.close();
			fw.close();
		}
	}
}
