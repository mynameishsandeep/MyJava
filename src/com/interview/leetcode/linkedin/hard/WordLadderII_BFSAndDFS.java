package com.interview.leetcode.linkedin.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderII_BFSAndDFS {

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> ladders = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		Map<String, Integer> distance = new HashMap<>();

		Set<String> dict = new HashSet<>(wordList);

		if (!dict.contains(endWord)) {
			return ladders;
		}
		dict.add(beginWord);
		dict.add(endWord);

		bfs(map, distance, dict, endWord);

		System.out.println(map);
		List<String> path = new ArrayList<>();

		dfs(ladders, map, distance, beginWord, endWord, path);
		return ladders;
	}

	private void dfs(List<List<String>> ladders, Map<String, List<String>> map, Map<String, Integer> distance,
			String crt, String endWord, List<String> path) {
		path.add(crt);
		if (crt.equals(endWord)) {
			ladders.add(new ArrayList<String>(path));
		}
		for (String nextWord : map.get(crt)) {
			if (distance.containsKey(nextWord) && distance.get(crt) == distance.get(nextWord) + 1) {
				dfs(ladders, map, distance, nextWord, endWord, path);
			}
		}
		path.remove(path.size() - 1);
	}

	private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, Set<String> dict, String crt) {
		Queue<String> queue = new LinkedList<>();
		queue.offer(crt);
		distance.put(crt, 0);
		for (String word : dict) {
			map.put(word, new ArrayList<>());
		}

		while (!queue.isEmpty()) {
			String head = queue.poll();
			for (String nextWord : getNextWord(head, dict)) {
				map.get(nextWord).add(head);
				if (!distance.containsKey(nextWord)) {
					queue.offer(nextWord);
					distance.put(nextWord, distance.get(head) + 1);
				}
			}
		}
	}

	private List<String> getNextWord(String word, Set<String> dict) {
		List<String> neighbors = new ArrayList<>();
		for (int i = 0; i < word.length(); i++) {
			StringBuilder sb = new StringBuilder(word);
			for (char c = 'a'; c <= 'z'; c++) {
				if (c == word.charAt(i)) {
					continue;
				}
				sb.setCharAt(i, c);
				String next = sb.toString();
				if (dict.contains(next)) {
					neighbors.add(next);
				}
			}
		}
		return neighbors;
	}
	
	public static void main(String[] args) {
		WordLadderII_BFSAndDFS w = new WordLadderII_BFSAndDFS();
		System.out.println(
				w.findLadders("red", "tax", Arrays.asList("ted", "tex", "red", "tax", "tad", "den", "rex", "pee")));

	}

}
