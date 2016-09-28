package com.ge.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class QueueApp {
	private final List<String> queue;
	private final int SIZE;
	private int currentIndex =0 ;
	volatile String data;

	QueueApp(int size) {
		queue = new ArrayList<>();
		SIZE = size;
	}

	Callable push = new Callable() {
		
		@Override
		public Object call() throws Exception {
			synchronized (this) {
				queue.add(currentIndex++,data);
				System.out.println("Current Queue Data ");
				queue.forEach(System.out::println);
				// When the queue size is full, wait for the notification
				if (queue.size() == SIZE) {
					try {
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
			return data;
		}
	};

	Callable get = new Callable() {
		@Override
		public Object call() throws Exception {
			String result = "";
			synchronized (this) {
				if (queue.size() > 0) {
					result = queue.get(0);
					if (queue.size() == SIZE) {
						this.notify();
					}
					queue.remove(0);
				}
			}
			return result;
		}
	};

	public static void main(String args[]) throws InterruptedException, ExecutionException {
		QueueApp queue = new QueueApp(3);
		ExecutorService exec = Executors.newFixedThreadPool(1);
		queue.data = "data11";
		exec.submit(queue.push);
		queue.data = "data22";
		exec.submit(queue.push);
		queue.data = "data33";
		exec.submit(queue.push);
		
		Future<String> future = exec.submit(queue.get);
		System.out.println(future.get());
		Future<String> future1 = exec.submit(queue.get);
		System.out.println(future1.get());
		Future<String> future2 = exec.submit(queue.get);
		System.out.println(future2.get());
		exec.shutdown();
		
	}

}
