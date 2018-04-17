package com.interview.leetcode.amazon.easy;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * https://leetcode.com/problems/third-maximum-number/description/
 */
public class ThirdMax {

	public int thirdMaxUsingQueue(int[] nums) {
		Queue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		Set<Integer> set = new HashSet<>();
		for (Integer num : nums) {
			if (!set.contains(num)) {
				set.add(num);
				pQ.offer(num);
			}
		}
		if (pQ.size() >= 3) {
			pQ.poll();
			pQ.poll();
		}
		return pQ.poll();
	}

	public int thirdMaxUsingSet(int[] nums) {
		SortedSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
		for (Integer num : nums) {
			set.add(num);
		}
		if (set.size() >= 3) {
			set.remove(set.first());
			set.remove(set.first());
		}
		return set.first();
	}

	public int thirdMaxOrderOfN(int[] nums) {

		Integer m1 = null;
		Integer m2 = null;
		Integer m3 = null;
		for (Integer num : nums) {
			if (num.equals(m1) || num.equals(m2) || num.equals(m2)) {
				continue;
			}
			if (m3 == null || num >= m3) {
				if (m2 == null || num >= m2) {
					if (m1 == null || num >= m1) {
						m3 = m2;
						m2 = m1;
						m1 = num;
					} else {
						m3 = m2;
						m2 = num;
					}
				} else {
					m3 = num;
				}
			}
		}
		if (m3 == null) {
			return m1;
		}
		return m3;

	}

	public static void main(String[] args) {
		ThirdMax t = new ThirdMax();
		System.out.println(t.thirdMaxUsingSet(new int[] { 5, 2, 4, 1, 3, 6, 0 }));
		System.out
				.println(t.thirdMaxOrderOfN(new int[] { -2147483648, -2147483648, -2147483648, -2147483648, 1, 1, 1 }));
	}
}
