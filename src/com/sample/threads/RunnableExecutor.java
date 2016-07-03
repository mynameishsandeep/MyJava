package com.sample.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableExecutor implements Runnable{

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		RunnableExecutor run = new RunnableExecutor();
		
		Future f1  = executor.submit(run);
		Future f2  = executor.submit(run);
		Future f3  = executor.submit(run);
		Future f4  = executor.submit(run);
		executor.shutdown();

	}

	@Override
	public void run() {
		System.out.println("Inside Run");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
