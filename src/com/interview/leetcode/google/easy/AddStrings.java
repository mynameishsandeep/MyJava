package com.interview.leetcode.google.easy;

/*
 * https://leetcode.com/problems/add-strings/description/
 * 
 * The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {

	public static void main(String[] args) {
		AddStrings a = new AddStrings();
		System.out.println(a.addStrings("19", "99"));
	}

	public String addStrings(String num1, String num2) {
		char[] num1Char = num1.toCharArray();
		char[] num2Char = num2.toCharArray();

		int i = num1Char.length - 1;
		int j = num2Char.length - 1;

		StringBuilder sumString = new StringBuilder();
		int carry = 0;

		while (i >= 0 || j >= 0) {
			int d1 = 0;
			int d2 = 0;

			if (i >= 0)
				d1 = num1Char[i--] - '0';
			if (j >= 0)
				d2 = num2Char[j--] - '0';

			int sum = d1 + d2 + carry;
			if (sum >= 10) {
				carry = 1;
				sum = sum % 10;
			} else
				carry = 0;

			sumString.insert(0, sum);
		}
		if (carry == 1) {
			sumString.insert(0, carry);
		}
		return sumString.toString();
	}
}
