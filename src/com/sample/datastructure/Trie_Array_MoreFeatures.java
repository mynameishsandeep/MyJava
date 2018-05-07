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
public class Trie_Array_MoreFeatures {
	class TrieNode {
		TrieNode[] arr = new TrieNode[26];
		boolean isEnd;
		int frequency = 1;
	}

	private TrieNode root = new TrieNode();

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode p = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			int index = c - 'a';
			if (p.arr[index] == null) {
				TrieNode temp = new TrieNode();
				p.arr[index] = temp;
				p = temp;
			} else {
				p = p.arr[index];
				p.frequency++;
			}
		}
		p.isEnd = true;
	}

	// Returns if the word is in the trie.
	public boolean searchCompleteString(String word) {
		TrieNode p = searchNode(word);
		if (p == null) {
			return false;
		} else {
			if (p.isEnd)
				return true;
		}
		return false;
	}

	// Returns count for word if the word is in the trie
	public int searchWithCount(String word) {
		TrieNode p = searchNode(word);
		if (p == null) {
			return 0;
		}
		return p.frequency;

	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		TrieNode p = searchNode(prefix);
		if (p == null) {
			return false;
		} else {
			return true;
		}
	}

	public TrieNode searchNode(String s) {
		TrieNode p = root;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = c - 'a';
			if (p.arr[index] != null) {
				p = p.arr[index];
			} else {
				return null;
			}
		}

		if (p == root)
			return null;
		return p;
	}

	public static void main(String[] args) {
		Trie_Array_MoreFeatures trie = new Trie_Array_MoreFeatures();
		trie.insert("has");
		trie.insert("has");
		trie.insert("hasa");
		trie.insert("had");
		trie.insert("hada");
		// has occurred 5 times.
		System.out.println(trie.searchWithCount("has"));
		// ha occurred 2 times.
		System.out.println(trie.searchWithCount("ha"));
		trie.insert("test");
		System.out.println(trie.searchWithCount("te"));
		System.out.println(trie.searchCompleteString("hada"));
		System.out.println(trie.searchCompleteString("had"));
		System.out.println(trie.searchCompleteString("ha"));
	}
}
