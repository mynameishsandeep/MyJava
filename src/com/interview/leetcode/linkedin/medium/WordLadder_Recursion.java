package com.interview.leetcode.linkedin.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class WordLadder_Recursion {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordListSet = new HashSet<>(wordList);
		Set<String> isVisited = new LinkedHashSet<>();
		List<Integer> resultCount = new ArrayList<>();
		isVisited.add(beginWord);
		recur(beginWord, endWord, wordListSet, isVisited, resultCount, 0);
		System.out.println(resultCount);
		return resultCount.size()>0?Collections.min(resultCount):0;
	}

	public void recur(String beginWord, String endWord, Set<String> wordListSet, Set<String> isVisited,
			List<Integer> resultCount, int size) {
		for (int i = 0; i < beginWord.length(); i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				String permutedString = beginWord.substring(0, i) + j + beginWord.substring(i + 1);
				if (permutedString.equals(endWord) && wordListSet.contains(endWord)) {
					System.out.println(isVisited);
					//isVisited.add(permutedString);
					resultCount.add(size + 1);
					return;
				}
				if (!isVisited.contains(permutedString)) {
					if (wordListSet.contains(permutedString)) {
						isVisited.add(permutedString);
						recur(permutedString, endWord, wordListSet, isVisited, resultCount, size + 1);
						isVisited.remove(permutedString);
					}
				}

			}
		}

	}

	public static void main(String[] args) {
		WordLadder_Recursion w = new WordLadder_Recursion();
		//System.out.println(w.ladderLength("hit", "cot", Arrays.asList("hot")));
		System.out.println(w.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))); //  5
		//System.out.println(w.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"))); //  0
	}
}
