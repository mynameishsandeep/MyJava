package com.interview.leetcode.google.medium;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*

https://leetcode.com/problems/task-scheduler/description/
=======this question is more about passing number of test cases==============
An interval(n) where specific task can be done.
If the tasks is repeating, then idle time is required. 

["A","A","A","B","B","B"], n = 2---> ABi ABi AB
Result = 8

["A","A","A","B","B","B"], n = 3--->ABii ABii AB
Result = 10


["A","B","C","D","E","A","B","C","D","E"], n = 4 --> ABCD EABC CD
Result = 10;


 */
public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> map = new ConcurrentHashMap<>();
		for (Character task : tasks) {
			if (map.containsKey(task)) {
				map.put(task, map.get(task) + 1);
			} else {
				map.put(task, 1);
			}
		}
		int resultCount = 0;
		System.out.println(map);
		while (map.size() > 0) {
			int count = 0;
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				if (entry.getValue() == 1) {
					map.remove(entry.getKey());
				} else {
					map.put(entry.getKey(), entry.getValue() - 1);
				}
				count++;
				if (count == n) {
					break;
				}
			}

			resultCount += count + 1;
			System.out.println(map + " " + resultCount);
		}
		return resultCount - 1;
	}

	public static void main(String[] args) {
		TaskScheduler t = new TaskScheduler();
		char c[] = { 'A', 'A', 'A', 'B', 'B', 'B' };
		t.leastInterval(c, 2);
	}
}
