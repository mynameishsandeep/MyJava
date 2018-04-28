package com.sample.basics;

public class StringReplaceAll {

	public static void main(String[] args) {

		String input = "This is a testa";
		String findString = "a";
		String replaceString = "Hello";
		System.out.println(input.replaceFirst(" " + findString +" ", " " + replaceString + " "));
		
	}
}
