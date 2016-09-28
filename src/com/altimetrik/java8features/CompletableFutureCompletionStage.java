package com.altimetrik.java8features;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureCompletionStage {

	ExecutorService exec = Executors.newFixedThreadPool(1);

	public static void main(String[] args) throws Exception {
		CompletableFutureCompletionStage f = new CompletableFutureCompletionStage();
		Future<String> future = f.localMethodCompletableFuture1();
		System.out.println(future.get());
		System.out.println("Exited");

	}

	public CompletableFuture<String> localMethodCompletableFuture1() throws InterruptedException {
		final CompletableFuture<String> future = new CompletableFuture<>();
		future.complete(remoteMethod());
		return future;
	}

	public String remoteMethod() throws InterruptedException {
		Thread.currentThread().sleep(4000);
		return "Remote Method";
	}
}
