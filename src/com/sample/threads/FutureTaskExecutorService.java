package com.sample.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class FutureTaskExecutorService {

	public FutureTask<String> futureTaskTest() throws InterruptedException, ExecutionException {
		
		final FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
			public String call() throws InterruptedException {
				System.out.println("Inside call " + Thread.currentThread().getName());
				Thread.sleep(4000);
				return "success";
			}
		});
		return task;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTaskExecutorService f = new FutureTaskExecutorService();

		FutureTask<String> ft = f.futureTaskTest();
		
		ExecutorService e = Executors.newCachedThreadPool();
		e.execute(ft);
		System.out.println(ft.get());
		e.execute(ft);
		System.out.println(ft.get());
	}
}
