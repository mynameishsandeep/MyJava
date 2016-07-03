package com.sample.threads;

public class RunnableThread implements Runnable {

	@Override
	public void run() {
/*		//int i = 10/0;
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/		System.out.println("Inside Run");
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new RunnableThread());
		t1.start();
		t1.start();
		t1.join();
		System.out.println("Thread Join Success");
		//t1.start();
	}
}
