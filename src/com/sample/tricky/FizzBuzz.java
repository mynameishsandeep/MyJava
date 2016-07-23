package com.sample.tricky;

//Requirements: Output the numbers 1-100, with one number on every row.
//	If the number is a multiple of 3 output an F instead of the number.
//	If the number is a multiple of 5 output an B instead of the number.
//	If the number is a multiple of 15 output output an FB instead of the number.
public class FizzBuzz {
	public static void main(String[] args) {
		String result = "";
		for (int i = 1; i <= 100; i++) {
			result = i % 15 == 0 ? "FizzBuzz" : (i % 3 == 0 ? "Fizz" : (i % 5 == 0 ? "Buzz" : i + ""));
			System.out.println(result);
		}
	}
}
