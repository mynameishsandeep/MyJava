package com.interview.leetcode.linkedin.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class WordLadderII_Recursion {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordListSet = new HashSet<>(wordList);
		Set<String> isVisited = new LinkedHashSet<>();
		isVisited.add(beginWord);
		List<List<String>> result = new ArrayList<>();
		recur(beginWord, endWord, wordListSet, isVisited, result);
		//System.out.println(result);
		return result;
	}

	public void recur(String beginWord, String endWord, Set<String> wordListSet, Set<String> isVisited,
			List<List<String>> result) {
		for (int i = 0; i < beginWord.length(); i++) {
			for (char j = 'a'; j <= 'z'; j++) {
				String permutedString = beginWord.substring(0, i) + j + beginWord.substring(i + 1);
				if (permutedString.equals(endWord) && wordListSet.contains(endWord)) {
					System.out.println(isVisited);
					//isVisited.add(permutedString);
					if(result.isEmpty()) {
						List<String> subResult = new ArrayList<String>();
						subResult.addAll(isVisited);
						subResult.add(permutedString);
						result.add(subResult);	
					} else {
						int size = result.get(0).size();
						if(size==isVisited.size()+1) {
							List<String> subResult = new ArrayList<String>();
							subResult.addAll(isVisited);
							subResult.add(permutedString);
							result.add(subResult);
						} else if(size>isVisited.size()+1) {
							result.clear();
							List<String> subResult = new ArrayList<String>();
							subResult.addAll(isVisited);
							subResult.add(permutedString);
							result.add(subResult);
						}
					}
					

					return;
				}
				if (!isVisited.contains(permutedString)) {
					if (wordListSet.contains(permutedString)) {
						isVisited.add(permutedString);
						recur(permutedString, endWord, wordListSet, isVisited, result);
						isVisited.remove(permutedString);// remove previous visited nodes to continue with other combinations
					}
				}

			}
		}

	}

	public static void main(String[] args) {
		WordLadderII_Recursion w = new WordLadderII_Recursion();
		//System.out.println(w.findLadders("hit", "cot", Arrays.asList("hot")));
		System.out.println(w.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))); //  5
		//System.out.println(w.findLadders("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"))); //  0
	}

}
