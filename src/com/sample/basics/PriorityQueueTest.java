package com.sample.basics;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		Queue<String> pQ = new PriorityQueue<>(2);
		pQ.offer("Hello");
		pQ.offer("Test");
		pQ.offer("Apple");

		Iterator it = pQ.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		Queue<Integer> pQ1 = new PriorityQueue<>(2);
		pQ1.offer(20);
		pQ1.offer(4);
		pQ1.offer(1);
		pQ1.offer(12);
		pQ1.offer(2);
		/*
		 * Internally System.out.println() will be invoking the toString()
		 * method which in turn uses the iterator to iterate through the
		 * elements of the queue. But the iterator does not guarantee any
		 * specific order to traverse the elements.
		 */
		Iterator it1 = pQ1.iterator();
		while (it1.hasNext()) {
			System.out.print(it1.next()+" ");
		}
		System.out.println();
		while (pQ1.size() > 0) {
			System.out.print(pQ1.poll() +" ");
		}

	}

}
