package com.home.codereview;

public class PrimitiveVsObjects {
	// Hideously slow program! Can you spot the object creation?
	/*
	 * https://softwareengineering.stackexchange.com/questions/203970/when-to-use-primitive-vs-class-in-java
	 * 
	 * This program gets the right answer, but it is much slower than it should be, 
	 * due to a one-character typographical error. The variable sum is declared as a Long instead of a long, 
	 * which means that the program constructs about 2^31 unnecessary Long instances 
	 * (roughly one for each time the long i is added to the Long sum). 
	 * Changing the declaration of sum from Long to long reduces the runtime 
	 * from 43 seconds to 6.8 seconds on my machine.
	 */
	public static void main(String[] args) {
		Long sum = 0L;
		for (long i = 0; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
