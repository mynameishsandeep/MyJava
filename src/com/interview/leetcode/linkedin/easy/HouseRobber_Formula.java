package com.interview.leetcode.linkedin.easy;

public class HouseRobber_Formula {
	/*
	 * f(n) = Math.max(f(n-2)+f(n),f(n-1))
	 * 
	 * 1) If there are 1 house to rob, then max benefit would be f(n)
	 * 2) If there are 2 house to rob, then max benefit would be Max of "f(n)", "f(n-1)"
	 * 3) If there are 3 house to rob, then max benefit would be Max of "f(n)+f(n-2)", "f(n-1)"... 
	 * 	  Rob "house1 and house3" or "house1" alone. Max benefit is whichever is max 
	 * 
	 * Thats it, code for the formula
	 */
	public int rob(int[] nums) {

		int fN = 0;
		int fNMinus1 = 0;
		int fNMinus2 = 0;
		for (int num : nums) {
			fN = Math.max(fNMinus2 + num, fNMinus1);
			fNMinus2 = fNMinus1;
			fNMinus1 = fN;
		}
		return fN;
	}

	public static void main(String[] args) {
		HouseRobber_Formula h = new HouseRobber_Formula();
		System.out.println(h.rob(new int[] { 100, 10, 20, 100 }));
	}
}
