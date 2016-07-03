package com.altimetrik.datastructure;

import java.util.Scanner;

public class TrieFindBadSet {
	class TrieNode {
		TrieNode[] arr;
		boolean isEnd;
		int frequency;

		public TrieNode() {
			this.arr = new TrieNode[26];
			this.frequency = 1;
		}

	}

	private TrieNode root;

	public TrieFindBadSet() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public String insert(String word) {
		int total = 0;
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
				total++;
				if (p.isEnd) {
					return word;
				}

			}
		}
		p.isEnd = true;
		if(total==word.length()) {
			return word;
		}
		return "";
	}

	public static void main(String[] args) {
		TrieFindBadSet trie = new TrieFindBadSet();
		String result = "";
    	try(Scanner scan = new Scanner(System.in)) {
    		int n = scan.nextInt();
    		String input = "";
    		int i=0;
    		for(; i<n; i++) {
    			input = scan.next();
    			result = trie.insert(input);
    			if(!"".equals(result)) {
    				break;
    			}
    		}
    	}
		System.out.println(result);

    }
}
