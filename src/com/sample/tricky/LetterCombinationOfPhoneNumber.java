package com.sample.tricky;

import java.util.LinkedList;
import java.util.List;

/**
 * Flow image is inside "US Problems" folder "LetterCombinationOfPhoneNumber.png"
 * 
 * Note: There will be 3 for loops
 */

public class LetterCombinationOfPhoneNumber {


	public List<String> letterCombinations(String digits) {
		LinkedList<String> queue = new LinkedList<String>();
		if (digits.length() == 0) {
			return queue;
		}
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		queue.offer("");
		for (int i = 0; i < digits.length(); i++) {
			int queueSize = queue.size();
			char[] ch = mapping[digits.charAt(i) - '0'].toCharArray();
			for (int j = 0; j < queueSize; j++) {
				String currentCombo = queue.poll();
				// for number 2, get 'a' 'b' 'c'
				for (Character c : ch) {
					queue.offer(currentCombo + c);
				}
			}
		}
		return queue;
	}

	public static void main(String[] args) {
		LetterCombinationOfPhoneNumber l = new LetterCombinationOfPhoneNumber();
		System.out.println(l.letterCombinations("23"));
	}
}
