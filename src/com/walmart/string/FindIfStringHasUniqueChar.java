package com.walmart.string;

public class FindIfStringHasUniqueChar {

	public static void main(String[] args) {
		String input = "aHello";
		System.out.println(findUniqueStringChar(input));
		input = "aHelo";
		System.out.println(findUniqueStringChar(input));

	}

	public static boolean findUniqueStringChar(String input) {
		// ASCII has 0 to 127 character...So initializing with 128.
		// To save only a-z... go for a[charVal]-'a'
		// To save only A-Z... go for a[charVal]-'A'

		int a[] = new int[128];
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
