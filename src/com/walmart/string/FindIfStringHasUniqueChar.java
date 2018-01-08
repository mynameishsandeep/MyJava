package com.walmart.string;

public class FindIfStringHasUniqueChar {

	public static void main(String[] args) {
		String input = "aHelo";
		System.out.println(findUniqueStringChar(input));

	}

	public static boolean findUniqueStringChar(String input) {
		int a[] = new int[126];
		char[] c = input.toCharArray();
		for (int i = 0; i < c.length; i++) {
			int charVal = c[i];
			if (a[charVal] == 0) {
				a[charVal] = 1;
			} else {
				return false;
			}
		}
		return true;
	}
}
