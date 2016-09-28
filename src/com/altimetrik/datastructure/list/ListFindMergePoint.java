package com.altimetrik.datastructure.list;

/**
 * 1) Get the count of list 1.
 * 2) Get the count of list 2.
 * 3) Get the difference of node -- diffCount.
 * 4) Traverse the bigger list with diffCount.
 * 5) Then Traverse both the list and compare data. If the data matches, then that is the merge point  
 */
public class ListFindMergePoint<T> {

	private Node<T> head;

	static class Node<T> {
		private T data;
		private Node<T> next;

		Node(T data) {
			this.data = data;
			next = null;
		}
	}

	public T getTheMergePoint(ListFindMergePoint<T> list2) {
		int countOflist1Nodes = getNodeCount(head);
		int countOflist2Nodes = getNodeCount(list2.head);
		Integer diffCount = 0;

		if (countOflist1Nodes > countOflist2Nodes) {
			diffCount = countOflist1Nodes - countOflist2Nodes;
			return findTheMergePoint(diffCount, head, list2.head);
		} else {
			diffCount = countOflist2Nodes - countOflist1Nodes;
			return findTheMergePoint(diffCount, list2.head, head);
		}
	}

	public T findTheMergePoint(Integer diffCount, Node<T> node1, Node<T> node2) {
		Integer i;
		Node<T> current1 = node1;
		Node<T> current2 = node2;
		// Traverse the bigger list with difference Count
		for (i = 0; i < diffCount; i++) {
			if (current1 == null) {
				return null;
			}
			current1 = current1.next;
		}
		// Traverse both the node and compare both the data
		while (current1 != null && current2 != null) {
			if (current1.data == current2.data) {
				return current1.data;
			}
			current1 = current1.next;
			current2 = current2.next;
		}
		return null;
	}

	public Integer getNodeCount(Node<T> node) {
		Node<T> current = node;
		int count = 0;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}

	public static void main(String[] args) {
		ListFindMergePoint<Integer> list1 = new ListFindMergePoint<>();
		list1.head = new Node<Integer>(3);
		list1.head.next = new Node<Integer>(6);
		list1.head.next.next = new Node<Integer>(15);
		list1.head.next.next.next = new Node<Integer>(15);
		list1.head.next.next.next.next = new Node<Integer>(30);

		ListFindMergePoint<Integer> list2 = new ListFindMergePoint<>();
		list2.head = new Node<Integer>(10);
		list2.head.next = new Node<Integer>(15);
		list2.head.next.next = new Node<Integer>(30);

		System.out.println("Both the list meet at node : " + list1.getTheMergePoint(list2));

	}
}