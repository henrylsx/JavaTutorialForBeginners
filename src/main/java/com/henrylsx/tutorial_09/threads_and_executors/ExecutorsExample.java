package com.henrylsx.tutorial_09.threads_and_executors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorsExample {
	public static void main(String[] args) {

		// Creating a pool of 3 threads that will execute the runnable
		ExecutorService service = Executors.newFixedThreadPool(3);
//		service.submit(new PrinterRunnable());
//		service.submit(new PrinterRunnable());
//		service.submit(new PrinterRunnable());
//		service.submit(new PrinterRunnable());
//		service.submit(new PrinterRunnable());
//		service.submit(new PrinterRunnable());
		
		
		ScheduledExecutorService  service2 = Executors.newSingleThreadScheduledExecutor();
//		service2.schedule(new PrinterRunnable(), 5 , TimeUnit.SECONDS);
		
		
		System.out.println("CALLABLE EXAMPLE");
		ExecutorService service3 = Executors.newFixedThreadPool(3);
		Future<String> result = service3.submit(new PrinterCallable());
		try {
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//read up more in https://www.baeldung.com/java-concurrency
	}
}

class PrinterRunnable implements Runnable {	//Runnable is for running side effects operation. Hence the run() signature returns void

	@Override
	public void run() {
		System.out.println(Thread.currentThread());
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

class PrinterCallable implements Callable{

	@Override
	public Object call() throws Exception {
		return Thread.currentThread().getName();
	}
	
}