package com.interview.leetcode.facebook.medium;

/*

https://leetcode.com/problems/zigzag-conversion/description/

https://www.geeksforgeeks.org/print-concatenation-of-zig-zag-string-form-in-n-rows/

1) Create an array of numRows strings, arr[numRows]
2) Initialize direction as "down" and row as 0. The 
   direction indicates whether we need to move up or 
   down in rows. 
3) Traverse the input string, do following for every
   character.
   a) Append current character to string of current row.
   b) If row number is n-1, then change direction to 'up'
   c) If row number is 0, then change direction to 'down'
   d) If direction is 'down', do row++.  Else do row--.
4) One by one print all strings of arr[].  
 */
public class ZigZagConversion {
	public String convert(String str, int numRows) {
		// Corner Case (Only one row) 
		if (numRows <= 1) {
			return str;
		}

		// Create an array of strings for all n rows 
		StringBuilder matrix[] = new StringBuilder[numRows];
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = new StringBuilder(); //init every sb element **important step!!!!
		}
		
		int row = 0; // Initialize index for array of strings arr[]
		boolean down = true; // True if we are moving down in rows,  // else false to move up 

		// Traverse through given string 
		for (int i = 0; i < str.length(); ++i) {
			matrix[row].append(str.charAt(i));// append current character to current row

			if (row == numRows - 1) {// If last row is reached, change direction to 'up'
				down = false;
			} else if (row == 0) {// If 1st row is reached, change direction to 'down'
				down = true;
			}

			if (down) { // If direction is down, increment, else decrement
				row++;
			} else {
				row--;
			}
		}

		String re = "";
		for (int i = 0; i < matrix.length; i++) {
			re += matrix[i];
		}
		return re.toString();
	}

	public static void main(String[] args) {
		ZigZagConversion z = new ZigZagConversion();
		System.out.println(z.convert("PAYPALISHIRING", 3));//PAHNAPLSIIGYIR
	}
}
