package com.sample.basics;

public class CMtoInches {
	public static void main(String[] args) {
		double centimeters = 13.00;
		 double inches = Math.round( (centimeters / 2.54) * 100 ) / 100.0;
		 System.out.println(inches);
	}

}
