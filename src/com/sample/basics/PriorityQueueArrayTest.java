package com.sample.basics;

import java.util.PriorityQueue;

/*
 * The Priority Queue implementation in the Java is a default min heap Priority Queue.
 * Meaning------> minimum will be at top

In order to turn it into a max one I create a custom comparator object like below or Use Java's Collections.reverseOrder() comparator.

 */
public class PriorityQueueArrayTest {

  public static void main(String[] args) {
    int[] aa = new int[] {100, 0};
    int[] bb = new int[] {50, 1};
    int[] cc = new int[] {200, 2};

    PriorityQueue<int[]> pQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);

    pQ.offer(aa);
    pQ.offer(bb);
    pQ.offer(cc);

    while (!pQ.isEmpty()) {
      int data[] = pQ.poll();
      System.out.println(data[0] + " " + data[1]);
    }
  }
}
