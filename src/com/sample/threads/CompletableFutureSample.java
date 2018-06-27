package com.sample.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompletableFuture is an non-blocking - reactive callback mechanism.
 *
 */
public class CompletableFutureSample {
	public static void main(String[] args) throws Exception {
		CompletableFutureSample co = new CompletableFutureSample();
		co.callAsync();
	}

	public void callAsync() throws Exception {
		ExecutorService exec1 = Executors.newFixedThreadPool(2);
		CompletableFuture<String> service1Result = CompletableFuture.supplyAsync(() -> myRemoteService1(),exec1);
		CompletableFuture<String> service2Result = CompletableFuture.supplyAsync(() -> myRemoteService2(),exec1);
		service1Result.thenAccept((String result) -> System.out.println((result)));
		service2Result.thenAccept((String result) -> System.out.println((result)));
		System.out.println("Both threads Started");
		exec1.shutdown();
		// This will still print without Thread2 finishing
		System.out.println("Both threads Ended");
	}

	public String myRemoteService1() {
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
