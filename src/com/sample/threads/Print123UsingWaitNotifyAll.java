package com.sample.threads;

public class Print123UsingWaitNotifyAll {
	volatile int status = 1;

	public static void main(String[] args) throws InterruptedException {
		Print123UsingWaitNotifyAll pC = new Print123UsingWaitNotifyAll();

		MyTask1 task1 = new MyTask1(pC);
		Thread thread1 = new Thread(task1);

		MyTask2 task2 = new MyTask2(pC);
		Thread thread2 = new Thread(task2);

		MyTask3 task3 = new MyTask3(pC);
		Thread thread3 = new Thread(task3);

		thread1.start();
		thread2.start();
		thread3.start();

	}

	static class MyTask1 implements Runnable {

		private final Print123UsingWaitNotifyAll pC;

		public MyTask1(Print123UsingWaitNotifyAll pC) {
			this.pC = pC;
		}

		@Override
		public void run() {
			try {
				synchronized (pC) {
					for (int i = 0; i < 10; i++) {
						while (pC.status != 1) {
							pC.wait();
						}
						System.out.println(1);
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

	static class MyTask2 implements Runnable {
		private final Print123UsingWaitNotifyAll pC;

		public MyTask2(Print123UsingWaitNotifyAll pC) {
			this.pC = pC;
		}

		@Override
		public void run() {
			try {
				synchronized (pC) {
					for (int i = 10; i < 20; i++) {
						while (pC.status != 2) {
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

	static class MyTask3 implements Runnable {
		private final Print123UsingWaitNotifyAll pC;

		public MyTask3(Print123UsingWaitNotifyAll pC) {
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
