package com.sample.tricky;

public class RomanToInteger {

	public static void main(String[] args) {
		System.out.println(intToRoman(43));

	}

	public static String intToRoman(int num) {
		String M[] = { "", "M", "MM", "MMM", "MMMM", "V`", "V`M", "V`MM", "V`MMM", "V`MMMM" };
		String C[] = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String X[] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String I[] = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
		return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
	}

}
