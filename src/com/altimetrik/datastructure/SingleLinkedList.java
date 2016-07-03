package com.altimetrik.datastructure;

class Node {
	char data;
	Node next;
}

public class SingleLinkedList {

	Node head;

	public void add(char data) {
		Node currentNode = new Node();
		currentNode.data = data;
		if (head == null) {
			head = currentNode;
		} else {
			Node lastNode = traverse();
			lastNode.next = currentNode;
		}
	}

	public void insertAtNth(char data, int position) {
		Node tempNode = head;

		if (position == 0) {
			Node currNode = new Node();
			currNode.data = data;
			currNode.next = tempNode;
			head = currNode;
			return;
		}

		int i = 1;
		while (true) {
			if (position == i) {
				Node currNode = new Node();
				currNode.data = data;
				currNode.next = tempNode.next;
				tempNode.next = currNode;
				break;
			}
			i++;
			tempNode = tempNode.next;
		}
	}

	public void deleteAtNth(int position) {
		Node tempNode = head;
		if (position == 0) {
			head = head.next;
		} else {
			int i = 1;
			while (true) {
				if (position == i) {
					Node next = tempNode.next;
					next = next.next;
					tempNode.next = next;
					break;
				}
				i++;
				tempNode = tempNode.next;
			}
		}
	}

	public void print() {
		Node temp = head;
		while (true) {
			if (temp.next == null) {
				System.out.println(temp.data);
				break;
			} else {
				System.out.println(temp.data);
				temp = temp.next;
			}
		}
		System.out.println("Printing Done");
	}

	public void reverse() {
		Node nextNode = null;
		Node currNode = head;
		Node tempNode = null;

		while (currNode.next != null) {
			nextNode = currNode.next;
			currNode.next = tempNode;
			tempNode = currNode;
			currNode = nextNode;
		}
		currNode.next = tempNode;
		head = currNode;
	}

	public Node traverse() {
		Node temp = head;
		while (true) {
			if (temp.next == null) {
				return temp;
			} else {
				temp = temp.next;
			}
		}
	}

	public String getNodeData() {
		StringBuilder output = new StringBuilder();
		Node temp = head;
		while (true) {
			if (temp.next == null) {
				output.append(temp.data);
				break;
			} else {
				output.append(temp.data);
				temp = temp.next;
			}
		}
		return output.toString();

	}

	public boolean isPalindrome() {
		String originalString = getNodeData();
		reverse();
		String reversedString = getNodeData();
		reverse();
		System.out.println("originalString " + originalString);
		System.out.println("reversedString " + reversedString);
		return originalString.equals(reversedString);
	}

	Node RemoveDuplicates(Node head) {
		if (head == null) {
			return null;
		}
		Node temp1 = head.next;
		temp1 = temp1.next;
		Node temp = head;
		temp = temp.next;
		temp.next = null;
		while (temp1 != null) {
			if (temp.data == temp1.data) {
				temp1 = temp1.next;
			} else {
				temp.next = temp1;
				temp = temp1;
			}
		}
		return head;
	}

	public int HasCycle(Node head) {
		Node move1 = head;
		Node move2 = head;
		if (move1 == null || move1.next == null) {
			return 0;
		}
		while (true) {
			if (move2.next == null) {
				return 0;
			} else {
				move2 = move2.next;
			}
			if (move2.next == null) {
				return 0;
			} else {
				move2 = move2.next;
			}
			move1 = move1.next;
			if (move1 == move2) {
				return 1;
			}
		}
	}

	public static void main(String[] args) {
		SingleLinkedList s = new SingleLinkedList();
		s.add('p');
		s.add('a');
		s.add('p');
		/*
		 * s.print(); s.reverse(); s.print(); s.reverse(); s.print();
		 * System.out.println(s.isPalindrome());
		 */
		s.insertAtNth('y', 3);
		s.deleteAtNth(3);
		s.print();
	}

}
