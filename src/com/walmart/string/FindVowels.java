package com.walmart.string;

public class FindVowels {

	public static void main(String[] args) {
		String s = "This is a sample String Input";
		int vowelCount = 0;
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			c = Character.toLowerCase(c);
			switch (c) {
			case 'a':
				System.out.println(++vowelCount + " " + s.charAt(i));
				break;
			case 'e':
				System.out.println(++vowelCount + " " + s.charAt(i));
				break;
			case 'i':
				System.out.println(++vowelCount + " " + s.charAt(i));
				break;
			case 'o':
				System.out.println(++vowelCount + " " + s.charAt(i));
				break;
			case 'u':
				System.out.println(++vowelCount + " " + s.charAt(i));
				break;
			}

		}
		System.out.println(vowelCount);

	}

}
