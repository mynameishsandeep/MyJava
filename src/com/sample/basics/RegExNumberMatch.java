package com.sample.basics;

public class RegExNumberMatch {
public static void main(String[] args) {
	String regex = "[0-9]+";
	String data = "5>2>1";
	System.out.println(data.matches(regex));
}
}
