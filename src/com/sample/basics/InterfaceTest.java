package com.sample.basics;

public class InterfaceTest implements B {

	public static void main(String[] args) {
		System.out.println(x);

	}

}

interface A {
	int x = 100;
}

interface B extends A {
	//int x = 200;
}

interface C extends A {
	int x = 100;
}
