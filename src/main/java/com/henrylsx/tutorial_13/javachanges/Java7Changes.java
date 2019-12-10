package com.henrylsx.tutorial_13.javachanges;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;

public class Java7Changes {
	public static void main(String[] args) throws InterruptedException {
		tryWithResources();
		switchString();
		int numberWithUnderscore = 10_000_000;
		System.out.println(numberWithUnderscore);
		runWatchService();
		//Also, Garbage Collection, Serial/Parallel/CMS now added with G1
		//G1 (Garbage First) is similar to CMS, it doesn't stop application for GC, 
		//but it scan the heap and identify the place with most garbage first and start cleaning
		//from there thereby getting more heap space before cleaning other region
	}

	public static void tryWithResources() {
		String s = new File(Java7Changes.class.getClassLoader().getResource("test.txt").getFile()).getAbsolutePath();
		try (FileReader fr = new FileReader(s); BufferedReader br = new BufferedReader(fr)) {
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void switchString() {
		List<String> strings = Arrays.asList("Henry", "John");
		for (String s : strings) {
			switch (s) {
			case ("Henry"):
				System.out.println("HENRY");
				break;
			}
		}
	}

	public static void runWatchService() {
		Executors.newSingleThreadExecutor().submit(new Runnable() {
			@Override
			public void run() {
				try {
					String watchFolder = "C:/Users/henry/workspace/JavaTutorialForBeginners/src/main/resources/watch";
					final WatchService watchService = FileSystems.getDefault().newWatchService();
					Path path = Paths.get(watchFolder);
					path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE,
							StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);
					WatchKey key;
					while ((key = watchService.take()) != null) {
						for (WatchEvent<?> event : key.pollEvents()) {
							System.out.println(
									"Event kind:" + event.kind() + ". File affected: " + event.context() + ".");
						}
						key.reset();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

}
