package com.interview.leetcode.google.hard;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringKDistanceApart2 {
	public String rearrangeString(String str, int k) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : str.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1); // char freq
		}
		Queue<Map.Entry<Character, Integer>> q = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue()); // PriorityQueue, order by freq
		q.addAll(map.entrySet());
		StringBuilder sb = new StringBuilder();
		List<Map.Entry<Character, Integer>> waitList = new LinkedList();
		while (!q.isEmpty()) { // q hold all currently available (ch, freq) pairs, all non-valid ones r in waitList
			Map.Entry<Character, Integer> entry = q.poll();
			char ch = entry.getKey();
			int freq = entry.getValue();
			sb.append(ch); // append to result
			entry.setValue(freq - 1);
			waitList.add(entry);
			if (sb.length() >= k) { // passed intial k chars, waitList full, start to release // passed in
				Map.Entry<Character, Integer> front = waitList.remove(0); // release 1st (char, freq) from waitlist and add back to pq if freq still > 0
				if (front.getValue() > 0)
					q.offer(front); // released ch might not be available any more (all freq used up)
			}
		}
		System.out.println(sb.toString());
		return (sb.length() == str.length()) ? sb.toString() : ""; // (ch, freq) stuck in waitList
	}

	public static void main(String[] args) {
		RearrangeStringKDistanceApart2 r = new RearrangeStringKDistanceApart2();
		System.out.println(r.rearrangeString("aaaabbbbccccdddd", 3));
	}
}
