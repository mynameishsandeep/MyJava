package com.altimetrik.java8features;

import java.util.function.Function;

/**
 * Function can accept argument and it can return a value.

 * Function sends a function f1 to another function f2. Inside f2, we call
 * function.apply(data), which calls f1(data). f1(data) applies data on f1(Ex:
 * addition) and does return the result.
 * 
 */
public class LambdaFunctionFunction {
	public static void main(String[] args) {
		Function<Integer, Integer> sumFunction= (x)->x+10;
		int sumResult = testFunction(sumFunction, 10);
		//System.out.println(sumFunction.apply(10));
		System.out.println(sumResult);
		
		Function<Integer, Integer> multiplyFunction= (x)->x*10;
		int multiplyResult = testFunction(multiplyFunction, 10);
		System.out.println(multiplyResult);
		
	}
	
	
	
	public static Integer testFunction(Function<Integer, Integer> function, int data) {
		return function.apply(data);
	}
}
