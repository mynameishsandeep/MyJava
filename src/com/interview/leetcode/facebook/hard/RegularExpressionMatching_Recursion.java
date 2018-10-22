package com.interview.leetcode.facebook.hard;

/*
 * https://leetcode.com/problems/regular-expression-matching/
 * 
 * 1) same character on pattern and input
 * 2) . in pattern.
 * 3) * in pattern. 2 cases arrive here
 * 		a) character before *
 * 		b) . before *
 */
public class RegularExpressionMatching_Recursion {
	public boolean isMatch(String s, String p) {

		if (p.length() == 0)
			return s.length() == 0;

		//p's length 1 is special case    
		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
				return false;
			return isMatch(s.substring(1), p.substring(1));

		} else { // 1) a*  2) .*

			int len = s.length();
			int i = -1;
			while (i < len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))) {
				if (isMatch(s.substring(i + 1), p.substring(2)))
					return true;
				i++;
			}
			return false;
		}
	}
}
