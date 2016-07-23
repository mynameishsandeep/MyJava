package com.sample.datastructure;


public class StackUsingLinkedList {
	class Node {
		int data;
		Node next;
	}
	
	Node top;
	
	public void push(int data) {
		Node node = new Node();
		node.data = data;
		if (top != null) {
			Node temp = top;
			top = node;
			node.next = temp;
		} else {
			top = node;
		}
	}
	
	public void pop() {
		System.out.println(top.data);
		top = top.next;
	}
	
	public static void main(String[] args) {
		StackUsingLinkedList stack = new StackUsingLinkedList();
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(250);
		stack.push(150);
		stack.pop();
		stack.pop();
		stack.pop();
		

	}

}
