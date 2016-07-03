package com.sample.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableExecutor implements Callable {

	@Override
	public Object call() throws Exception {
		System.out.println("Inside call " + Thread.currentThread().getName());
		Thread.sleep(1000);
		return null;
	}

	public static void main(String[] args) {
		// Thread t = new Thread(c);
		ExecutorService exec = Executors.newFixedThreadPool(10);
		ExecutorService exec1 = Executors.newFixedThreadPool(10);

		for (int i = 0; i < 30; i++) {
			CallableExecutor c = new CallableExecutor();
			exec.submit(c);

			CallableExecutor c1 = new CallableExecutor();
			exec1.submit(c1);

		}
		exec.shutdown();
		exec1.shutdown();

	}	
}
