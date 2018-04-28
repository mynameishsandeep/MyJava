package com.sample.datastructure;

public class FactorialInJava {

	public static void main(String[] args) {
		int data = 4;
		System.out.println(factorial(data));

	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);

	}

}
