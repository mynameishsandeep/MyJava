package com.sample.datastructure;

class TrieNode {
	TrieNode[] arr = new TrieNode[26];
	boolean isEnd;
	int frequency = 1;
}

public class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

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
		Trie trie = new Trie();
		trie.insert("has");
		trie.insert("has");
		trie.insert("hasa");
		trie.insert("had");
		trie.insert("hada");
		System.out.println(trie.searchWithCount("has"));
		System.out.println(trie.searchWithCount("ha"));
	}
}
