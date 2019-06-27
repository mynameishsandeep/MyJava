package com.interview.leetcode.google.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/rearrange-string-k-distance-apart/description/
 * 
 * This program fails 2 test cases. 
 * Mostly it is because of sorting happening at priorityqueue.
 * 
 * When poll happens on priority queue. Sorting happens again. It changes the order of same priority of data. 
 * That is the reason priorityqueue comparator does differently in below code
 */
public class RearrangeStringKDistanceApart {
	public String rearrangeString(String s, int k) {
		Map<Character, Integer> map = new HashMap<>();
		if (k == 0) {
			return s;
		}

		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1); // map key is TaskName, and value is number of times to be executed.
		}
		Queue<Map.Entry<Character, Integer>> q = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		q.addAll(map.entrySet());

		StringBuilder result = new StringBuilder();
		int count = 0;
		System.out.println(map);
		while (!q.isEmpty()) {
			int kk = k;
			List<Map.Entry> tempList = new ArrayList<>();

			while (kk > 0 && !q.isEmpty()) {
				Map.Entry<Character, Integer> top = q.poll(); // most frequency task
				top.setValue(top.getValue() - 1); // decrease frequency, meaning it got executed
				result.append(top.getKey());
				tempList.add(top); // collect task to add back to queue
				count++;
				kk--;
			}

			for (int i=tempList.size()-1; i>= 0; i--) {
				Map.Entry<Character, Integer> e = tempList.get(i); 
				if (e.getValue() > 0)
					q.add(e); // add valid tasks 
			}

			if (q.isEmpty())
				break;
			count = count + kk;
		}
		return count == s.length() ? result.toString() : "";
	}

	public static void main(String[] args) {
		RearrangeStringKDistanceApart r = new RearrangeStringKDistanceApart();
		System.out.println(r.rearrangeString("aaaabbbbccccdddd", 4));
	}
}
