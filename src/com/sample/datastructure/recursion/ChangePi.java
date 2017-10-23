package com.sample.datastructure.recursion;

public class ChangePi {

	public static void main(String[] args) {
		System.out.println(new ChangePi().changePi("xpix"));
	}

	public String changePi(String str) {
		if (str.length() == 0) {
			return "";
		}
		if (str.length() >= 2 && "pi".equals(str.substring(0, 2))) {
			return "3.14" + changePi(str.substring(2, str.length()));
		} else {
			return str.charAt(0) + changePi(str.substring(1, str.length()));
		}

	}

}
