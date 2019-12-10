package com.henrylsx.tutorial_03.io_and_serialization;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExampleOfIO {
	public static void main(String[] args) {
		System.out.println(ExampleOfIO.class.getClassLoader().getResource("test.txt").getFile());

		new ExampleOfIO().run();
	}

	public void run() {
		String inputPath = new File(this.getClass().getClassLoader().getResource("test.txt").getFile())
				.getAbsolutePath();
		List<String> fileContent = BasicFileReader.readFile(inputPath);
		fileContent.stream().forEach(System.out::println);

		List<String> fileContent2 = NioFileReader.readFile(inputPath);
		fileContent2.stream().forEach(System.out::println);

		String tmpDir = System.getProperty("java.io.tmpdir");
		System.out.println("Tmpdir is : " + tmpDir);
		BasicFileWriter.writeToFile(tmpDir + "/test2.txt", Arrays.asList("Hello", "Hello", "World"));
		BasicFileWriter.writeToFile(tmpDir + "/test3.txt", Arrays.asList("Hello", "Hello", "World"));

	}

}

class BasicFileReader {
	public static List<String> readFile(String filepath) {
		File f = new File(filepath);
		List<String> output = new ArrayList<String>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				output.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return output;
	}
}

class BasicFileWriter {
	public static void writeToFile(String filepath, List<String> content) {
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
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				pw.close();
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

class NioFileReader {
	public static List<String> readFile(String filepath) {
		Path p = Paths.get(filepath);
		List<String> output = new ArrayList<String>();
		try {
			BufferedReader br = Files.newBufferedReader(p, StandardCharsets.UTF_8);
			String line = "";
			while ((line = br.readLine()) != null) {
				output.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return output;
	}

	public static List<String> readFileUsingLines(String filePath) {
		try {
			return Files.lines(Paths.get(filePath)).collect(Collectors.toList());
		} catch (IOException e) {
			return new ArrayList<String>();
		}
	}

	public static List<String> readFileUsingJava8TryWithResources(String filepath) {
		Path p = Paths.get(filepath);
		List<String> output = new ArrayList<String>();
		try (BufferedReader br = Files.newBufferedReader(p, StandardCharsets.UTF_8)) {
			String line = "";
			while ((line = br.readLine()) != null) {
				output.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return output;
	}
}

class NioFileWriter {
	public static void writeToFile(String filepath, List<String> content) {
		Path p = Paths.get(filepath);
		PrintWriter pw = null;
		try {
			BufferedWriter bw = Files.newBufferedWriter(p, StandardCharsets.UTF_8);
			try {
				pw = new PrintWriter(bw);
				for (String line : content) {
					pw.println(line);
				}
			} finally {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			pw.close();
		}
	}

	public static void writeToFileWithTryWithResources(String filepath, List<String> content) {
		Path p = Paths.get(filepath);
		try (BufferedWriter bw = Files.newBufferedWriter(p, StandardCharsets.UTF_8)) {
			try (PrintWriter pw = new PrintWriter(bw)) {
				for (String line : content) {
					pw.println(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
