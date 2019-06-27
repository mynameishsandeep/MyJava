package com.interview.leetcode.facebook.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://www.youtube.com/watch?v=eaYX0Ee0Kcg
 * 
 * points[][] = [[3,3],[5,-1],[-2,4]];
 * point1 = points[0] = [3,3];
 * point2 = points[1] = [5,-1];
 * point3 = points[2] = [-2,4];
 * 
 * Note: Don't think about formula too much...Key is, formula needs 2 points.
 * 
 *  1) Solution1 : Just sort and return top K. O(NlogN) 
 *  2) Solution2 : Use priorityqueue, keep only top K and return it. O(NlogK)
 *  3) Solution3 : Use QuickSelect. Since topK can be of any order, this approach will work. 
 *  If topK needs to be in sorted order then Solution3 is not possible.
 *   The average time complexity is O(N) , but just like quick sort, in the worst case, 
 *   this solution would be degenerated to O(N^2), 
 * 
 */
public class KClosestPointsToOrigin {

	//O(NlogN)
	public int[][] kClosest(int[][] points, int K) {
		Arrays.sort(points, (p1, p2) -> {

			int x1 = p1[0];
			int y1 = p1[1];

			int x2 = p2[0];
			int y2 = p2[1];
			return (x1 * x1) + (y1 * y1) - (x2 * x2) - (y2 * y2);
		});
		return Arrays.copyOfRange(points, 0, K);
	}

	// O(NlogK)
	/*
	 * 
	 * Sort the element in descending order. So that we can remove minimum element 
	 * 
	 * The advantage of this solution is it can deal with real-time(online) stream data. 
	 * It does not have to know the size of the data previously.
	 * The disadvantage of this solution is it is not the most efficient solution.
	 */
	public int[][] kClosestUsingPriorityQueue(int[][] points, int K) {
		PriorityQueue<int[]> q = new PriorityQueue<int[]>(
				(p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);

		for (int i = 0; i < points.length; i++) {
			q.offer(points[0]);
			if (q.size() > K) {
				q.poll();
			}
		}
		int[][] result = new int[K][2];
		while (K > 0) {
			result[--K] = q.poll();
		}
		return result;

	}
}
