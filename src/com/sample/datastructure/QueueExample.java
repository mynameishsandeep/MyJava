package com.sample.datastructure;

import java.util.LinkedList;
import java.util.Queue;



public class QueueExample {
	static class Node {
		int data;
		Node right;
		Node left;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		{
			Queue<Node> q = new LinkedList<>();

			// Adds elements {0, 1, 2, 3, 4} to queue
			for (int i = 0; i < 10; i++) {
				Node n = new Node(i);
				q.add(n);
			}
			System.out.println("Size of queue-" + q.size());
			// Display contents of the queue.
			System.out.println("Elements of queue-" + q);

			// To remove the head of queue.
			Node removedele = q.remove();
			System.out.println("removed element-" + removedele.data);

			System.out.println(q);

			// To view the head of queue
			Node head = q.peek();
			System.out.println("head of queue-" + head.data);

			// Rest all methods of collection interface,
			// Like size and contains can be used with this
			// implementation.
			int size = q.size();
			System.out.println("Size of queue-" + size);
		}
	}

}