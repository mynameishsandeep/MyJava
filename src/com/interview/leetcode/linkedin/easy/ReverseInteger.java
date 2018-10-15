package com.interview.leetcode.linkedin.easy;

/*
 * https://leetcode.com/problems/reverse-integer/discuss/4056/Very-Short-(7-lines)-and-Elegant-Solution
 * 
Reversing an integer can be done similarly to reversing a string.

We want to repeatedly "pop" the last digit off of x and "push" 
it to the back of the reverseResult. 

The problem is overflow, which can be handled in many ways look into reverse1 and reverse2 method
 */
public class ReverseInteger {

	public int reverse(int x) {
		int reverseResult = 0;
		while (x != 0) {
			reverseResult = reverseResult * 10 + x % 10;
			x = x / 10;
		}
		return reverseResult;
	}

	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(123));
		System.out.println(r.reverse(596));
	}

	/**
	 * avoid overflow by checking before hand if integer operation
	 */
	public int reverse1(int x) {
		int reverseResult = 0;
		while (x != 0) {
			int pop = x % 10;
			x = x / 10;
			if (reverseResult > Integer.MAX_VALUE / 10 || (reverseResult == Integer.MAX_VALUE / 10 && pop > 7))
				return 0;
			if (reverseResult < Integer.MIN_VALUE / 10 || (reverseResult == Integer.MIN_VALUE / 10 && pop < -8))
				return 0;
			reverseResult = reverseResult * 10 + pop;
		}
		return reverseResult;
	}

	/*
	 * Since input is int and output int.
	 * Avoid overflow by using long. Check if result goes beyond + and - values.
	 * But if the interviewer asks what if input is long and ouptut is long. Then reverse1 logic is needed. 
	 */
	public int reverse2(int x) {
		long reverseResult = 0;
		while (x != 0) {
			reverseResult = reverseResult * 10 + x % 10;
			x = x / 10;
			if (reverseResult > Integer.MAX_VALUE || reverseResult < Integer.MIN_VALUE)
				return 0;
		}
		return (int) reverseResult;
	}
}
