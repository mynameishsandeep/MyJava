package com.sample.threads;

public class WaitNotifyExample implements Runnable {

	public static void main(String[] args) {

		WaitNotifyExample w = new WaitNotifyExample();
		Thread t1 = new Thread(w);
		t1.start();
		Thread t2 = new Thread(w);
		t2.start();

	}

	public void fun() throws InterruptedException {
		synchronized (this) {
			this.wait();
			System.out.println("Wait is over");
		}
	}

	@Override
	public void run() {
		System.out.println("Inside Running");
		try {
			fun();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
