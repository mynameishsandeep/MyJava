package com.sample.basics;

import java.util.Scanner;

public class Dummy {

	public static void main(String args[]) throws Exception {
		
	}
	
	public static int fun() {
		try (Scanner scan = new Scanner(System.in)) {
		} finally {
			System.out.println("Finally");
			try {
			} finally {
				System.out.println("Finallys Finally");
				Dummy d = new Dummy();
				if(d instanceof Object)
				return 2;
			}
			return 1;
		}
	}
}
