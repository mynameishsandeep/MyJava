package com.altimetrik.datastructure;

public class QueueUsingLinkedList {
	class Node {
		int data;
		Node next;
	}
	Node front;
	Node rear;

	public void enqueue(int data) {
		Node current = new Node();
		current.data = data;
		if (front == null && rear == null) {
			front = current;
			rear = current;
		} else {
			rear.next = current;
			rear = current;
		}
	}

	public void dequeue() {
		System.out.println(front.data);
		front = front.next;
	}

	public static void main(String[] args) {
		QueueUsingLinkedList queue = new QueueUsingLinkedList();
		queue.enqueue(100);
		queue.enqueue(200);
		queue.enqueue(300);
		queue.enqueue(400);
		queue.enqueue(250);
		
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
	}

}
