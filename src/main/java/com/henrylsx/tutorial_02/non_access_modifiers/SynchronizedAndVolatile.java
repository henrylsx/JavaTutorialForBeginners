package com.henrylsx.tutorial_02.non_access_modifiers;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedAndVolatile {
	// for volatile variable, threads are not allowed to use local cache, but has to
	// always get from memory. Volatile alone is not enough if each thread has to read the shared var
	//before writing because multiple threads can read the same value and then write the output at the same time
	static volatile int volatileVariable = 0;
	static int nonVolatileVariable = 0;
	
	
	//synchronized block will make the thread to acquire lock to the variable
	//static makes the lock at class level instead of object level
	public static synchronized void incrementCounterSyncVolatile() {
		volatileVariable = volatileVariable + 1;
		System.out.println(Thread.currentThread() + " prints out volatileVariable is now : " + volatileVariable);
	}
	
	public static void incrementCounterNonSyncNonVolatile() {
		nonVolatileVariable = nonVolatileVariable + 1;
		System.out.println(Thread.currentThread() + " prints out nonVolatileVariable is now : " + nonVolatileVariable);
	}

	public static void main(String[] args) {
		Runnable incrRunnable = new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
//					incrementCounterSyncVolatile();
					incrementCounterNonSyncNonVolatile();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		List<Thread> threads = new ArrayList<Thread>();
		for(int i=0;i<20;i++) { threads.add(new Thread(incrRunnable));}
		threads.forEach(t -> t.start());

	}
}
