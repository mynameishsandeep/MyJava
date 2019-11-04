package com.sample.basics;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
    // BlockingQueueProducer producer = new BlockingQueueProducer(queue);
    BlockingQueueConsumer consumer = new BlockingQueueConsumer(queue);
    // starting producer to produce messages in queue
    // new Thread(producer).start();
    // starting consumer to consume messages from queue
    new Thread(consumer).start();

    for (int i = 0; i < 10; i++) {
      String msg = "" + i;
      Thread.sleep(1000);
      queue.put(msg);
      System.out.println("Produced " + msg);
    }
    queue.put("exit");
    System.out.println("Producer has been Stopped");
  }
}
