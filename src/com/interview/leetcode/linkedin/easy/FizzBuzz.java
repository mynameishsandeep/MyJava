package com.interview.leetcode.linkedin.easy;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/fizz-buzz/submissions/1
 * 
//	If the number is a multiple of 3 output an Fizz instead of the number.
//	If the number is a multiple of 5 output an Buzz instead of the number.
//	If the number is a multiple of 15 output output an FizzBuzz instead of the number.
 * 
 * Note: optimize the solution by reducing the number of operations i.e store the calculation boolean.
 */
public class FizzBuzz {

	public List<String> fizzBuzz(int n) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			boolean divisibleBy3 = (i % 3 == 0);
			boolean divisibleBy5 = (i % 5 == 0);
			result.add((divisibleBy5 && divisibleBy3) ? "FizzBuzz"
					: (divisibleBy5 ? "Buzz" : (divisibleBy3 ? "Fizz" : i + "")));
		}
		return result;
	}
	
	public static void main(String[] args) {
		FizzBuzz f = new FizzBuzz();
		System.out.println(f.fizzBuzz(50));
	}
}
