package com.yahoo.array;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/*Ex: [5,6,7,-100,-90,-20,8] : output: 8*-100*-90
 * Approach 1) Sort. Then calculate product on top 3 numbers. And top1 number with bottom 2 number.
 * Whichever is high return. Complexity O(N(log(N)) because of sorting
 * Approach 2) Iterate 5 times and get top 3 number and Bottom 2 Number. Complexity 5N. Approximately N.
 * Approach 3) Keep track of top3 numbers and bottom 2 numbers using priorityQueue. Calculate max.
 */
public class HighestProductOf3Numbers {

	/*
	 * Solution using Approach 3
	 */
	public int maximumProduct(int[] nums) {
		// Keep Top3
		Queue<Integer> q1 = new PriorityQueue<>();
		// Keep Bottom2
		Queue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
		for (Integer num : nums) {
			q1.offer(num);
			if (q1.size() > 3) {
				q1.poll();
			}
			q2.offer(num);
			if (q2.size() > 2) {
				q2.poll();
			}
		}
		int num1 = q1.poll();
		int num2 = q1.poll();
		int num3 = q1.poll();

		int num4 = q2.poll();
		int num5 = q2.poll();

		return Math.max(num1 * num2 * num3, num3 * num4 * num5);
	}
}
