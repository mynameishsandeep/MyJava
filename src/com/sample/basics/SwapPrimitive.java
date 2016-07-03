package com.sample.basics;

public class SwapPrimitive {

	public void swap(int a, int b) {
		int temp = a;
		a = b;
		b = a;
	}
	public static void main(String[] args) {
		SwapPrimitive s = new SwapPrimitive();
		int a= 10; int b=20;
		s.swap(a,b);
		System.out.println(a +"" + b);

	}

}
