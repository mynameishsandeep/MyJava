package com.sample.basics;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducer implements Runnable {
	private BlockingQueue<String> queue;

	public BlockingQueueProducer(BlockingQueue<String> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		// produce messages
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
		// adding exit message
		String msg = new String("exit");
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
