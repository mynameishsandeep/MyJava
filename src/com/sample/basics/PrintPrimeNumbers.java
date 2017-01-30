package com.sample.basics;

public class PrintPrimeNumbers {

	public static void main(String[] args) {
		
		int n = 100;
		for (int i=2; i<=n; i++) {
			int counter = 0;
			for(int j=2; j<=i; j++) {
				if(i%j==0) {
					counter++;
				}
				if(counter==2) {
					break;
				}
			}
			if(counter==1) {
				System.out.println(i);
			}
		}

	}

}
