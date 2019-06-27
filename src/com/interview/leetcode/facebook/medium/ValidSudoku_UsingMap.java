package com.interview.leetcode.facebook.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * https://leetcode.com/problems/valid-sudoku/description/
 * 
 * 1) Key point is 
 * 		a) a row cannot have same value again.
 * 		b) a column cannot have the same value again.
 * 		c) a box(3*3) cannot have the same value again.
 * 2) For each value in a cell, save "row identifier", "column identifier" and "box identifier".
 *    Ex : 5 at 0,0 will have 3 entry in the set ---> "0(5)","(5)0","00(5)"
 *    Ex : 3 at 0,1 will have 3 entry in the set ---> "0(3)","(3)1","00(3)"
 *    Ex : 5 at 0,2 will have 3 entry in the set ---> "0(5)","(5)2","00(5)"
 *    Here both rowIdenfier and boxIdentifier values are already seen and both will return false.
 * 3) ========Box Identification=========
 * 	  1) In a 9*9 matrix there are 9 boxes of 3*3 matrix.
 * 	  2) Box Identification formula is i/3 + j/3 + {data}  which returns 00{data}  
 * 		 9 boxes are identified as 
 * 					00,01,02
 * 					10,11,12
 * 					20,21,22	
 * 	  3) [0,0][0,1][0,2]
 * 		 [1,0][1,1][1,2]
 * 		 [2,0][2,1][2,2] ---> all these indexes should return same value for box identifier. 00 here
 * 
 */
public class ValidSudoku_UsingMap {
	public boolean isValidSudoku(char[][] board) {
		Map<Integer, Set<Character>> row = new HashMap<>();
		Map<Integer, Set<Character>> col = new HashMap<>();
		Map<String, Set<Character>> box = new HashMap<>();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					continue;
				}
				if (row.get(i) == null) {
					row.put(i, new HashSet<>(Arrays.asList(board[i][j])));
				} else {
					if (row.get(i).contains(board[i][j])) {
						return false;
					}
					row.get(i).add(board[i][j]);
				}
				if (col.get(j) == null) {
					col.put(j, new HashSet<>(Arrays.asList(board[i][j])));
				} else {
					if (col.get(j).contains(board[i][j])) {
						return false;
					}
					col.get(j).add(board[i][j]);
				}
				if (box.get(i / 3 + "" + j / 3) == null) {
					box.put(i / 3 + "" + j / 3, new HashSet<>(Arrays.asList(board[i][j])));
				} else {
					if (box.get(i / 3 + "" + j / 3).contains(board[i][j])) {
						return false;
					}
					box.get(i / 3 + "" + j / 3).add(board[i][j]);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidSudoku_UsingMap v = new ValidSudoku_UsingMap();
		System.out.println(v.isValidSudoku(new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));
	}
}
