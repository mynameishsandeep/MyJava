package com.sample.basics;

import java.util.Scanner;

public class ScannerTest {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int i = 0;
		while (true) {
				String s = scan.next();
				System.out.println("Value of S " + s);
				i = Integer.parseInt(s);
				int j = scan.nextInt();
				System.out.println(i + j);
				if (s.equals("\n")) {
					break;
				} 
		}
	}

}
