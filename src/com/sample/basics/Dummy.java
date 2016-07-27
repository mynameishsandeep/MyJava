package com.sample.basics;

import java.util.Scanner;

public class Dummy {

	public static void main(String args[] ) throws Exception {
		try(Scanner scan = new Scanner(System.in)) {
			int n = scan.nextInt();
			int s = scan.nextInt();
			int result = -1;
			for(int i=0; i<n; i++) {
				if(s == scan.nextInt()) {
					result = i + 1;
				}
			}
			System.out.println(result);
		}
}
}
