package com.sample.threads;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest implements Runnable {

	private CyclicBarrier barrier = new CyclicBarrier(3);

	@Override
	public void run() {

		try {
			Thread.sleep(3000);
			System.out.println(Thread.currentThread().getName()
					+ " recruited developer");
			System.out.println(Thread.currentThread().getName()
					+ " waiting for others to complete....");
			barrier.await();
			System.out.println("All finished recruiting, "
					+ Thread.currentThread().getName()
					+ " gives offer letter to candidate");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {

		CyclicBarrierTest barrier1 = new CyclicBarrierTest();

		Thread t1 = new Thread(barrier1);
		t1.start();
		Thread t2 = new Thread(barrier1);
		t2.start();
		Thread t3 = new Thread(barrier1);
		t3.start();
		Thread t4 = new Thread(barrier1);
		t4.start();
		Thread t5 = new Thread(barrier1);
		t5.start();
		Thread t6 = new Thread(barrier1);
		t6.start();
	}
}