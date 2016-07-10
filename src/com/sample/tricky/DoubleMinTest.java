package com.sample.tricky;

public class DoubleMinTest {
	public static void main(String[] args) {
		//Double has no negative number. So the min value is smallest fraction Ex: .000000000012 like that
		System.out.println(Math.min(Double.MIN_VALUE, 0.0d)); 
		System.out.println(Math.min(Float.MIN_VALUE, 0.0d));// Float has no negative number.
		System.out.println(Math.min(Long.MIN_VALUE, 0.0d));
		System.out.println(Math.min(Integer.MIN_VALUE, 0.0d));
		System.out.println(Math.min(Byte.MIN_VALUE, 0.0d));
		System.out.println(Math.min(Character.MIN_VALUE, 0.0d));
		
		int  x = Integer.MIN_VALUE-10;
		System.out.println(" OverFlow " + x);
		
		
	}
}
