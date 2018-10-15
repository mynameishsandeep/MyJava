package com.interview.leetcode.linkedin.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * https://leetcode.com/problems/profitable-schemes/description/
 * 
 *  Logic is same as WordLadder_BFS, but we need to maintain and return the path of ladder.
 *  
 *  1) Save the path at each node from root, by using the call Path. 
 *  Ex: "red" is beginWord. "bed", "led", "rid", are child nodes found. 
 *  Then I will push currentString as red and pathList["bed", "led", "rid"].
 *  2) So each node maintains the path.
 *  3) When a result found at level(n or before), add the path to result.
 *  4) There can be multiple result at that level. 
 *  So,Break the logic and return result at that path level by the flag lowestLevelResultFound
 *  
 *  This code is throwing TimeLimitException for big input. But logically this is perfectly right.
 *  Look into code "WordLadderII_BFSAndDFS" for alternate option
 *  
 */
public class WordLadderII_BFS {
	class Path {
		public String currentString;
		public List<String> pathList;

		public Path(String currentString, List<String> pathList) {
			this.currentString = currentString;
			this.pathList = pathList;
		}
	}

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		Set<String> wordListSet = new HashSet<>(wordList);
		Set<String> isVisited = new LinkedHashSet<>();
		isVisited.add(beginWord);
		Queue<Path> q = new LinkedList<>();
		q.offer(new Path(beginWord, new ArrayList<>(Arrays.asList(beginWord))));
		boolean lowestLevelResultFound = false;
		List<List<String>> result = new ArrayList<>();
		while (q.size() > 0) {
			if (lowestLevelResultFound) {
				break;
			}
			int size = q.size();
			for (int k = 0; k < size; k++) {
				Path path = q.poll();
				beginWord = path.currentString;
				isVisited.add(beginWord);
				for (int i = 0; i < beginWord.length(); i++) {
					for (char j = 'a'; j <= 'z'; j++) {
						String permutedString = beginWord.substring(0, i) + j + beginWord.substring(i + 1);
						if (permutedString.equals(endWord) && wordListSet.contains(permutedString)) {
							lowestLevelResultFound = true;
							System.out.println(result);
							addResult(result, path, permutedString);
							break;
						}
						if (wordListSet.contains(permutedString) && !isVisited.contains(permutedString)) {
							q.offer(updatePath(path, permutedString));
							System.out.println("isVisited" + isVisited);
						}
					}
				}
			}
		}
		return result;
	}

	private Path updatePath(Path oldPath, String permutedString) {
		List<String> pathList = new ArrayList<>();
		pathList.addAll(oldPath.pathList);
		pathList.add(permutedString);
		return new Path(permutedString, pathList);
	}

	private void addResult(List<List<String>> result, Path oldPath, String permutedString) {
		List<String> res = new ArrayList<>();
		res.addAll(oldPath.pathList);
		res.add(permutedString);
		result.add(res);
	}

	public static void main(String[] args) {
		WordLadderII_BFS w = new WordLadderII_BFS();
		System.out.println(
				w.findLadders("red", "tax", Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee")));

	}

}
