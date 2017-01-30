package com.sample.datastructure;

public class FactorialInJava {

	public static void main(String[] args) {
		int data = 4;
		System.out.println(fibo(data));

	}

	public static int fibo(int n) {
		if (n == 0) {
			return 1;
		}
		return n * fibo(n - 1);

	}

}
