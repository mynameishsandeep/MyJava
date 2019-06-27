package com.sample.basics;

/*
 * 1) The multiplication and division based approach doesn’ work if one 
 * of the numbers is 0 as the product becomes 0 irrespective of the other number.
 * 
 * 2) Both Arithmetic solutions may cause arithmetic overflow. 
 * If x and y are too large, addition and multiplication may go out of integer range.
 * 
 * 3) Swapping a variable with itself may needed in many standard algorithms. 
 * XOR operation will fail in that case. To avoid this. add a if condition, do operation only when x!=y
 */
public class SwapWithoutThirdVariable {

	public static void main(String[] args) {
		SwapWithoutThirdVariable s = new SwapWithoutThirdVariable();
		s.swapUsingXOR();
	}

	private void swapUsingXOR() {
		int x = 10;
		int y = 5;
		// If x and y are same then both will turn into 10(big number). So to avoid that 
		if (x != y) {
			// Code to swap 'x' (1010) and 'y' (0101)
			x = x ^ y; // x now becomes 15 (1111)
			y = x ^ y; // y becomes 10 (1010)
			x = x ^ y; // x becomes 5 (0101)
		}
		System.out.println(x);
		System.out.println(y);

	}

	private void swapUsingAdditionSubtraction() {
		int x = 10;
		int y = 5;

		x = x + y; // 15
		y = x - y; // 10
		x = x - y; // 5
	}

	private void swapUsingMultiplicationDivision() {
		int x = 10;
		int y = 5;

		x = x * y; // 50
		y = x / y; // 10
		x = x / y; // 5
	}

}
