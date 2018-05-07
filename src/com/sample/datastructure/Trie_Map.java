package com.sample.datastructure;

/*
 * Tree image is present in "US Problems" "trie.jpeg"
 * 
 * A trie stores words and supports add/search in O(w) time, where w is the length of the word. 
 * The number of total words stored in the trie doesn't matter, 
 * so looking up the word "apple" requires basically 5 operations regardless of 
 * whether the trie stores 100 words or 1,000,000 words.
 * 
 * Note: The trick to save key and value is n word will have n+1 node.
 * one char word will have root node and 1 child node.
 * two char word will have root node and 2 child node.
 * 1) There will be an one empty root node initially. 
 * 2) There after there will be one empty leaf node all the time. 
 * 3) The empty leaf node will have the "isEnd" set to true. 
 * 	Ex: for the input "a". There will be 2 node. root[0] will point to another node. 
 * 		next node will have isLeaf = true.  
 */

import java.util.HashMap;
import java.util.Map;

public class Trie_Map {
	class TrieNode {
		Map<Character, TrieNode> node = new HashMap<>();
		// To identify the completion of word
		Boolean isLeaf = false;
	}

	TrieNode root = new TrieNode();

	private void insert(String word) {
		TrieNode temp = root;
		for (Character c : word.toCharArray()) {
			if (temp.node.containsKey(c)) {
				temp = temp.node.get(c);
			} else {
				TrieNode newNode = new TrieNode();
				temp.node.put(c, newNode);
				temp = newNode;

			}
		}
		temp.isLeaf = true;
	}

	// Returns if the complete word is in the trie.
	private Boolean search(String word) {
		TrieNode temp = root;
		int count = 0;
		for (Character c : word.toCharArray()) {
			if (temp.node.containsKey(c)) {
				temp = temp.node.get(c);
				if (word.length() == ++count) {
					return temp.isLeaf;
				}
			} else {
				return false;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Trie_Map trie = new Trie_Map();
		trie.insert("Test");
		System.out.println(trie.search("Tes"));
		System.out.println(trie.search("Test"));
		System.out.println(trie.search("Test2"));
		System.out.println(trie.search("New"));
		trie.insert("New");
		System.out.println(trie.search("New"));
	}

}
