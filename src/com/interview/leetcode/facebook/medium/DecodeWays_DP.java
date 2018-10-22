package com.interview.leetcode.facebook.medium;

/*
 * 
 * Look into the tree structure "DecodeWays_DP.jpg" in US Problems
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
 * ===Note: fill dp array by reading string from  last (n-1 to 1) =======
 * Because : 
 * Ex: 10... Left to Right will give answer 2. 
 * Right answer is 1. Which can we can only by coming from last
 * ========
 *  For 10 below is the matrix
 *  1 1 0
 *  1 1 1
 *  
 *  For 11 below is the matrix
 *  1 1 0
 *  1 1 2
 *  
 * ====
 */
public class DecodeWays_DP {
	public int numDecodings(String s) {
		if (s == null || s.length() == 0 || s.charAt(0) == '0') {
			return 0;
		}
		int current = 0;
		int previous = 1;
		int previousPrevious = 1;
		for (int i = 2; i < s.length(); i++) { // Just think of input 10
			if (s.charAt(i - 1) == '0') { // if 0 nothing 
			} else { // Look for 1 to 9. copy previous
				current = previous;
			}
			int twoDigit = Integer.valueOf(s.substring(i - 1, i + 1));
			if (twoDigit >= 10 && twoDigit <= 26) {
				current = current + previousPrevious; // if >=10 && <= 26. add current and previous.previous
			}
			previousPrevious = previous;
			previous = current;
			current = 0;
		}
		return previous;

	}

	public static void main(String[] args) {
		DecodeWays_DP d = new DecodeWays_DP();
		System.out.println(d.numDecodings("1234")); // [1234] [12,3,4][1,23,4]
		//System.out.println(d.numDecodings("10"));
		//System.out.println(d.numDecodings("10"));
	}
}
