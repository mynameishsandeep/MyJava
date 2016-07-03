package com.sample.basics;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyBigDecimalFormat {

	public static Currency getCountryCurrencyByLocale() {
		Locale locale = new Locale("en", "in");
		Currency currency = Currency.getInstance(locale);
		System.out.println(currency.getCurrencyCode());
		return currency;
	}

	public static String formatRupees(double value) {
		Currency currency = getCountryCurrencyByLocale();
		NumberFormat format = NumberFormat.getInstance();
		format.setMinimumFractionDigits(currency.getDefaultFractionDigits());
		format.setMaximumFractionDigits(currency.getDefaultFractionDigits());
		return format.format(value);
	}

	public static void main(String[] args) {
		BigDecimal tempBig = new BigDecimal("22.1233");
		System.out.println("tempBig = " + formatRupees(tempBig.doubleValue()));
		tempBig = new BigDecimal("22.1");
		System.out.println("tempBig = " + formatRupees(tempBig.doubleValue()));
	}

}
