package com.interview.leetcode.amazon.medium;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 * 
 * Note: For the "." character, recursively call for all the character in Map with the corresponding node
 */
public class AddAndSearchWord_TRIE {

	class Trie {
		public Map<Character, Trie> map = new HashMap<>();
		// When the search needs to do find full word then isLeaf is mandate : Ex: input="Hellow" search="Hello" -->return false
		boolean isLeaf = false;
	}

	Trie root;

	public AddAndSearchWord_TRIE() {
		root = new Trie();
	}

	public void addWord(String word) {
		Trie tempRoot = root;
		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			if (tempRoot.map.containsKey(c)) {
				tempRoot = tempRoot.map.get(c);// Move to next Node
			} else {
				Trie nextNode = new Trie();
				tempRoot.map.put(c, nextNode);
				tempRoot = nextNode;
			}
		}
		tempRoot.isLeaf = true;
	}

	public boolean search(String word) {
		Trie tempRoot = root;
		return searchFromLevel(word, tempRoot);
	}

	public boolean searchFromLevel(String word, Trie tempRoot) {
		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			if (tempRoot.map.size() == 0) { // for the case input=["a"] and searchString=["a."]
				return false;
			}
			if (c == '.') {
				//For the "." character, recursively call for all the character in Map with the corresponding node
				for (Map.Entry<Character, Trie> m : tempRoot.map.entrySet()) {
					if (searchFromLevel(word.substring(i + 1, word.length()), tempRoot.map.get(m.getKey()))) {
						return true;
					}
				}
				return false;
			} else if (tempRoot.map.containsKey(c)) {
				tempRoot = tempRoot.map.get(c);// Move to next Node
			} else {
				return false;
			}
		}
		return tempRoot.isLeaf;
	}
}
