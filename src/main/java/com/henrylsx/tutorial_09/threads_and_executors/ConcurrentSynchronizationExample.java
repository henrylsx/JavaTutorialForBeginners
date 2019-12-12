package com.henrylsx.tutorial_09.threads_and_executors;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class ConcurrentSynchronizationExample {
	public static void main(String[] args) throws InterruptedException {
		new ConcurrentSynchronizationExample().startCountDownLatchDemo();
		new ConcurrentSynchronizationExample().startCyclicBarrierDemo();
		//use phaser for more complex case
	}

	public void startCountDownLatchDemo() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(2);
		System.out.println("LatchCount:"+latch.getCount());
		for (int i = 0; i < 5; i++) {
			Thread t = new Thread(new RunnableWithLatch(latch));//create thread which await for latch
			t.start();
		}
		
		Thread.sleep(1000); //do something for 1 second
		latch.countDown();
		Thread.sleep(1000); //do something for 1 second
		latch.countDown();//cause all the thread to start now, once latch goes down to 0, it is open to any threads to start
	}
	
	public void startCyclicBarrierDemo() throws InterruptedException {
		CyclicBarrier barrier = new CyclicBarrier(3);
		System.out.println("barrierCount:"+barrier.getParties());
		for (int i = 0; i < 12; i++) {
			Thread t = new Thread(new RunnableWithCyclicBarrier(barrier));
			//create thread which wait at the barrier until there are three threads waiting at the barrier before executing
			t.start();
			Thread.sleep(1000);//wait 1 second each before creating new thread
		}
		
	}
}

class RunnableWithLatch implements Runnable {
	CountDownLatch latch;
	RunnableWithLatch(CountDownLatch latch) {
		this.latch = latch;
	}
	@Override
	public void run() {
		try {
			latch.await();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " proceeds");
	}

}

class RunnableWithCyclicBarrier implements Runnable{
	CyclicBarrier barrier;
	
	public RunnableWithCyclicBarrier(CyclicBarrier barrier) {
		this.barrier = barrier;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Number waiting:" + barrier.getNumberWaiting());
			barrier.await();
		} catch (InterruptedException | BrokenBarrierException e1) {
			e1.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " proceeds");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}