package com.sample.basics;

import java.util.Scanner;
import java.util.regex.Pattern;

public class PatternExample {

	public static void main(String[] args) {

		try (Scanner in = new Scanner(System.in)) {

			Pattern pattern = Pattern.compile("[ !,?.\\_\'@]+");
			String input = in.nextLine().trim();
			if(0 == input.length()) {
				System.out.println("0");
				return;
			}
			String output[] = pattern.split(input);
			System.out.println(output.length);
			for (int i = 0; i < output.length; i++) {
				System.out.println(output[i]);
			}


		}
	}
}
