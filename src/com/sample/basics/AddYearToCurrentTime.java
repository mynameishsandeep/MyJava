package com.sample.basics;

import java.util.Calendar;
import java.util.Date;

public class AddYearToCurrentTime {

	public static void main(String[] args) {
		
		System.out.println(set1YearFromNow());
		System.out.println(set1WeekFromNow());
	}
	
	
	public static Long set1YearFromNow() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, 1);
		Date nextYear = cal.getTime();
		return nextYear.getTime();
	}

	public static Long set1WeekFromNow() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 7);
		Date nextYear = cal.getTime();
		return nextYear.getTime();
	}
}
