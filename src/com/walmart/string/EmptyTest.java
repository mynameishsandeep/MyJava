package com.walmart.string;

import org.apache.commons.lang.StringUtils;

public class EmptyTest {

	public static void main(String[] args) {
		String s = "   ";
		if (s.trim().isEmpty()) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		StringUtils.isEmpty(s);


	}

}
