package com.sample.threads;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	CountDownLatch cdl = new CountDownLatch(3);

	public static void main(String args[]) {

		CountDownLatchExample ec = new CountDownLatchExample();
		ec.a.start();
		ec.b.start();
		ec.c.start();
		ec.d.start();

	}

	Thread a = new Thread() {
		public void run() {
			System.out.println("Thread 1");
			try {
				cdl.countDown();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	Thread b = new Thread() {
		public void run() {
			System.out.println("Thread 2");
			try {

				Thread.sleep(3000);
				cdl.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	Thread c = new Thread() {
		public void run() {
			System.out.println("Thread 3");
			try {
				Thread.sleep(2000);
				cdl.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	Thread d = new Thread() {
		public void run() {
			try {
				cdl.await();
				System.out.println("4 Completed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	};

}
