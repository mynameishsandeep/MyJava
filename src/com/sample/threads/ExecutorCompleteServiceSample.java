package com.sample.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Execution Service doesn't provide method to access completed task first.
 * ExecutorCompleteService provides a method take(), which returns the result of first completed task and so on.
 * 
 * From Java 5 you could use ExecutorCompletionService for this purpose 
 * but as of Java 8 you can use the CompletableFuture interface which 
 * allows to provide a callback interface which is called once a task is completed.
 *
 */
public class ExecutorCompleteServiceSample {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorCompleteServiceSample e = new ExecutorCompleteServiceSample();
		e.executorCompleteServiceSample();
	}

	public void executorCompleteServiceSample() throws InterruptedException, ExecutionException {

		ExecutorService exec1 = Executors.newFixedThreadPool(2);
		final ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(exec1);
		Callable<String> task1 = () -> myRemoteService1();
		Callable<String> task2 = () -> myRemoteService2();
		completionService.submit(task1);
		completionService.submit(task2);

		for (int i = 0; i < 2; ++i) {
			final Future<String> future = completionService.take();
			System.out.println( future.get());
		}
		exec1.shutdown();
	}

	public String myRemoteService1() throws InterruptedException {
		Thread.currentThread().sleep(5000);
		return "Result Of Remote Service1";
	}

	public String myRemoteService2() {
		return "Result Of Remote Service2";
	}

}
