package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*

https://leetcode.com/problems/task-scheduler/description/

1) Idea is to add "countsOfEachTasks" to a priority Q and sort based on the highest frequency.
2) Pick the task in each round of 'n' with highest frequency. 
3) As you pick the task, decrease the frequency, and put them back after each round. 	

===The same logic is not applicable for below problem, 
In the below problem, we are not filling empty, rather we say "invalid"... that is 1 key difference========
https://leetcode.com/problems/task-scheduler/discuss/104501/Java-PriorityQueue-solution-Similar-problem-Rearrange-string-K-distance-apart
 */
public class TaskScheduler_PriorityQueueApproach {
	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < tasks.length; i++) {
			map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1); // map key is TaskName, and value is number of times to be executed.
		}

		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		q.addAll(map.values());
		int count = 0;
		while (!q.isEmpty()) {
			int cycle = n + 1;
			List<Integer> pendingTasks = new ArrayList<>();
			while (cycle > 0 && !q.isEmpty()) {
				Integer top = q.poll(); // most frequency task
				pendingTasks.add(top - 1); // collect task to add back to queue
				cycle--;
				count++; //successfully executed task
			}

			for (Integer pendingTask : pendingTasks) {
				if (pendingTask > 0) {
					q.add(pendingTask); // add valid remaining tasks
				}
			}

			if (q.isEmpty())
				break;
			count = count + cycle; // if k > 0, then it means we need to be idle
		}
		return count;
	}

	public static void main(String[] args) {
		TaskScheduler_PriorityQueueApproach t = new TaskScheduler_PriorityQueueApproach();
		//char c[] = { 'A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E', 'F' };
		//String s = "AAAABBBEEFFGG";
		String s = "AAABBB";
		char c[] = s.toCharArray();
		System.out.println(t.leastInterval(c, 2));
	}
}
