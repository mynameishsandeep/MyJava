package com.interview.leetcode.facebook.easy;
/*
1) Reverse the number and check it is equal to the original number.
2) Reverse has 2 logic 
    a) multiply by 10 + mod by 10 
    b) divide the number by 10. 

x = 121 |||| reverseNumber(0    + 121%10) = 1
x = 12  |||| reverseNumber(1*10 + 12 %10) = 12
x = 1   |||| reverseNumber(12*10+ 1%10)   = 121

1) For the negative number reverse number is 0.
2) -0 cannot come as input. So this logic will work.


*/

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		return reverseNumber(x) == x;
	}

	private int reverseNumber(int x) {
		int reverseNumber = 0;
		while (x > 0) {
			reverseNumber = reverseNumber * 10 + (x % 10);
			//System.out.println(reverseNumber);
			x /= 10;
		}
		return reverseNumber;
	}
}
