package com.interview.leetcode.google.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.interview.leetcode.Master;

/*
 * 1) Input word list might have more than 100 word, but call master.guess at max of 10 times.
 * 2) So leetcode counts number of times we call the master.guess.
 *  If we called the master.guess more than 10 time and 
 */
public class GuessTheWord {
	public void findSecretWord(String[] wordlist, Master master) {
		Arrays.sort(wordlist);
		Map<String, Integer> badWords = new HashMap();
		for (String word : wordlist) {
			System.out.println(badWords);
			if (validateWord(word, badWords)) {
				int score = master.guess(word);
				if (score == 6) {
					return;
				}
				badWords.put(word, score);
			}
		}
	}

	private boolean validateWord(String candidate, Map<String, Integer> badWords) {
		int similarity = 0;
		Integer score = 0;
		for (String w : badWords.keySet()) {
			similarity = similarity(w, candidate);
			score = badWords.get(w);
			if (similarity != score) {
				return false;
			}
		}
		return true;
	}

	public int similarity(String s1, String s2) {
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) == s2.charAt(i)) {
				count++;
			}
		}
		System.out.println("similarity count " + count);
		return count;

	}
}
