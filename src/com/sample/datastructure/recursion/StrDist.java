package com.sample.datastructure.recursion;

public class StrDist {

	public static void main(String[] args) {
		System.out.println(new StrDist().strDist("catcowcat", "cow"));
	}
	public int strDist(String str, String sub) {
		return strDist(str, sub, false, 0, 0);
	}

	public int strDist(String str, String sub, boolean started, int endedMax, int current) {
		if (str.length() < sub.length()) {
			return endedMax;
		}

		if (!started && str.startsWith(sub)) {
			return 0 + strDist(str.substring(1), sub, true, sub.length(), sub.length() + 1);
		}
		if (started && str.startsWith(sub)) {
			return 0 + strDist(str.substring(1), sub, true, current, current + 1);
		}
		if (started) {
			return 0 + strDist(str.substring(1), sub, true, endedMax, current + 1);
		} else {
			return 0 + strDist(str.substring(1), sub, false, endedMax, current);
		}

	}
}
