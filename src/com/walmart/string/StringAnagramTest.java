package com.walmart.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringAnagramTest {

	// Time Complexity : O(n log n) + O(n log n). 
	// Space Complexity: O(n). Used by Sorting
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

	// Time Complexity : O(n) + O(n). 
	// Space Complexity: O(n)
	
	static boolean isAnagramHash(String input1, String input2) {

		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < input1.length(); i++) {
			Integer val = map.put(input1.charAt(i), 1);
			if (val != null) {
				map.put(input1.charAt(i), val + 1);
			}
		}

		for (int i = 0; i < input2.length(); i++) {
			Integer val = map.get(input2.charAt(i));
			if (val == null) {
				return false;
			} else {
				if (val == 1) {
					map.remove(input2.charAt(i));
				} else {
					map.put(input2.charAt(i), val--);
				}
			}
		}
		return map.size() == 0;
	}

	public static void main(String[] args) {

		//Scanner sc = new Scanner(System.in);
		String A = "a ct";
		String B = "ca t";
		boolean ret = isAnagram(A, B);
		if (ret)
			System.out.println("Anagrams");
		else
			System.out.println("Not Anagrams");

		ret = isAnagramHash(A, B);
		if (ret)
			System.out.println("Anagrams");
		else
			System.out.println("Not Anagrams");

	}
}
