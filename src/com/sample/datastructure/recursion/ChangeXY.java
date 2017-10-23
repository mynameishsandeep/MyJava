package com.sample.datastructure.recursion;

public class ChangeXY {
	public static void main(String[] args) {
		System.out.println(new ChangeXY().changeXY("codex"));
	}

	public String changeXY(String str) {
		if (str.length() == 0) {
			return "";
		}
		if (str.charAt(0) == 'x') {
			return "y" + changeXY(str.substring(1, str.length()));
		} else {
			return str.charAt(0) + changeXY(str.substring(1, str.length()));
		}

	}

}
