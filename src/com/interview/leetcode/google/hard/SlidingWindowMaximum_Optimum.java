package com.interview.leetcode.google.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 * https://leetcode.com/problems/sliding-window-maximum/description/
 * https://www.educative.io/collection/page/5642554087309312/5679846214598656/210002
 *
 * Ex: 1 2 3 4 5 6... window size 3
 * I will keep only one number in queue.Because  
 * for 1 2 3... 1 & 2 never be answer. So q will have only 3
 * for 2 3 4... 2 & 3 never be answer. So q will have only 4
 * 
 * 
 * Ex: 6 5 4 3 2 1... window size 3
 * I will keep only 3 number in queue.Because any thing can be result.  
 * 
 * Below solution is possible, because of doubly linked list where we can insert/delete at both ends
 *
 * 1) If the current element is greater than the previous(in the queue tail(last)). 
 * remove element from queue tail(tail). Do this recursively. 
 * 2) Then insert current element to tail
 * 3) Step1 and Step2 action will make "queue head(first)" to hold the max element. 
 * Add "queue head(first)" to result.  
 * 
1) poll: pop an element out of the queue;
max: report the max element in queue;O(1)
It takes only O(n) time to process a N-size sliding window minimum/maximum problem.

 */
public class SlidingWindowMaximum_Optimum {

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0) {
			return new int[0];
		}
		Deque<Integer> queue = new ArrayDeque<>(k);
		int[] res = new int[nums.length + 1 - k];
		// Before a full window, simply update element to queue 
		for (int i = 0; i < k - 1; i++) {
			updateQueue(queue, nums[i]);
		}
		// Once the desired window is achieved, get result from head.
		for (int i = 0; i < res.length; i++) {
			updateQueue(queue, nums[i + k - 1]);
			System.out.println(queue);
			res[i] = queue.peekFirst();
			//remove the element at head if its index no longer falls in current window
			if (nums[i] == queue.peekFirst()) {
				queue.removeFirst();
			}
		}
		return res;
	}

	private void updateQueue(Deque<Integer> queue, int num) {
		while (!queue.isEmpty() && num > queue.peekLast()) {
			System.out.println("Hit");
			queue.removeLast();
		}
		queue.addLast(num);
	}

	public static void main(String[] args) {
		SlidingWindowMaximum_Optimum s = new SlidingWindowMaximum_Optimum();
		//int input[] = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		//int input[] = new int[] { 1, -1 };
		//int input[] = new int[] { 7,2,4 };
		int input[] = new int[] {1,2,3,4,5};
		//System.out.println(Arrays.toString(s.maxSlidingWindow(input, 3)));
		//System.out.println(Arrays.toString(s.maxSlidingWindow(input, 1)));
		System.out.println(Arrays.toString(s.maxSlidingWindow(input, 3)));
	}
}
