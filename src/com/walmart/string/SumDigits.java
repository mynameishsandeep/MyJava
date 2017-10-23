package com.walmart.string;

public class SumDigits {

	public static void main(String[] args) {
		System.out.println(new SumDigits().sumDigits(123));
	}

	int result = 0;

	public int sumDigits(int n) {
		if (n < 10) {
			return n;
		}
		String s = String.valueOf(n);
		return sumDigits(Integer.valueOf(s.substring(1, s.length()))) + Integer.valueOf(s.substring(0, 1));
	}

}
