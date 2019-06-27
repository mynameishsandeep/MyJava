package com.sample.tricky;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/climbing-stairs/description/
 * 
 * https://www.geeksforgeeks.org/count-ways-reach-nth-stair/

 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * On analyzing the result, solution is based on Fibonacci Series 
 * 
 */
public class ClimbingStairs {

	static Map<Integer, Integer> cache = new HashMap<>();
    public int climbStairs(int n) {
        if (n <= 2) {// Exit Condition
			return n;
		} else {
			if (cache.containsKey(n)) {
				return cache.get(n);
			} else {
				// Recursive case
				Integer result = climbStairs(n - 1) + climbStairs(n - 2);
				cache.put(n, result);
				
				return result;
			}
		}
    }
    
	private int fib2Steps(int n, Map<Integer, Integer> map) {
		if (n <= 1) {
			return n;
		}
		if (map.containsKey(n)) {
			return map.get(n);
		}
		Integer fNMinus1 = fib2Steps(n - 1, map);
		map.put(n - 1, fNMinus1);
		Integer fNMinus2 = fib2Steps(n - 2, map);
		map.put(n - 2, fNMinus2);
		return fNMinus1 + fNMinus2;

	}

	/*
	 * Example: if number of step is 3. I can code below.
	 * f(n) = f{ (n-1) + (n-2) + (n-3) }
	 * 
	 * But to generalize to any steps. for loop is best approach.
	 * So inside the for loop. i value is passed (like n-i instead of n-1) result is accumulated.
	 * Note: loop should start from 1 and ends till <=n
	 */
	private int fibXSteps(int n, Map<Integer, Integer> map, int numberOfSteps) {
		if (n <= 1) {
			return n;
		}
		int result = 0;
		if (map.containsKey(n)) {
			return map.get(n);
		}
		for (int i = 1; i <= numberOfSteps; i++) {
			Integer currentResult = fibXSteps(n - i, map, numberOfSteps);
			map.put(n - i, currentResult);
			result += currentResult;
		}
		return result;
	}

	public static void main(String[] args) {
		ClimbingStairs c = new ClimbingStairs();
		System.out.println(c.fib2Steps(6, new HashMap<>()));
		System.out.println(c.fibXSteps(6, new HashMap<>(), 2));
	}

}
