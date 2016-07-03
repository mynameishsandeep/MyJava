package com.sample.basics;

public class StaticSample {

	static {
		System.out.println("test");
	} 
	
	{
		System.out.println("Object");
	}
	
	public static void main1(String[] args) {
		System.out.println("test1");
	}
	public static void main(String[] args) {
		StaticSample StaticSample= new StaticSample();
		
		int a[] = new int[10];

		a[0]= 10;
	}

}
