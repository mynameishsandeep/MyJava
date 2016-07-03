package com.sample.basics;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		Queue<String> pQ = new PriorityQueue<>(5);
		pQ.add("Hello");
		pQ.add("Test");
		pQ.add("Apple");
		pQ.add("Alhpa");
		pQ.add("twitter");
		pQ.add("Google");
		
		Iterator it = pQ.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}

	}

}
