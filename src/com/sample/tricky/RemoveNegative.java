package com.sample.tricky;

public class RemoveNegative {
	public static void main(String[] args) {
		int a = -5;
		System.out.println(Math.abs(a));
		System.out.println(a * -1);

		int b = -100;
		if (a > b) {
			System.out.println("a "+ a + " is bigger than " + "b " + b);
		} else {
			System.out.println("b "+ b + " is bigger than " + "a " + a);
		}
	}
}
