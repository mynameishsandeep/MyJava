package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 * 	
 *  Keep first array index as constant and move 2nd array index and get all the combination. 
 *  Do this operation for all index of first array.
 *  When the first array size of permutation is done. Then we can poll for result and and next element one by one. 
 * 
 * 1) It is about doing sum for permutation of number from smallest to largest, since array is sorted.
 * 2) If you think 2 array as 2 rows of matrix with 2 column then sum permutation will be like [0,0] [0,1] [1,0] [1,1] 
 * 3) But the point is Initial permutation has to be done for either of 1 row then only solution will work. 
 * 4) Then we can pop one element and add element in queue.
 * 
 *   So for 4,3 size of 2 arrays. 12 combination of sum is possible. 
 *   Initial combination of sum should have [0,0] [0,1] [0,2] [0,3]
 *    
 * 
 * =====It is not clear how it is working if we pop element(sum) after each offer. But it is mathematically proved=========
 */
public class FindKPairsWithSmallestSums {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
		int num1Size = nums1.length, num2Size = nums2.length;
		List<int[]> res = new ArrayList<int[]>();
		if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k <= 0)
			return res;
		for (int j = 0; j <= num2Size - 1; j++)
			pq.offer(new Tuple(0, j, nums1[0] + nums2[j]));
		// some time k may beyond the permutation sum. Ex: for 3,3 input k=10...Even though we can form only 9 result. For 10 th result we can skip the loop.  
		for (int i = 0; i < Math.min(k, num1Size * num2Size); i++) {
			System.out.println(pq.peek().sum + "[" + pq.peek().num1Index + " " + pq.peek().num2Index + "]");
			Tuple t = pq.poll();
			res.add(new int[] { nums1[t.num1Index], nums2[t.num2Index] });
			if (t.num1Index == num1Size - 1)
				continue;
			pq.offer(new Tuple(t.num1Index + 1, t.num2Index, nums1[t.num1Index + 1] + nums2[t.num2Index]));
		}
		return res;
	}

	public static void main(String[] args) {
		FindKPairsWithSmallestSums f = new FindKPairsWithSmallestSums();
		List<int[]> result = f.kSmallestPairs(new int[] { 1, 7, 11, 16 }, new int[] { 2, 9, 10 }, 10);
	}

	class Tuple implements Comparable<Tuple> {
		int num1Index, num2Index, sum;

		public Tuple(int num1Index, int num2Index, int val) {
			this.num1Index = num1Index;
			this.num2Index = num2Index;
			this.sum = val;
		}

		@Override
		public int compareTo(Tuple that) {
			return this.sum - that.sum;
		}

	}
}
