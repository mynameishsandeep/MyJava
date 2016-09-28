package com.sample.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTaskTest implements Callable {

	@Override
	public String call() throws Exception {
		System.out.println("Inside call " + Thread.currentThread().getName());
		Thread.sleep(1000);
		return "success";
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTaskTest f = new FutureTaskTest();
		FutureTask ft = new FutureTask(f);
//		Thread t = new Thread(ft);
//		t.start();
		ft.run();
		System.out.println(ft.get());
	}

}
