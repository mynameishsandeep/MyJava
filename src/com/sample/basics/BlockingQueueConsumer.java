package com.sample.basics;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueConsumer implements Runnable {

  private BlockingQueue<String> queue;

  public BlockingQueueConsumer(BlockingQueue<String> q) {
    this.queue = q;
  }

  @Override
  public void run() {
    try {
      String msg;
      // consuming messages until exit message is received
      while (!(msg = queue.take()).equals("exit")) {
        Thread.sleep(1000);
        System.out.println("Consumed " + msg);
      }
      System.out.println("Consumer has been Stopped");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
