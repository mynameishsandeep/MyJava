package com.sample.tricky;

import java.util.Arrays;

public class PrintTest {
	public static void main(String[] args) throws Exception {
		// Below is a Unicode char representation. 97 is a control character. So nothing will be printed
		char[] chars = new char[] { '\u0097' };
		System.out.println(chars[0]);
		
		String str = new String(chars);
		byte[] bytes = str.getBytes();
		
		System.out.println(Arrays.toString(bytes));
	}
}
