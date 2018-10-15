package com.interview.leetcode.linkedin.medium;

import java.util.Random;

import com.interview.leetcode.ListNode;

/*
 * https://leetcode.com/problems/linked-list-random-node/description/
 * http://blog.jobbole.com/42550/
 * Given a singly linked list, return a random node's value from the linked list. 
 * Each node must have the "same probability of being chosen".
 * 
 * 1) You can keep only 2 data at a time. 
 * 2) Deciding which to choose depends on random choose algorithm. 
 * 
 * 3) I can say generate number between 0 and 1. Then choose/delete anyone based on that,
 * That will make the probability as
 * 1/2, 1/2, 1/2, 1/2 every time, which is wrong
 * 
 * 4) The Random should works like the probability 1/2, 1/3, 1/4, 1/5, 1/6..
 * 
 * Step 3 is 100% wrong,. Ex: for a 50 data in list. 
 * 50th data has the probability of winning 50%
 * whereas 1st data has to survive a lot or 0% to survive and cannot till end.
 * The property "same probability of being chosen" is gone.
 */
public class LinkedListRandomNode {

	ListNode tempHead;
	Random random;

	public LinkedListRandomNode(ListNode h) {
		tempHead = h;
		random = new Random();
	}

	public int getRandom() {
		ListNode head = tempHead;
		int prevVal = head.val;
		int count = 1;
		while (head.next != null) {
			head = head.next;
			if (random.nextInt(++count) == 1) {
				prevVal = head.val;
			}
		}

		return prevVal;
	}

	public int getRandomWrongVersion() {
		ListNode head = tempHead;
		int prevVal = head.val;
		while (head.next != null) {
			head = head.next;
			// Generate 0 or 1. if 1 replace prveValue else keep prevValue. But this is wrong and not passing all test cases.
			if (random.nextInt(2) == 1) {
				prevVal = head.val;
			}
		}

		return prevVal;
	}

}
