package com.walmart.string;

import java.util.HashSet;
import java.util.Set;

public class FindTheFirstRepeatedCharacterInAString {
	public static void main(String[] args) {
		String input = "This is a test";
		System.out.println("Duplicate Found for the character " + findRepeatUsingArray(input));
		System.out.println("Duplicate Found for the character " + findRepeatUsingHash(input));
	}
	
	private static Character findRepeatUsingArray(final String input) {
		// ASCII has 0 to 127 character...So initializing with 128.
		// To save only a-z... go for a[charVal]-'a'
		// To save only A-Z... go for a[charVal]-'A'
		Character ch[] = new Character[128];
		for (Character c : input.toCharArray()) {
			if (ch[c] == null) {
				ch[c] = 1;
			} else {
				return c;
			}
		}
		return null;
	}
	
	private static Character findRepeatUsingHash(final String input) {
		Set<Character> set = new HashSet<>(256);
		for (Character c : input.toCharArray()) {
			if(!set.add(c)) {
				return c;
			}
		}
		return null;
	}

}
