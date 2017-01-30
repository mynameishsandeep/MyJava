package com.sample.basics;

public class Sample {
	public static void main(String[] args) {
		
	}
	public String reverse(String input) {
		if(input.length()==1) {
			return input;
		}
		return reverse(input.substring(1)+input.charAt(0));
	}
}
