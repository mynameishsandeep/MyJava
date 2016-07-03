package com.sample.threads;

import java.util.concurrent.Semaphore;

public class SemaphoreTest extends Thread {

	Semaphore semaphore = new Semaphore(1);

	Thread jdbc = new Thread() {
		public void run() {
			try {
				semaphore.acquire();
				Thread.sleep(1000);
				System.out.println("Thread 1");
				semaphore.release();
				System.out.println("Thread 1 ---> Released");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	Thread fileWrite = new Thread() {
		public void run() {
			try {
				semaphore.acquire();
				Thread.sleep(2000);
				System.out.println("Thread 2");
				semaphore.release();
				System.out.println("Thread 2 ---> Released");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	Thread jms = new Thread() {
		public void run() {
			try {
				semaphore.acquire();
				Thread.sleep(10000);
				System.out.println("Thread 3");
				semaphore.release();
				System.out.println("Thread 3 ---> Released");

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};

	Thread webService = new Thread() {
		public void run() {
			try {
				semaphore.acquire();
				Thread.sleep(1000);
				System.out.println("Thread 4");
				semaphore.release();
				System.out.println("Thread 4 ---> Released");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	};

	public static void main(String args[]) {
		SemaphoreTest es = new SemaphoreTest();
		es.jdbc.start();
		es.fileWrite.start();
		es.jms.start();
		es.webService.start();
	}
}