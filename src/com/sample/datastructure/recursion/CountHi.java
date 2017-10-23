package com.sample.datastructure.recursion;

public class CountHi {

	public int countHi(String str) {
		  if(str.length()<=1) {
		    return 0;
		  }
		  if("hi".equals(str.substring(0,2))) {
		    return 1 + countHi(str.substring(2,str.length()));
		  } else {
		    return countHi(str.substring(1,str.length()));
		  }
		}

	public static void main(String[] args) {
		System.out.println(new CountHi().countHi("hitehiihi"));
	}
}
