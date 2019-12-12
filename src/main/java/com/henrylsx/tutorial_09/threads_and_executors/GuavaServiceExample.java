package com.henrylsx.tutorial_09.threads_and_executors;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.ServiceManager;

public class GuavaServiceExample {

	public static void main(String[] args) throws InterruptedException {
		Service1 service1 = new Service1();
		Service2 service2 = new Service2();		
		ServiceManager manager = new ServiceManager(Arrays.asList(service1, service2));
		service1.startAsync();
		service2.startAsync();
		
		
		for(int i=0;i<20;i++) {
			System.out.println("Polling run " + i);
			System.out.println(manager.servicesByState());
			Thread.sleep(1000);
		}
	}
	


}

class Service1 extends AbstractService{
	@Override
	protected void doStart() {	
		new Thread(new Runnable() {
			@Override
			public void run() {
				readTrumpIpsum();				
			}
			
		}).start();;		
		notifyStarted();	
	}

	@Override
	protected void doStop() {
		notifyStopped();
		
	}
	
	public void readTrumpIpsum() {
		try {
			Path inputPath = Paths.get(new File(Service2.class.getClassLoader().getResource("trumpIpsum.txt").getFile()).getAbsolutePath());			
			Files.readAllLines(inputPath, StandardCharsets.UTF_8).stream().forEach( line -> {
					System.out.println("TrumpIpsum Thread:" +line);
					try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
				});
			stopAsync();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}



class Service2 extends AbstractService{
	@Override
	protected void doStart() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				readChuckIpsum();				
			}
			
		}).start();
		notifyStarted();
	}
	
	public void readChuckIpsum() {
		try {
			Path inputPath = Paths.get(new File(Service1.class.getClassLoader().getResource("chuckIpsum.txt").getFile()).getAbsolutePath());			
			Files.readAllLines(inputPath,  StandardCharsets.UTF_8).stream().forEach( line -> {
				System.out.println("ChuckIpsum Thread: " +line);
				try {Thread.sleep(500);} catch (InterruptedException e) {e.printStackTrace();}
			});
			stopAsync();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doStop() {
		notifyStopped();
		
	}
}

