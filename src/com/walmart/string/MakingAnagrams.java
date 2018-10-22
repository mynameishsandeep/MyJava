package com.walmart.string;

/*
 * 
 * Given two strings, a and b, that may or may not be of the same length, 
 * determine the minimum number of character deletions required to make a and b anagrams. 
 * Any characters can be deleted from either of the strings.

For example, if a=cde and b=dcf, we can delete e from string a and f from string b,
so that both remaining strings are cd and dc which are anagrams.

Sample Input
cde
abc

Sample Output: 4

======Solution======
1) Increment for string a.
2) Decrement for string b.
3) Take the count of result array. Convert negative to positive by Math.abs.
 */
public class MakingAnagrams {

	static int makeAnagram(String a, String b) {
		int arr[] = new int[26];
		for (int i = 0; i < a.length(); i++) {
			arr[a.charAt(i) - 'a'] = arr[a.charAt(i) - 'a'] + 1;
		}
		for (int i = 0; i < b.length(); i++) {
			arr[b.charAt(i) - 'a'] = arr[b.charAt(i) - 'a'] - 1;
		}
		int resultCount = 0;
		for (int i = 0; i < 26; i++) {
			resultCount += Math.abs(arr[i]);
		}
		return resultCount;

	}
}
