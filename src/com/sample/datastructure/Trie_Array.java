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
 * =====Solution Note===========================
 * This data structure is like onion. Nothing will be saved in array index. meaning position of index for a character saves next node.
 * Character 'a' will have position. Character 'b' will have position.  
 * I tried the below in interview which is totally wrong. 
 * 		class Trie {
 * 			boolean dictionary[] = new boolean[26];
 * 			boolean isEnd;
 * 			Trie nextLevel;
 * 		}  
 *==========================================
 */
public class Trie_Array {
	class TrieNode {
		TrieNode[] arr = new TrieNode[26];
		boolean isEnd;
	}

	private TrieNode root = new TrieNode();

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode temp = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if (temp.arr[index] == null) {
				TrieNode newNode = new TrieNode();
				temp.arr[index] = newNode;
				temp = newNode;
			} else {
				temp = temp.arr[index];
			}
		}
		temp.isEnd = true;
	}

	// Returns if the word is in the trie.
	public boolean searchCompleteString(String word) {
		TrieNode temp = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if (temp.arr[index] != null) {
				temp = temp.arr[index];
			} else {
				break;
			}
		}

		if (temp == null) {
			return false;
		} else {
			return temp.isEnd;
		}
	}

	public static void main(String[] args) {
		Trie_Array trie = new Trie_Array();
		trie.insert("has");
		trie.insert("has");
		trie.insert("hasa");
		trie.insert("had");
		trie.insert("hada");
		System.out.println(trie.searchCompleteString("had"));
		System.out.println(trie.searchCompleteString("ha"));
		System.out.println(trie.searchCompleteString("test"));
		trie.insert("test");
		System.out.println(trie.searchCompleteString("test"));
	}
}
