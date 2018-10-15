package com.interview.leetcode.linkedin.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.interview.leetcode.ListNode;

/*
 * https://leetcode.com/problems/merge-k-sorted-lists/description/
 * 
 * 1) First time fill priority queue with 0th index of node from all array.
 * 2) Poll a node from queue, which is the least value and 1st result. 
 * 3) If the node has next node, offer the next node. Else poll next node from queue.
 * ===========================
 * Trick: We don't need to maintain array index to poll "next data" specifically from particular index of array. 
 * It is done implicitly because of node data structure "node.next" 
 * If the node is not having the "next" attribute itself, then solution would be more tricky.
 * ===========================
 * =======Solution Approach for Array of Integers(Not for below problem, because below problem is based on Array of connected node)=========
   1) The data should be offered as pair<data, index(index of array), index(index of element in array)> in priority queue 
   2) First time fill priority queue with 0th index of data from all array.
 * 3) Poll a data pair from queue, which is the least value and 1st result.
 * 4) from the pair load the next data from specific index of array, inside that specific element.
 * 3) If the array is not empty, offer the next element. Else poll next element from queue.

 
 * O(nlogk).
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		Queue<ListNode> q = new PriorityQueue<>(new ListNodeComparator());
		// First time fill queue with 0th index of data from all array        
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				q.offer(lists[i]);
			}
		}
		ListNode prevNode = null;
		ListNode headNode = null;
		while (q.size() > 0) {
			ListNode currNode = q.poll();
			if (null != currNode.next) {
				q.offer(currNode.next); //pushing data into queue
			}
			if (null == prevNode) { // Execute during the first time only
				headNode = currNode;
				currNode.next = null;
				prevNode = currNode;
			} else { //connecting next node
				prevNode.next = currNode;
				currNode.next = null;
				prevNode = currNode;
			}
		}
		return headNode;
	}

	public class ListNodeComparator implements Comparator<ListNode> {
		public int compare(ListNode l1, ListNode l2) {
			return l1.val - l2.val;
		}
	}
}
