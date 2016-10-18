package com.altimetrik.java8features;

import java.util.function.Function;

/**
 * Function is similar to a consumer + it can return a value.
 * @author sisuser
 *
 */
public class LambdaFunctionFunction {
	public static void main(String[] args) {
		Function<Integer, Integer> sumFunction= (x)->x+10;
		int sumResult = testFunction(sumFunction);
		System.out.println(sumResult);
		
		Function<Integer, Integer> multiplyFunction= (x)->x*10;
		int multiplyResult = testFunction(multiplyFunction);
		System.out.println(multiplyResult);
		
	}
	
	
	
	public static Integer testFunction(Function<Integer, Integer> function) {
		return function.apply(10);
	}
}
