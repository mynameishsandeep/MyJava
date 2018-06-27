package com.sample.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureCachedThreadPool {
	public static void main(String[] args) throws Exception {
		FutureCachedThreadPool co = new FutureCachedThreadPool();
		co.callAsync();

	}

	public void callAsync() throws Exception {
		ExecutorService exec1 = Executors.newCachedThreadPool();
		CompletableFuture<String> service1Result =null;
		for (int i = 0; i < 5; i++) {
			service1Result = CompletableFuture.supplyAsync(() -> myRemoteService1(), exec1);
			
		}
		System.out.println(service1Result.get());

	}

	public String myRemoteService1() {
		System.out.println("Start of Remote Service1");
		try {
			Thread.currentThread().sleep(5000);
		} catch (InterruptedException e) {
		}
		return "Result Of Remote Service1";
	}

	public String myRemoteService2() {
		return "Result Of Remote Service2";
	}

}
