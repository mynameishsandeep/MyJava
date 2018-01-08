package com.sample.datastructure.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

/*
 * Given an array of integers nums and a positive integer k, 
 * find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 * 
 *  Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
	Output: True
	Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
	
	Brute Force:
	1) Calculate total. target= total/k.
	2) Calculate all permutations(Index of result) of target using groupSum approach. 
	3) Calculate all permutations of index of result with k and total equal to total.
 */
public class PartitionToKEqualSumSubsets {
	public static void main(String[] args) {
		List<List<Integer>> allCombo = new ArrayList<>();
		PartitionToKEqualSumSubsets s = new PartitionToKEqualSumSubsets();
		int k = 4;
		int input[] = new int[] { 4, 3, 2, 3, 5, 2, 1 };
		int n = input.length;
		int arrayTotal = 0;
		for (int i = 0; i < n; i++) {
			arrayTotal = arrayTotal + i;
		}
		int total = IntStream.of(input).sum();

		if (total % k != 0) {
			System.out.println("false");
		} else {
			int target = total / k;
			System.out.println(s.groupSum(0, input, target, 0, allCombo, new ArrayList<Integer>()));
			System.out.println(allCombo);

			System.out.println(s.groupSum(0, allCombo, k, allCombo.size(), arrayTotal, new ArrayList<Integer>()));
		}
	}

	private boolean groupSum(int start, List<List<Integer>> input, int k, int n, int total, List<Integer> result) {
		if (start == n) {
			System.out.println(result);
			if (k == 0 && total == result.stream().mapToInt(Integer::intValue).sum()) {
				Set<Integer> hashSet = new HashSet<>(result);
				if (hashSet.size() == n) {
					System.out.println("Trueeeeee");
					return true;
				}
				return false;
			} else {
				return false;
			}
		}
		Boolean left = groupSum(start + 1, input, k - 1, n, total, copy(result, input.get(start)));
		Boolean right = groupSum(start + 1, input, k, n, total, result);
		return left || right;
	}

	private boolean groupSum(int start, int[] nums, int target, int sum, List<List<Integer>> result,
			List<Integer> curResult) {
		if (target == sum) {
			if (curResult.size() > 0) {
				System.out.println("Hit");
				result.add(curResult);
				curResult = new ArrayList<Integer>();
				System.out.println(result);
			}
		}
		if (start == nums.length) {
			return false;
		}
		Boolean left = groupSum(start + 1, nums, target, sum + nums[start], result, copy(curResult, start));
		Boolean right = groupSum(start + 1, nums, target, sum, result, curResult);
		return left || right;
	}

	private List<Integer> copy(List<Integer> input, List<Integer> data) {
		List<Integer> result = new ArrayList<>();
		result.addAll(input);
		result.addAll(data);
		return result;
	}

	private List<Integer> copy(List<Integer> input, Integer data) {
		List<Integer> result = new ArrayList<>();
		result.addAll(input);
		result.add(data);
		return result;
	}

}