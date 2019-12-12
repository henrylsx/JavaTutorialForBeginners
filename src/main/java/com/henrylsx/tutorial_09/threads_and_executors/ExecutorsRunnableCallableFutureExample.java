package com.henrylsx.tutorial_09.threads_and_executors;

import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.henrylsx.tutorial.sharedclasses.Employee;

public class ExecutorsRunnableCallableFutureExample {
	public static void main(String[] args) {

		// Creating a pool of 3 threads that will execute the runnable
		ExecutorService service = Executors.newFixedThreadPool(3);
		service.submit(new PrinterRunnable());
		service.submit(new PrinterRunnable());
		service.submit(new PrinterRunnable());
		service.submit(new PrinterRunnable());
		service.submit(new PrinterRunnable());
		


		System.out.println("----------- CALLABLE EXAMPLE");
		ExecutorService service3 = Executors.newFixedThreadPool(1);
		Future<UUID> future = service3.submit(new UUIDGeneratorCallable());
		try {
			System.out.println("Result of callable: " + future.get(10, TimeUnit.SECONDS).toString() );
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ScheduledExecutorService  service2 = Executors.newSingleThreadScheduledExecutor();
		service2.scheduleAtFixedRate(new Runnable() {
			private int counter = 0;
			@Override
			public void run() {
				System.out.println("Inside scheduled runnable... ");
				if(counter == 5) {
					service.shutdown();
					service2.shutdown();
					service3.shutdown();
				}
				counter++;
			}
		}, 1 , 1, TimeUnit.SECONDS);
	}
}


class PrinterRunnable implements Runnable {	//Runnable is for running side effects operation. Hence the run() signature returns void
	@Override
	public void run() {
		System.out.println(Thread.currentThread() + " Printer Runnable");
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class UUIDGeneratorCallable implements Callable<UUID>{
	
	@Override
	public UUID call() throws Exception {
		byte[] data = new ObjectMapper().writeValueAsBytes(new Employee(1,"John"));
		return UUID.nameUUIDFromBytes(data);
	}
	
}