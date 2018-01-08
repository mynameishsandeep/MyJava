package com.sample.basics;

public class AddYearToCurrentTime {

	public static void main(String[] args) {
		String currentTime = System.currentTimeMillis() +"";
		String currentTimeWith1Year = System.currentTimeMillis()+ (15*24*60*60*1000)+"";
		
		System.out.println(currentTime);
		System.out.println(currentTimeWith1Year);
		
	}
}
