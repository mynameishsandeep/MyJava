package com.sample.basics;

/*
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/
 * 
 * To print -11 decimal as -b in hexadecimal 
 * 
 * If Number is negative, we need to remove two's complement which Java does for negative numbers.
 * Mark it as negative number. Then do two's complement.
 * So that number will be transformed to -b without 2's complement.
 * 
 */
public class DecimalToHexaDecimal2 {

	public String toHex(int num) {
		if (num == 0) {
			return "0";
		}
		StringBuilder result = new StringBuilder();
		boolean negative = false;
		if (num < 0) {
			negative = true;
			num = num ^ -1;
			num = num + 1;
		}
		while (num != 0) {
			int current = num & 15;
			result.append(toHexString(current));// Integer.toHexString(current);
			num = num >>> 4;
		}
		if (negative) {
			result.append("-");
		}
		return result.reverse().toString();
	}

	public static void main(String[] args) {
		DecimalToHexaDecimal2 d = new DecimalToHexaDecimal2();
		System.out.println(d.toHex(-1));
		System.out.println(d.toHex(-11));
		System.out.println(d.toHex(11));
	}

	private String toHexString(int data) {
		if (data < 10) {
			return data + "";
		}
		switch (data) {
		case 10:
			return "a";
		case 11:
			return "b";
		case 12:
			return "c";
		case 13:
			return "d";
		case 14:
			return "e";
		case 15:
			return "f";
		default:
			return "";
		}
	}
}
