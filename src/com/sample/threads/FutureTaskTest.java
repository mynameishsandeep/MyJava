package com.sample.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {

	public void futureTaskTest() throws InterruptedException, ExecutionException {
		Callable<String> callable = () -> {
			System.out.println("Inside call " + Thread.currentThread().getName());
			Thread.sleep(1000);
			return "success";
		};

		FutureTask<String> ft = new FutureTask<>(callable);
		Thread t = new Thread(ft);
		t.start();
		// ft.run(); FutureTask cannot run directly. It will not have thread behavior.
		// ft.cancel(true);
		System.out.println(ft.get());
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTaskTest f = new FutureTaskTest();
		f.futureTaskTest();
	}

}
