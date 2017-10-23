package com.sample.basics;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
		// BlockingQueueProducer producer = new BlockingQueueProducer(queue);
		BlockingQueueConsumer consumer = new BlockingQueueConsumer(queue);
		// starting producer to produce messages in queue
		// new Thread(producer).start();
		// starting consumer to consume messages from queue
		new Thread(consumer).start();

		for (int i = 0; i < 100; i++) {
			String msg = new String("" + i);
			try {
				Thread.sleep(i);
				queue.put(msg);
				System.out.println("Produced " + msg);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Producer and Consumer has been started");
	}
}
