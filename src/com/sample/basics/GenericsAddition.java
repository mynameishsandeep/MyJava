package com.sample.basics;

public class GenericsAddition<T> {

	public static void main(String[] args) {
		System.out.println(GenericsAddition.compare(10, 20l));
		
		System.out.println(GenericsAddition.compare(10.23d, 20.5f));
		

	}

	public static <T extends Number> Boolean compare(T input1, T input2) {
		if (input1 instanceof Integer) {
			System.out.println("Inside Integer");
		return (input1.intValue() > input2.intValue());
		}
		else if (input1 instanceof Float) {
			System.out.println("Inside Float");
			return (input1.floatValue() > input2.floatValue());
		}
		return false;
	}
}
