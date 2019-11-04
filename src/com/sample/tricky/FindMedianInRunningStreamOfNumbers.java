package com.sample.tricky;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* https://leetcode.com/problems/find-median-from-data-stream/description/
* What is Median? When the input size is odd, we take the middle element of sorted data.
* If the input size is even, we pick average of middle two elements in sorted data.

* Refer diagram "Median for Stream of Numbers.jpg" in US Problems folder
*
*  1)Save the data like "n" shape in to queue. Ex: below
* 					3
*  				2      4
*  				1      5
*  2) Read from top.
*
* Note: To return float. do the type casting or divide the number by 2.0
*/
public class FindMedianInRunningStreamOfNumbers {

  // Java Priority Queue is min heap by default. Changing it to Max Heap
  Queue<Integer> lowToHigh = new PriorityQueue<>(Collections.reverseOrder());
  Queue<Integer> highToLow = new PriorityQueue<>();

  public void addNum(int num) {
    if (lowToHigh.size() == highToLow.size()) {
      lowToHigh.offer(num);
    } else {
      highToLow.offer(num);
    }
    if (!highToLow.isEmpty() && lowToHigh.peek() > highToLow.peek()) {
      int temp = lowToHigh.poll();
      lowToHigh.offer(highToLow.poll());
      highToLow.offer(temp);
    }
  }

  public double findMedian() {
    if (lowToHigh.size() == highToLow.size()) return (lowToHigh.peek() + highToLow.peek()) / 2.0;
    return lowToHigh.peek();
  }
}
