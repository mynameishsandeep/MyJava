package com.sample.threads;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerUsingWaitNotify {
	volatile int status = 1;

	List<Integer> queue = new ArrayList<>();
	private final int QUEUE_SIZE;

	public ProducerConsumerUsingWaitNotify(int size) {
		QUEUE_SIZE = size;
	}
	public static void main(String[] args) throws InterruptedException {
		ProducerConsumerUsingWaitNotify pC = new ProducerConsumerUsingWaitNotify(10);

		Producer task1 = new Producer(pC);
		Thread thread1 = new Thread(task1);

		Consumer1 task2 = new Consumer1(pC);
		Thread thread2 = new Thread(task2);

		Consumer2 task3 = new Consumer2(pC);
		Thread thread3 = new Thread(task3);

		thread1.start();
		thread2.start();
		thread3.start();

	}

	static class Producer implements Runnable {

		private final ProducerConsumerUsingWaitNotify pC;

		public Producer(ProducerConsumerUsingWaitNotify pC) {
			this.pC = pC;
			
		}

		@Override
		public void run() {
			try {
				synchronized (pC) {
					for (int i = 0; i < 10; i++) {
						while (pC.QUEUE_SIZE == pC.queue.size()) {
							pC.wait();
						}
						pC.queue.add(i);
						pC.status = 2;
						pC.notifyAll();
					}
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	static class Consumer1 implements Runnable {
		private final ProducerConsumerUsingWaitNotify pC;

		public Consumer1(ProducerConsumerUsingWaitNotify pC) {
			this.pC = pC;
		}

		@Override
		public void run() {
			try {
				synchronized (pC) {
					for (int i = 10; i < 20; i++) {
						while ( pC.QUEUE_SIZE == 0 && pC.status != 2) {
							pC.wait();
						}
						System.out.println(2);
						pC.status = 3;
						pC.notifyAll();

					}

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static class Consumer2 implements Runnable {
		private final ProducerConsumerUsingWaitNotify pC;

		public Consumer2(ProducerConsumerUsingWaitNotify pC) {
			this.pC = pC;
		}

		@Override
		public void run() {
			try {
				synchronized (pC) {
					for (int i = 20; i < 30; i++) {
						while (pC.status != 3) {
							pC.wait();
						}
						System.out.println(3);
						pC.status = 1;
						pC.notifyAll();

					}

				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
