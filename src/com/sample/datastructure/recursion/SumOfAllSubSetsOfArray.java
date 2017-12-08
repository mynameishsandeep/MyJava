package com.sample.datastructure.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Given an array of integers, print sums of all subsets in it.
 * There are total 2n subsets. For every element, we consider two choices, 
 * we include it in a subset and we don’t include it in a subset.
 * 
 */
public class SumOfAllSubSetsOfArray {
	public static void main(String[] args) {
		Integer input[] = { 2, 3 };
		splitArray(input);
		Integer input1[] = { 2, 4, 5 };
		splitArray(input1);
	}

	public static void splitArray(Integer[] nums) {
		List<Integer> result = new ArrayList<>();
		calculateSumOfSubArray(nums, 0, 0, result);
		Collections.sort(result);
		System.out.println(result);
	}

	private static void calculateSumOfSubArray(Integer[] nums, Integer sum, int index, List<Integer> result) {
		if (index >= nums.length) {
			result.add(sum);
			return;
		}
		calculateSumOfSubArray(nums, sum + nums[index], index + 1, result);
		calculateSumOfSubArray(nums, sum, index + 1, result);
	}

}
