package com.interview.leetcode.facebook.medium;

/*
 * ========================Wrong Logic:==============
Go to the middle of string. 
Take 2 pointers p1, p2. 
Move both pointer to middle for odd character word. or move p1 to n/2-1 and p2 to n/2.
Move both pointer and check if both side characters are same. 
At anypoint 1 time I can adjust, if characters on 2 pointer doesn't match
2nd time false.
Note: Only in case of even size word, I can delete 1 char and make it work.
In case of odd, if I delete a char, then it will not balance. 
It will balance only when all characters are same
========================================================
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
		int count1 = 0;
		while (p1 < p2) {
			if (s.charAt(p1) == s.charAt(p2)) {
				p1++;
				p2--;
			} else {
				count1++;
				p1++;
			}
		}

		p1 = 0;
		p2 = s.length() - 1;
		int count2 = 0;
		while (p1 < p2) {
			if (s.charAt(p1) == s.charAt(p2)) {
				p1++;
				p2--;
			} else {
				count2++;
				p2--;
			}
		}
		return count1 <= 1 || count2 <= 1;
	}
}