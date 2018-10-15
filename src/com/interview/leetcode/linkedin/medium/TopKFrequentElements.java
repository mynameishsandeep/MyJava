package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/top-k-frequent-elements/description/
 */
public class TopKFrequentElements {
	public class Pair implements Comparable<Pair> {
		public Integer number;
		public Integer frequent;

		public Pair(Integer frequent, Integer number) {
			this.number = number;
			this.frequent = frequent;
		}

		public int compareTo(Pair p) {
			return p.frequent - this.frequent;
		}

	}

	public List<Integer> topKFrequent(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		//System.out.println(map);
		Queue<Pair> q = new PriorityQueue<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			q.offer(new Pair(entry.getValue(), entry.getKey()));
			if (q.size() > k) {// optimization
				q.remove(k - 1);
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			result.add(q.poll().number);
		}
		return result;
	}
}
