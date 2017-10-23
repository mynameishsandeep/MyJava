package com.sample.basics;

public class PrintPrimeNumbers {

	public static void main(String[] args) {
		
		int n = 100;
		for (int i=2; i<=n; i++) {
			int counter = 0;
			for(int j=2; j<i; j++) {
				if(i!=j && i%j==0) {
					counter++;
				}
				if(counter==1) {
					break;
				}
			}
			if(counter==0) {
				System.out.println(i);
			}
		}

	}

}
