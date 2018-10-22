package com.interview.leetcode.facebook.medium;

/*
 * Look into the tree structure "DecodeWays_Recursion.jpg" in US Problems 
 * 
 * 1) Single character match ( 1 to 9)
 * 2) Two character match (10 to 26)
 * 3) If there is a zero in the beginning, then result 0. Because 0 cannot be used with any next combination of digits.
 * 4) 0 in the middle can("1201") or cannot(301) be used to get result count 
 * 4) For Empty String "". result is 0. 
 * 
 * 
 * 1201 --> [1,20,1] // only 1 result count
 * 0121 --> 0 count
 * 301 --> 0 count
 * 
 * 
 */
public class DecodeWays_Recursion {
	int numDecodings(String s) {
		return s.length() == 0 ? 0 : numDecodings(0, s);
	}

	int numDecodings(int currentIndex, String input) {
		if (currentIndex == input.length()) {
			return 1;
		}

		int left = 0;
		if (input.charAt(currentIndex) == '0') { // If there is a "zero" ignore it.
			return 0;
		} else {
			left = numDecodings(currentIndex + 1, input);
		}

		int right = 0;
		if (currentIndex < input.length() - 1) { // To make Sure, 2 digits can be formed
			int firstAndSecondDigit = Integer.valueOf(input.substring(currentIndex, currentIndex + 2));
			if (firstAndSecondDigit >= 10 && firstAndSecondDigit <= 26) {
				right = numDecodings(currentIndex + 2, input);
			}
		}
		return left + right;
	}

	public static void main(String[] args) {
		DecodeWays_Recursion d = new DecodeWays_Recursion();
		System.out.println(d.numDecodings("1234")); // [1234] [12,3,4][1,23,4] 
	}
}
