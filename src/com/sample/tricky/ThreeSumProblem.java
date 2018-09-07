package com.sample.tricky;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * https://www.youtube.com/watch?v=jXZDUdHRbhY
 */
public class ThreeSumProblem {

	/*
	 * Print all combinations of 3 sums
	 * Take a number. Do 2Sum for remaining number. 
	 * 
	 * Sorting takes O(log N)
	 * 2 loops in takes O(n^2)
	 * So we can say it takes O(n^2)
	 * 
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		//Take a number. Do 2Sum for remaining number.
		for (int i = 0; i < nums.length; i++) {
			int c = nums[i];
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				if (c + nums[j] + nums[k] < 0) {
					j++;
				} else if (c + nums[j] + nums[k] > 0) {
					k--;
				} else {
					List<Integer> resultItem = new ArrayList<>();
					resultItem.add(c);
					resultItem.add(nums[j]);
					resultItem.add(nums[k]);
					result.add(resultItem);
					k--;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		ThreeSumProblem t = new ThreeSumProblem();
		int[] i = new int[] {-1,0,1,2,-1,-4};
		int[] sortedI = new int[] {-4,-1,-1,0,1,2};
		System.out.println(t.threeSum(sortedI));
	}
}
