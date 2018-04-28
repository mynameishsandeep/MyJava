package com.altimetrik.datastructure.list;

/**
 * 1) Get the count of list1. Ex: 10
 * 2) Get the count of list2. Ex: 15
 * 3) Get the difference of node -- diffCount. 15-10=5
 * 4) Traverse the bigger list till diffCount. (List2 will be traversed till 5 node. )
 * 5) Then Traverse both the list and compare data. If the data matches, then that is the merge point  
 */
public class ListFindMergePoint<T> {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Integer headACount = getNodeCount(headA);
		Integer headBCount = getNodeCount(headB);

		if (headACount > headBCount) {
			Integer count = headACount - headBCount;
			headA = moveNodeToK(headA, count);
		} else {
			Integer count = headBCount - headACount;
			headB = moveNodeToK(headB, count);
		}
		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;
	}

	private ListNode moveNodeToK(ListNode node, Integer count) {
		while (count != 0) {
			node = node.next;
			count--;
		}
		return node;
	}

	private Integer getNodeCount(ListNode node) {
		Integer count = 0;
		while (node != null) {
			node = node.next;
			count++;
		}
		return count;
	}
}