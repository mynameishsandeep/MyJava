package com.sample.tricky;

import java.util.Scanner;

/*
 * 
 * 
Sample Input:
 
5 4
1 2 3 4 5

Output:
1 2 3 4 5 - input
2 3 4 5 1 - 1st rotation
3 4 5 1 2 - 2nd rotation
4 5 1 2 3 - 3rd rotation
5 1 2 3 4 - 4th rotation


 */
public class RotateLeftArrayAndPrint {

	public static void main(String[] args) {
		try (Scanner scan = new Scanner(System.in)) {
			int n = scan.nextInt();
			int r = scan.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextInt();
			}
			// If the rotation size is greater than array size. Tllllhen below will work
			// Ex: 6 % 5--- Then rotate 1 time
			int start = r % n;

			for (int i = start, j = 0; j < n; j++) {
				System.out.println(arr[i]);
				i++;
				if (i == n) {
					i = 0;
				}
			}
		}
	}

}