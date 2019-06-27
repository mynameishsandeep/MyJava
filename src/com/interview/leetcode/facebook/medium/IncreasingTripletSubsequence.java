package com.interview.leetcode.facebook.medium;

/*
 * https://leetcode.com/problems/increasing-triplet-subsequence/description/
 * 
 * 1) first update small number. 
 * 2) then middle number.
 * 3) then big number. 
 */
public class IncreasingTripletSubsequence {

	public boolean increasingTriplet(int[] nums) {
		int smallNumber = Integer.MAX_VALUE, middleNumber = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= smallNumber) {
				smallNumber = n;
			} else if (n <= middleNumber) {
				middleNumber = n;
			} else {
				return true;
			}
		}
		return false;
	}
}
