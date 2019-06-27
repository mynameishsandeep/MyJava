package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.List;

/*

https://leetcode.com/problems/word-search-ii/description/

This problem is an extension of WordSearch.java. Adding just a for loop on top inside findWords method 

1) For each character search recursively in all 4 directions
2) Use isVisited to avoid forming circle in search. 
 
=======Note: IsVisited will be set to true before and set to false after...==========   
[["C","A","A"],["A","A","A"],["B","C","D"]]
"AAB":  True
 *
 */
public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		for (String searchWord : words) {
			if (result.contains(searchWord)) {
				continue;
			}
			boolean[][] visited = new boolean[board.length][board[0].length];
			outer: for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (search(board, searchWord, i, j, 0, visited)) {
						result.add(searchWord);
						break outer;
					}
				}
			}
		}

		return result;
	}

	private boolean search(char[][] board, String searchWord, int i, int j, int searchWordIndex, boolean[][] visited) {
		if (searchWordIndex == searchWord.length()) {
			return true;
		} else if (currentCellExceedsTopOrBottomOrLeftOrRight(board, i, j)
				|| board[i][j] != searchWord.charAt(searchWordIndex) || visited[i][j]) {
			return false;
		} else {
			visited[i][j] = true;
			if (search(board, searchWord, i - 1, j, searchWordIndex + 1, visited) // Go Top
					|| search(board, searchWord, i + 1, j, searchWordIndex + 1, visited) // Go Down
					|| search(board, searchWord, i, j - 1, searchWordIndex + 1, visited) // Go Left
					|| search(board, searchWord, i, j + 1, searchWordIndex + 1, visited)) { // Go Right 
				return true;
			}
			visited[i][j] = false;
		}
		return false;

	}

	/*
	Row cannot go beyond max row. Row cannot go below min row
	Column cannot go beyond max column. Column cannot go below min column.
	*/
	private boolean currentCellExceedsTopOrBottomOrLeftOrRight(char[][] board, int i, int j) {
		return i >= board.length || i < 0 || j >= board[i].length || j < 0;
	}

}
