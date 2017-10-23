package com.sample.datastructure.recursion;

public class CountX {

	public static void main(String[] args) {
		System.out.println(new CountX().countX("xxhixx"));
	}
	public int countX(String str) {
		
		if(str.length()==0) {
			return 0;
		}
		if('x'==str.charAt(0)) {
			return 1+ countX(str.substring(1,str.length()));
		} else {
			return countX(str.substring(1,str.length()));
		}
	}

}
