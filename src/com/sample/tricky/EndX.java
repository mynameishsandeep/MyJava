package com.sample.tricky;

/*
endX("xxre") → "rexx"
endX("xxhixx") → "hixxxx"
endX("xhixhix") → "hihixxx"

before and after how recursion works
 */
public class EndX {

	public String endX(String str) {
		if (str.length() == 0) {
			return "";
		}
		if ('x' == str.charAt(0)) {
			return endX(str.substring(1)) + 'x';
		} else {
			return str.charAt(0) + endX(str.substring(1));
		}
	}

}
