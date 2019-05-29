package com.henrylsx.tutorial_09.about_threads;

public class ThreadExample {
	public static void main(String[] args) {
		Counter counter = new Counter();
		
		
		System.out.println(Thread.currentThread());
		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread());
			}
		};
		t.start();
		
		
		
	}
	
	
	//volatile keyword	--> to ensure the thread that read a volatile variable always get the main copy of the variable instead of the thread's local copy
	//synchronized keyword --> to ensure thread blocking so that a method/variable can only be accessed by one thread at a time
	
}

class Counter{	//every single object will have an object lock
	int employeeCount = 0;
	
	public synchronized void incrementEmployeeCount() {	//synchronized keyword will tell the thread to acquire this object's lock first
		employeeCount++;
		
	}
	
	
	volatile int aVolatileEmployeeCount = 0;

}
