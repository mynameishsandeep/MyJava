package com.sample.basics;

public class ObjectInitSequence {

	ObjectInitSequence() {
		System.out.print("cons");
	}

	{

		System.out.print("in");
	}

	{
		System.out.print("in2");
	}

	public static void main(String arg[]) {
		ObjectInitSequence i = new ObjectInitSequence();
	}

}
