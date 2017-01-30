package com.sample.designpattern;

import java.util.Locale;
import java.util.Optional;

public class NullPointerPatternOriginal {
	public static void main(String[] args) {
		NullPointerPatternOriginal null1 = new NullPointerPatternOriginal();
		String s1 = null;
		System.out.println(null1.getProductByLocale(Optional.ofNullable(s1)));
		
		String s2 = Locale.US.toString();
		System.out.println(null1.getProductByLocale(Optional.ofNullable(s2)));
		
	}

	public String getProductByLocale(Optional<String> locale) {
		locale.orElse(Locale.US.toString());
		return remoteService(locale.orElse(null));
	}

	private String remoteService(String locale) {
		if (Locale.US.toString().equals(locale)) {
			return "US result";
		} else {
			return "Other result";
		}
	}

}
