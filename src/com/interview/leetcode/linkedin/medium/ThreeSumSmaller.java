package com.interview.leetcode.linkedin.medium;

import java.util.Arrays;

/*
 * Keep an idle index value and do the 2 sum for the rest of numbers 
 * 
 * 2 points to note:
 * 1) num2Index = num1Index+1
 * 2) count is not simply count++.... count = num3Index - num2Index (to say numbers between left and right are lesser too...) 
 * Ex: 
 * 
 * -2 0 1 3
 * 
 * -2 0 3 
 * -2 0 1 -> since we are going up this will be skipped. To get this result --> right-left(meaning everything from left to right are lesser)
 * -2 1 3
 * 
 * We cannot break the loop after right-left, because still -2 1 3 combo exists. 
 */
public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		int count = 0;
		for (int num1Index = 0; num1Index < nums.length - 2; num1Index++) {
			num1 = nums[num1Index];
			for (int num2Index = num1Index + 1, num3Index = nums.length - 1; num2Index < num3Index;) {
				num2 = nums[num2Index];
				num3 = nums[num3Index];
				if (num1 + num2 + num3 < target) {
					count = num3Index - num2Index;
					num2Index++;
				} else { // equal or greater
					num3Index--;
				}

			}
		}
		return count;

	}

	public static void main(String[] args) {
		ThreeSumSmaller t = new ThreeSumSmaller();
		//System.out.println(t.threeSumSmaller(new int[] { -2, 1, -1, 2 }, -2));
		//System.out.println(t.threeSumSmaller(new int[] {-1,1,-1,-1 }, -1)); // result should be 1
		System.out.println(t.threeSumSmaller(new int[] { 3, 1, 0, -2 }, 4)); // result should be 3
		//System.out.println(t.threeSumSmaller(new int[] { -2,0,1,3 }, 2)); // result should be 2

	}
}
