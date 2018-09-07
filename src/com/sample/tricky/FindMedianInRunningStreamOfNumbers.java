package com.sample.tricky;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/* What is Median? When the input size is odd, we take the middle element of sorted data. 
 * If the input size is even, we pick average of middle two elements in sorted data.
 * https://leetcode.com/problems/find-median-from-data-stream/description/
 * 
 * Refer diagram "Median for Stream of Numbers.jpg" in US Problems folder
 * 
 * 1) Maintain 2 priority queues such that stream numbers are arranged from 0 to 10...
 * 	  Ex: for 0 to 10 numbers
 *    Lower half maintains from 5 to 0, Upper half maintains 6 to 10.
 *    So at any point I can get middle numbers.
 * 2) Add Operation: 
 *    a) When both heaps contain same number of elements, then insert the element in lower half, otherwise insert in upper half.
 * 	  b) So Lower half will have max or equal number as compared to upper half elements.
 * 3) find Median:
 * 	  If both lower and half size is same then peek 1 element from each queue and divide by 2.
 * 	  Else return lower half element.
 * 
 * Note: To return float. do the type casting or divide the number by 2.0
 */
public class FindMedianInRunningStreamOfNumbers {
	
	// Java Prioriry Queue is min heap by default. Changing it to Max Heap
	Queue<Integer> lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
	Queue<Integer> upperHalf = new PriorityQueue<>();

	public void addNum(int num) {
		if (lowerHalf.size() == upperHalf.size()) {
			lowerHalf.offer(num);
		} else {
			upperHalf.offer(num);
		}
		if (upperHalf.size() > 0 && lowerHalf.peek() > upperHalf.peek()) {
			int temp = lowerHalf.poll();
			lowerHalf.offer(upperHalf.poll());
			upperHalf.offer(temp);
		}

	}

	public double findMedian() {
		if (lowerHalf.size() == upperHalf.size()) {
			return (lowerHalf.peek() + upperHalf.peek()) / 2.0;
			//return (double) (lowerHalf.peek() + upperHalf.peek()) / 2;
		} else {
			return lowerHalf.peek();
		}
	}
	
	public static void main(String[] args) {
		FindMedianInRunningStreamOfNumbers f = new FindMedianInRunningStreamOfNumbers();
		f.addNum(1);
		f.addNum(2);
		System.out.println(f.findMedian());
		f.addNum(3);
		System.out.println(f.findMedian());
	}

}

