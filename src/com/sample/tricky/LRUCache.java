package com.sample.tricky;

import java.util.HashMap;

public class LRUCache {
	class Node {
		int key;
		int value;
		Node prevNode;
		Node nextNode;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	int capacity;
	HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node end = null;

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}

		return -1;
	}

	private void remove(Node n) {
		if (n.prevNode != null) {
			n.prevNode.nextNode = n.nextNode;
		} else {
			head = n.nextNode;
		}

		if (n.nextNode != null) {
			n.nextNode.prevNode = n.prevNode;
		} else {
			end = n.prevNode;
		}

	}

	private void setHead(Node n) {
		n.nextNode = head;
		n.prevNode = null;

		if (head != null)
			head.prevNode = n;

		head = n;

		if (end == null)
			end = head;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(end.key);
				remove(end);
				setHead(created);

			} else {
				setHead(created);
			}

			map.put(key, created);
		}
	}

	public void print() {
		Node temp = head;
		while (true) {
			if (temp != null) {
				System.out.println(temp.value);
			}
			if (temp.nextNode == null) {
				break;
			} else {
				temp = temp.nextNode;
			}
		}
	}

	public static void main(String[] args) {

		LRUCache cache = new LRUCache(10);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
		cache.put(6, 6);
		cache.put(7, 7);
		cache.put(8, 8);
		cache.put(9, 9);
		cache.put(10, 10);

		cache.get(1);

		cache.put(11, 11);

		cache.print();
	}
}