package com.interview.leetcode.amazon.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/k-diff-pairs-in-an-array/description/ 
 */
public class KDiffPairsInAnArray {
	/*
	 * Note: This is an updated Two Sum 2Pointer Approach. In Two-sum problem we find only 1 result. 
	 * Here there will be more than one combination output. 
	 * 
	 * 1) Keep 2 pointers start to 0 and end to n-1.
	 * 2) if (end data - start data == key) -> 1 occurrence found. Increment start pointer. Move end to n-1.
	 * 3) if (end data - start data) > key)... decrement end pointer
	 * 4) Else Increment start pointer. Move end to n-1.
	 * 
	 * Run Time Performance = n! = n*n-1*n-2*....
	 * 
	 */
	public int findPairsUsingTwoSum2PointerApproach(int[] nums, int k) {
		int start = 0;
		int end = nums.length - 1;
		Map<Integer, Integer> uniqueMap = new HashMap<>();
		Arrays.sort(nums);
		while (start < end) {
			System.out.println(nums[start] + " " + nums[end]);
			if (nums[end] - nums[start] == k) {
				uniqueMap.put(nums[start], nums[end]);
				start++;
				end = nums.length - 1;
			} else if ((nums[end] - nums[start]) > k) {
				// Below if is for corner test case on problem
				if (start == end - 1) {
					start++;
					end = nums.length - 1;
				} else {
					end--;
				}
			} else {
				start++;
				end = nums.length - 1;
			}
		}
		return uniqueMap.size();
	}

	private int findPairsZeroCase(int[] nums, int k) {
		Integer count = 0;
		Map<Integer, Integer> s1 = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			Integer d = s1.get(nums[i]);
			if (d == null) {
				s1.put(nums[i], 1);
			} else {
				s1.put(nums[i], 2);
			}
		}
		for (Map.Entry<Integer, Integer> m : s1.entrySet()) {
			if (m.getValue() == 2) {
				count++;
			}
		}

		return count;
	}

	/*
	 * Put all numbers n in Hashset S1.
	Put all numbers n+k in HashSet S2.
	The number of pairs are the intersection of the two Hashsets. Different conditions apply to k=0 or k<0.
	 */
	public int findPairs(int[] nums, int k) {
		Integer count = 0;
		if (k == 0) {
			return findPairsZeroCase(nums, k);
		}
		Set<Integer> s1 = new HashSet<>();
		for (Integer num : nums) {
			s1.add(num);
		}
		Set<Integer> s2 = new HashSet<>();
		for (Integer num : nums) {
			s2.add(num + k);
		}
		for (Integer d : s1) {
			if (s2.contains(d)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		KDiffPairsInAnArray k = new KDiffPairsInAnArray();
		int i[] = new int[] { 3, 1, 4, 1, 5 };
		System.out.println(k.findPairs(i, 0));
	}
}
