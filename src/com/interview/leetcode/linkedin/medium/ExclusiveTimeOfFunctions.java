package com.interview.leetcode.linkedin.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * https://leetcode.com/problems/exclusive-time-of-functions/description/
 * 
testcase xxx: ["0:start:0","0:end:0","1:start:1","1:end:1","2:start:2","2:end:2","2:start:3","2:end:3"]
 */
public class ExclusiveTimeOfFunctions {
	public static void main(String[] args) {
		ExclusiveTimeOfFunctions e = new ExclusiveTimeOfFunctions();
		List<String> logs = new ArrayList<>();
		logs.add("0:start:0");
		logs.add("1:start:2");
		logs.add("1:end:5");
		logs.add("0:end:6");

		e.exclusiveTime(2, logs);
	}

	/*
	 * 1) During the start 
		 a) Update the previous function time.
		 b) Keep current time in temp(previousTime)
	 * 2) During the end
	   	 a) 
	 */
	public int[] exclusiveTime(int n, List<String> logs) {
		Deque<Integer> stack = new ArrayDeque<>();
		int[] result = new int[n];
		String[] log = logs.get(0).split(":");
		stack.push(Integer.parseInt(log[0]));
		int previousTime = Integer.parseInt(log[2]);
		for (int i = 1; i < logs.size(); i++) {
			log = logs.get(i).split(":");
			int currentTime = Integer.parseInt(log[2]);
			if (log[1].equals("start")) {
				if (!stack.isEmpty()) {
					result[stack.peek()] += currentTime - previousTime;
				}
				stack.push(Integer.parseInt(log[0]));
				previousTime = currentTime;
			} else {
				result[stack.pop()] += currentTime - previousTime + 1;
				previousTime = currentTime + 1;
			}

		}
		return result;
	}
}
