package com.sample.tricky;

/*
 * https://leetcode.com/problems/integer-to-roman/description/
 * 
 * Remember 1 4 5 9 from left till 1000...
 */
public class IntegerToRoman {

	public static void main(String[] args) {
		IntegerToRoman i = new IntegerToRoman();
		System.out.println(i.intToRoman(43));
		System.out.println(i.intToRoman(66));

	}

	public String intToRoman(int num) {
		int numbers[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		String romanNumbers[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < numbers.length; i++) {
			while (true) {
				if (num >= numbers[i]) {
					result.append(romanNumbers[i]);
					num -= numbers[i];
				} else {
					break;
				}
			}
		}
		return result.toString();
	}
}
