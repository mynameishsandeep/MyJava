package com.walmart.string;

import java.util.Arrays;
import java.util.Scanner;

public class StringAnagramTest {

	static boolean isAnagram(String input1, String input2) {

		if (input1.length() != input2.length())
			return false;

    	char data[] = input1.toCharArray();
		Arrays.sort(data);
		input1 = new String(data);
		
		data = input2.toCharArray();
		Arrays.sort(data);
		input2 = new String(data);
		
		return input1.equals(input2);

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
