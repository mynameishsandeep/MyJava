package com.sample.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSample implements Callable {

	Lock lock = new ReentrantLock();
	public void fun() throws InterruptedException {
		lock.lock();
		System.out.println("Inside Fun");
		Thread.currentThread().sleep(2000);
		lock.unlock();
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(4);
		LockSample lock = new LockSample();
		exec.submit(lock);
		exec.submit(lock);
		exec.submit(lock);
		exec.submit(lock);
		exec.shutdown();
	}

	@Override
	public Object call() throws Exception {
		try {
			fun();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
