package com.interview.leetcode.linkedin.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * https://leetcode.com/problems/word-ladder/description/
 * See the picture in Eclipse "word_ladder".jpg
 * 
 * Take the beginWord, 
 * change the first character from a-z loop it and see if matches with wordList or Dictionary. 
 * If match found push it to queue. Do it for all the characters for beginword. 
 * Now the structure is like Graph(not n-ary tree)... One root node(visited) with multiple child node to visit.
 * 
 * Do this operation level by level for all words. 
 * Level Order Traversal or BFS is best, because we need the shortest length. 
 * I written code with recursion (WordLadder_Recursion.java) which passed 90% test cases
 * and failed for big input stating timeLimitExceeded. 
 * 
 * If we need the longest length. Then right option is recursion.  
 */
public class WordLadder_BFS {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordListSet = new HashSet<>(wordList);
		Set<String> isVisited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		q.offer(beginWord);
		int level = 0;
		while (q.size() > 0) {
			int size = q.size();
			level++;
			for (int k = 0; k < size; k++) {
				beginWord = q.poll();
				for (int i = 0; i < beginWord.length(); i++) {
					for (char j = 'a'; j <= 'z'; j++) {
						String permutedString = beginWord.substring(0, i) + j + beginWord.substring(i + 1);
						if (permutedString.equals(endWord) && wordListSet.contains(permutedString)) {
							// Stop instantly when endWord is found
							return level + 1;
						}
						if (wordListSet.contains(permutedString) && !isVisited.contains(permutedString)) {
							System.out.println(isVisited);
							isVisited.add(permutedString);
							q.offer(permutedString);
						}
					}
				}
			}
		}
		return 0;

	}

	public static void main(String[] args) {
		WordLadder_BFS w = new WordLadder_BFS();
		//System.out.println(w.ladderLength("hit", "cot", Arrays.asList("hot")));
		//System.out.println(w.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"))); //  5
		System.out.println(w.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"))); //  0
	}

}
