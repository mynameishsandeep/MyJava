package com.sample.tricky;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * given an array, find whether there exists 3 elements a,b,c in it such that
 * a+b=c using efficient method.
 * 1) If the question is simply 2 sum problem without any constraint. Implement using Set.
 * 2) Then interviewer might ask to get index. Then use Map approach.
 * 3) Then interviewer might ask without using variable. Then go for sort and 2 pointer approach.
 * 
 * Note: If the interviewer says duplicate element can present, then set and map options cannot be used.
 */
public class TwoSumProblem {
	public static void main(String[] args) {
		Integer a[] = { 2, 7, 8, 10, 5, 8 };
		System.out.println(Arrays.toString(twoSumReturnIndexUsingMap(a, 12)));
		System.out.println(twoSumUsingSet(a, 11));
		System.out.println(" Find 16 " +twoSumUsingSet(new Integer[] {8,8}, 16));
		System.out.println(twoSumUsingSet(a, 7));
		Integer aa[] = { 3, 2, 4 };
		System.out.println(twoSum(aa, 6));
	}

	/*
	 * O(n) time complexity
	 * out of 2 elements. keep 1 in current variable and another 1 in Set.
	 */
	public static boolean twoSumUsingSet(Integer a[], Integer key) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			if (set.contains(key - a[i])) {
				return true;
			} else {
				set.add(a[i]);
			}
		}
		return false;
	}

	/*
	 * O(n) time complexity
	 * out of 2 elements. keep 1 in current variable and another 1 in map.
	 * map helps in saving and getting index.
	 */
	public static int[] twoSumReturnIndexUsingMap(Integer[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target-nums[i])) {
                return new int[] {map.get(target-nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

	/*
	 * This is 2 pointer approach. Without using additional variable.
	 * 
	 * O(log N) complexity. due to sorting
	 * 
	 * Below approach will not work if we need to return index. Because sorting
	 * take out index. Only HashMap version is better.
	 */
	public static int[] twoSum(Integer[] nums, int target) {
		Arrays.sort(nums);
		for (int i = 0, j = nums.length - 1; i < nums.length / 2;) {
			if (nums[i] + nums[j] > target) {
				j--;
			} else if (nums[i] + nums[j] < target) {
				i++;
			} else if (nums[i] + nums[j] == target) {
				return new int[] { i, j };
			}
		}
		return null;

	}
	
}
