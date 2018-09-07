package com.walmart.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find the smallest window in a string containing all characters of another string
 * 
 * http://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
 * 
 * 1) Iterate input by Character. 
 * 2) If a character matches key, put it on subStringSet and note start index.
 * 3) If the subStringSet size == key length... Then 1 output formed. Put it on result array
 * 4) For Each subsequent matching character key. Form the output and put in on result array
 * 5) The smallest of array is the result.
 * 
 *  Note: This solution will not work for keys with duplicate. 
 *  Example. Find 'tist' on "this is a test string". It will look only tis
 */
public class FindSmallestWindowOfSubString_ContainingAllCharactersOfAnotherString {
	public static void main(String[] args) {
		FindSmallestWindowOfSubString_ContainingAllCharactersOfAnotherString f = new FindSmallestWindowOfSubString_ContainingAllCharactersOfAnotherString();
		Set<Character> set = new HashSet<>();
		set.add('o');
		set.add('r');
		set.add('k');
		System.out.println(f.pangram("geeksforgeeks", set));
		System.out.println(f.pangram("geeksforgeeksork", set));
		set.clear();
		set.add('t');
		set.add('i');
		set.add('s');
		set.add('t');
		System.out.println(f.pangram("this is a test string", set));

	}

	private Integer fillStartIndex(Integer startIndex, Integer currentIndex) {
		if (null == startIndex) {
			return currentIndex;
		}
		return startIndex;
	}

	public String pangram(final String input, final Set<Character> key) {
		List<String> allResult = new ArrayList<>();
		String finalResult = null;
		Set<Character> subStringSet = new HashSet<>();
		Integer startIndex = null;
		for (int i = 0; i < input.length(); i++) {
			if (key.contains(input.charAt(i))) {
				startIndex = fillStartIndex(startIndex, i);
				subStringSet.add(input.charAt(i));
				if (verifySubStringFilled(subStringSet, key.size())) {
					String result = input.substring(startIndex, i);
					if (finalResult == null || finalResult.length() > result.length()) {
						finalResult = result;
					}
					allResult.add(result);
				}
			}
		}
		System.out.println(allResult.toString());
		return finalResult;
	}

	private Boolean verifySubStringFilled(final Set<Character> subStringSet, Integer keyLength) {
		return subStringSet.size() == keyLength;
	}
}