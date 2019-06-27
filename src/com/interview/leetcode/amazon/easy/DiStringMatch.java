package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/di-string-match

=====The point is about understanding the equation======
If S[i] == "I", then A[i] < A[i+1] --> if index0 is I then, index0 should be less than index1
If S[i] == "D", then A[i] > A[i+1] --> if indexD is D then, index0 should be greater than index1


  So init value of I to 0. Increment I when everytime it found. 
     init value of D to N. Decrement D when everytime it found.
 * 
 */
public class DiStringMatch {
	public int[] diStringMatch(String S) {
		int[] result = new int[S.length() + 1];
		int I = 0;
		int D = S.length();
		int i = 0;
		for (Character c : S.toCharArray()) {
			if ('I' == c) {
				result[i++] = I++;
			} else {
				result[i++] = D--;
			}
		}
		result[i] = I;
		return result;
	}
}
