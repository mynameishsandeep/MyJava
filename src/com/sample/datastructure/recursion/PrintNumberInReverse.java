package com.sample.datastructure.recursion;

import java.util.Scanner;

public class PrintNumberInReverse {
	public static void main(String args[]) throws Exception {
		try (Scanner scan = new Scanner(System.in)) {
			Integer n = scan.nextInt();
			Integer data[] = new Integer[n];
			print(scan, n, data);
		}
	}

	// Data will be saved from the last, Printed from the first
	public static void print(Scanner scan, Integer n, Integer data[]) {
		if (n == 0) {
			return;
		}
		data[--n] = scan.nextInt();
		print(scan, n, data);
		System.out.println(data[n]);
	}

}
