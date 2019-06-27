package com.interview.leetcode.facebook.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * 
 * 1) Form a successful window.
 * 2) Once a window is formed. A next character at right side, should be same left character. That is the key
 * in window. 
 * 
 * Note1: Moving leftIndex and rightIndex
 * 1) Keep leftIndex and rightIndex at 0.
 * 2) Move rightIndex alone, till first window.
 * 3) Move leftIndex and rightIndex after first window reached.
 * 
 * Note2:How to update map and count of "noOfMatchingChar"
 * 1) If a rightIndex char exists in searchString. Decrement the map count on char and increase noOfMatchingChar
 * 2) If a leftIndex char exists in searchString. Increment the map count on char and decrease noOfMatchingChar
 * 
 * Logic : At any point when "noOfMatchingChar" == mapSize a result is found
 * 
 * 
 * First think the logic with same size : 
 * 			Ex: "aab" with "aba"
 * 				"aab" with "baa"
 * 
 * Then go on increase the size of input string and test the cases.   
 * 
 */
public class FindAllAnagramsInAString_SlidingWindow {

	int noOfMatchingChar = 0;
	int leftIndex = 0;
	int rightIndex = 0;
	String inputString;
	String searchString;
	Map<Character, Integer> map = new HashMap<>();

	public List<Integer> findAnagrams(String inputString, String searchString) {
		this.inputString = inputString;
		this.searchString = searchString;
		List<Integer> result = new ArrayList<>();
		if (inputString == null || inputString.length() == 0) {
			return result;
		}
		if (searchString.length() > inputString.length()) {
			return result;
		}
		updateMap(searchString);
		while (rightIndex < inputString.length()) {
			checkOnRightSide();
			checkOnLeftSide();
			if (noOfMatchingChar == map.size()) {
				result.add(leftIndex);
			}
		}
		return result;
	}

	private void updateMap(String p) {
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}

	}

	public void checkOnRightSide() {
		char rightIndexChar = inputString.charAt(rightIndex);
		if (map.containsKey(rightIndexChar)) {
			map.put(rightIndexChar, map.get(rightIndexChar) - 1);
			if (map.get(rightIndexChar) == 0) {
				noOfMatchingChar++;
			}
		}
		rightIndex++;
	}

	public void checkOnLeftSide() {
		if (rightIndex > searchString.length()) { // This if will start execute after first window.
			char leftIndexChar = inputString.charAt(leftIndex++);
			if (map.containsKey(leftIndexChar)) {
				if (map.get(leftIndexChar) == 0) {
					noOfMatchingChar--;
				}
				map.put(leftIndexChar, map.get(leftIndexChar) + 1);
			}
		}
	}

	public static void main(String[] args) {
		FindAllAnagramsInAString_SlidingWindow f = new FindAllAnagramsInAString_SlidingWindow();
		//System.out.println(f.findAnagrams("abababbaaab", "abb"));
		System.out.println(f.findAnagrams("acac", "aac"));
	}
}
