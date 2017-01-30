package com.sample.basics;

import java.util.Locale;

public class LocaleTest {

	public static void main(String[] args) {
		String locale = "ja_JP";
		Locale runTimeLocale = new Locale(locale.substring(0,2), locale.substring(3));
		Locale localeJapan1 = new Locale("ja","jp");
		Locale localeJapan2 = new Locale("ja","JP");
		System.out.println(Locale.JAPAN.equals(runTimeLocale));
		System.out.println(Locale.JAPAN.equals(localeJapan1));
		System.out.println(Locale.JAPAN.equals(localeJapan2));
		System.out.println(runTimeLocale.toString());
	}

}
