package com.interview.leetcode.facebook.medium;

import java.util.HashSet;
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
 * 							
 * 	 
 * 
 */
public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		Set<String> seen = new HashSet<>();
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				if (board[i][j] != '.') {
					String b = "(" + board[i][j] + ")";
					String rowIdentifier = i + b;
					String colIdentifier = b + j;
					String boxIdentifier = i / 3 + "" + j / 3 + b;
					System.out.println(rowIdentifier + "," + colIdentifier + "," + boxIdentifier);
					if (seen.contains(rowIdentifier)) {
						return false; // Row Cell already contains the number
					} else if (seen.contains(colIdentifier)) {
						return false; // Column Cell already contains the number
					} else if (seen.contains(boxIdentifier)) {
						return false;// Box Cell already contains the number
					}
					seen.add(rowIdentifier);
					seen.add(colIdentifier);
					seen.add(boxIdentifier);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidSudoku v = new ValidSudoku();
		System.out.println(v.isValidSudoku(new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } }));
	}
}
