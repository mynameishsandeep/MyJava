package com.sample.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringAnagramTest {

	static boolean isAnagram(String A, String B) {

		if (A.length() != B.length())
			return false;
		A = A.toUpperCase();
		B = B.toUpperCase();
		List<Character> charListA = new ArrayList<>();
		for (int i = 0; i < A.length(); i++) {
			charListA.add(A.charAt(i));
		}
		List<Character> charListB = new ArrayList<>();
		for (int i = 0; i < B.length(); i++) {
			charListB.add(B.charAt(i));
		}
		Collections.sort(charListA);
		Collections.sort(charListB);
		int i = 0;
		for (char char1 : charListA) {
			if (char1 != charListB.get(i++)) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		String B = sc.next();
		boolean ret = isAnagram(A, B);
		if (ret)
			System.out.println("Anagrams");
		else
			System.out.println("Not Anagrams");

	}
}
