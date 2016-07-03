package com.altimetrik.datastructure.list;

public class SingleLinkedListCustom {
	
	class Node {
		int data;
		Node next;
	}
	
	private Node node;
	
	public void add(int data) {
		Node cNode = new Node();
		cNode.data = data;
		if (node != null) {
			Node tempNode = node;
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = cNode;
		} else { // Below if logic runs only once
			node = cNode;
		}
	}

	/**
	 * After adding the element, pass anyone data which will loop 
	 * the end to the specific data passed.
	 * 1) get the last node reference
	 * 2) iterate and find the search data. Point last Node to this node 
	 */
	public void makeALoop(int data) {
		Node lastNode = node;
		while(true) {
			if (lastNode.next != null) {
				lastNode = lastNode.next;
			} else {
				break;
			}
		}
		Node tempNode = node;
		while(true) {
			if (tempNode != null && tempNode.data == data) {
				lastNode.next = tempNode;
				break;
			} else {
				tempNode = tempNode.next;
			}
		}
		
		
	}
	public Node getNode() {
		return node;
	}
	

}
