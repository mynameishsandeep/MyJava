package com.interview.leetcode.facebook.hard;

/*
 * https://leetcode.com/problems/regular-expression-matching/
 * 
		'.' Matches any single character.
		'*' Matches zero or more of the preceding element.
 * 
 * https://www.youtube.com/watch?v=l3hda49XcDE
 * ================
 * Here the subproblem is taking a single character and doing pattern match for each of pattern character. 
 * 
 * Rule 1 : if patternChar == currentChar or . then dp[i][j] = T for "current pattern" with "current input char"
 * But it also depends on previous value. If previous value if F then it is false. If previous value is T then it is true.
 * Get the the previous from dp[i-1][j-1]. It should be for "previous input char(i-1)" with "previous pattern(j-1)" 
 * Previous can also be dp[i][j-1] or dp[i-1][j]. But it should not satisfy "previous input char(i-1)" with "previous pattern(j-1)".
 * 
 * Rule 2: if patternChar == *. it is 0 or more of previousChar. 
 * So check char before  
 * 
 * 
 * ===========
 	Ex: p=xa*b.c
 		s=xaabyc
 		
 		0   1 2 3 4 5 6
 	 	    x a * b . c
   0    T|| F F F F F F
   ======||============
   1 x  F|| T F T F F F
   2 a  F|| F T T F F F
   3 a  F||
   4 b  F||
   5 y  F||
   6 c	F||
 	=============
 	x as s and x      as p = T   
 	x as s and xa     as p = F
 	x as s and xa*    as p = T 
 	x as s and xa*b   as p = F
 	x as s and xa*b.  as p = F
 	x as s and xa*b.c as p = F
 	==============
 	xa as s and x      as p = F 
 	xa as s and xa     as p = T
 	xa as s and xa*    as p = T
 	xa as s and xa*b   as p = F
 	xa as s and xa*b.  as p = F
 	xa as s and xa*b.c as p = F
 	================
 	
 	Rule 1 : if patternChar == currentChar or . then dp[i][j] = T ==> get value from diagonal
 	Rule 2 : if patternChar == * then check previousPatternChar is "." or same as currentChar
 				Then dp[i][j] =
 				
 	s = xaaaaaab; p = xa*b			 
 */
public class RegularExpressionMatching_DP {

	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		//Deals with patterns like a* or a*b* or a*b*c*
		for (int i = 1; i < dp[0].length; i++) {
			if (p.charAt(i - 1) == '*') {
				dp[0][i] = dp[0][i - 2];
			}
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				char currentPatternChar = p.charAt(j - 1);
				char currentInputChar = s.charAt(i - 1);
				if (currentPatternChar == '.' || currentPatternChar == currentInputChar) {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (currentPatternChar == '*') {
					char previousPreviousPatternChar = p.charAt(j - 2);
					if (previousPreviousPatternChar == '.' || previousPreviousPatternChar == currentInputChar) {
						dp[i][j] = dp[i][j - 2] || dp[i - 1][j];
					} else {
						dp[i][j] = dp[i][j - 2];
					}
				} else {
					dp[i][j] = false;
				}
			}
		}
		return dp[s.length()][p.length()];
	}
}