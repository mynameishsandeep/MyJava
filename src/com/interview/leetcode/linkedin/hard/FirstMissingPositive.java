package com.interview.leetcode.linkedin.hard;

/*
 * https://leetcode.com/problems/first-missing-positive/description/
 * 
 * BruteForce: Sort it. Go one by one and check current number is greater then 1 of previous number. n(logn)
 * 
 * Solution 2 parse: O(n)-----Done in 2 iteration---( Iteration1(read and swap element), Iteration2(check current and previous))
 * ==========Note: 0 and less than number are not considered. So nums[0] = 1, nums[1] = 2========
 * So at any place 0 and negative number, ignore it.
 * 1) First missing number should lies with in array, that is the key here.
 * Ex: [0,1,4]... 0 stays in nums[0], 1 stays in nums[0] and 4 I will skip it, by putting -1 at nums[2].
 * Ex: [3,2,1].... Here no data goes beyond the index. Rearrange data by [1,2,3]
 * Ex: [1,0,3]... swap 0 and 1, leave 3 because it is in right index.
 * 2) If the data lies beyond the size of array, skip it.
 * 3) Otherwise "swap" the data at the specific index.  
 * Because Ex:[0,1,2,3,0,5]...swap 1 and 2.
 */
public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length;) {

			if (nums[i] > nums.length) { // If max reached, set it to -1 or 0. Because we ignore 0 and less than that
				nums[i] = -1;
				i++;
				continue;
			}

			if (nums[i] <= 0) { // Ignore 0 and negative number
				i++;
				continue;
			}

			if (nums[i] == i + 1) { // If value at index == index... Ex: nums[0]=1 or nums[1]=2 etcc....
				i++;
				continue;
			}

			if (nums[i] == nums[nums[i] - 1]) {// value at swap is same, skip it. Ex: [1,1] 
				i++;
				continue;
			}

			swap(nums, i, nums[i] - 1);// Swap current number if it is different.

		}

		for (int i = 0; i < nums.length; i++) {
			if (i + 1 != nums[i]) {// Checking for i+1 because value starts from 1 and not 0
				return i + 1;// Returning i+1 because value starts from 1 and not 0
			}
		}

		return nums.length + 1;

	}

	public void swap(int nums[], int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[temp - 1] = temp;
	}

	public static void main(String[] args) {
		FirstMissingPositive f = new FirstMissingPositive();
		System.out.println(f.firstMissingPositive(new int[] { 1, 2, 0 }));
		//System.out.println(f.firstMissingPositive(new int[] { 3,4,-1,1 }));
		//System.out.println(f.firstMissingPositive(new int[] { 1 }));
		//System.out.println(f.firstMissingPositive(new int[] { 1,1 }));
		//System.out.println(f.firstMissingPositive(new int[] { 1, 1, 1, 2, 2 }));
	}

}
