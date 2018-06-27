package com.sample.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Future get() method is blocking. Lets say we fire 2 task, task1 and task2 on Executor Service. 
 * If task2 is completed prior, we can get the result of task2 only on future2.
 * If task1 is completed prior, we can get the result of task1 only on future1.
 * From coding we can loop through all the future randomly for first completed result which is awkward.
 * Execution Service doesn't provide method to access completed task first.
 * ExecutorCompleteService provides a method take(), which returns the result of first completed task and so on. 
 *
 */
public class ExecutorServiceDownSides {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorServiceDownSides c = new ExecutorServiceDownSides();
		Callable<String> task1 = () -> c.myRemoteService1();
		ExecutorService exec1 = Executors.newFixedThreadPool(2);

		ExecutorService executorService = 
				  new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,   
				  new LinkedBlockingQueue<Runnable>());
		
		Callable<String> task2 = () -> c.myRemoteService2();

		Future<String> future1 = exec1.submit(task1);
		Future<String> future2 = exec1.submit(task2);

		System.out.println(future1.get(6, TimeUnit.SECONDS));
		System.out.println(future2.get(6, TimeUnit.SECONDS));
		exec1.shutdown();

	}

	public String myRemoteService1() throws InterruptedException {
		Thread.currentThread().sleep(5000);
		return "Result Of Remote Service1";
	}

	public String myRemoteService2() throws InterruptedException {
		Thread.currentThread().sleep(4000);
		return "Result Of Remote Service2";
	}

}
