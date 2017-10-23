package com.walmart.string;

public class RemoveCharacterFromEnd {

	public static void main(String[] args) {
		System.out.println(removeDot("a.b.c."));
		System.out.println(removeDot("a.b."));
		System.out.println(removeDot("a."));
	}
	
	public static String removeDot(String input) {
		//String input = "a.b.c.";
		int index = 0;
		int prevIndex = 0;
		for(int i=0; i<input.length(); i++) {
			if(input.charAt(i)=='.') {
				prevIndex = index;
				index = i;
			}
		}
		if(prevIndex==0) {
			return "";
		}
		return input.substring(0, prevIndex+1);
	}
}
