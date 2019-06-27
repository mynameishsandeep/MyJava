package com.interview.leetcode.facebook.medium;

/*
=============================Write Logic:=============================
Iteration1:
Keep 2 pointer p1 and p2 one in beginning, and one in last. 
    Compare both sides. 
    If there is mismatch 
        1) count it. Say count1
        2) Increment p1.
    Else
        1) Increment p1. Decrement p2
Iteration2:
Keep 2 pointer p1 and p2 one in beginning, and one in last. 
    Compare both sides. 
    If there is mismatch 
        1) count it. Say count2
        2) Decrement right side.    
    Else
        1) Increment p1. Decrement p2
If (count1 or count2  <= 1 ) return true. 
Meaning I can find palindrome by 0 or 1 deletion of character
==========================================================
=======================Test cases to watch===================================
beeee -- true
abc  -- false
bebb  -- true
eedede -- true

*/

public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
		int p1 = 0;
		int p2 = s.length() - 1;
		int countleftToRight = 0;
		while (p1 < p2) {
			if (s.charAt(p1) == s.charAt(p2)) {
				p1++;
				p2--;
			} else {
				countleftToRight++;
				p1++;
			}
		}

		p1 = 0;
		p2 = s.length() - 1;
		int countRightToLeft = 0;
		while (p1 < p2) {
			if (s.charAt(p1) == s.charAt(p2)) {
				p1++;
				p2--;
			} else {
				countRightToLeft++;
				p2--;
			}
		}
		return countleftToRight <= 1 || countRightToLeft <= 1;
	}
}