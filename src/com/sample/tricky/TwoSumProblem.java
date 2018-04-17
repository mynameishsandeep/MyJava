package com.sample.tricky;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * given an array, find whether there exists 3 elements a,b,c in it such that
 * a+b=c using efficient method.
 * 
 * 
 * @author chandrasekhar
 *
 */
public class TwoSumProblem {
	public static void main(String[] args) {
		Integer a[] = { 2, 7, 8, 10, 5, 8 };
		System.out.println(Arrays.toString(twoSumReturnIndex(a, 12)));
		System.out.println(findSum(a, 11));
		System.out.println(" Find 16 " +findSum(new Integer[] {8,8}, 16));
		System.out.println(findSum(a, 7));
		Integer aa[] = { 3, 2, 4 };
		System.out.println(twoSum(aa, 6));
	}

	/*
	 * O(n) time complexity
	 */
	public static boolean findSum(Integer a[], Integer key) {
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
	 * This is 2 pointer approach.
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
	
	/*
	 * O(n) time complexity
	 */
	public static int[] twoSumReturnIndex(Integer[] nums, int target) {
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
}
