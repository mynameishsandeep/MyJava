package com.interview.leetcode.google.medium;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/next-closest-time/solution/
 * 
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. 
 * There is no limit on how many times a digit can be reused.
 * You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 * =====================================================
 * Below is Optimized : 4*4 approach
 * 
 * 1) Split the number and keep it as hour and minute.
 * 2) Put all the numbers into set "i.e allowed number to reuse". So that we can check permutated result number is part of allowed result number in O(1)
 * 3) If the set size is 0 then we can say. There is no next time and current time is next time.
 * 4) Increment the minute by 1, so that we can look result from next number.
 * 5) Convert the hour to String. Ex: 0 to 00, 9 to 09.... 10 to 23 can remain as is.
 * 6) Check if, new permutated(Incremented) hourString is present in set. 
 * 7) If No increment Hour and goto Step5. If yes goto next step. 
 * 8) Convert the minute to String. Ex: 0 to 00, 9 to 09.... 10 to 59 can remain as is.
 * 9) Check if, new permutated(Incremented) minuteString is present in set.
 * 10) If No increment Minute and goto Step 8.
 * 11) If Yes, that is the result.
 *   
 */
public class NextClosestTime {
	Set<Character> set = new HashSet<>();

	public String nextClosestTime(String time) {
		String[] times = time.split(":");
		int hour = Integer.valueOf(times[0]);
		int minute = Integer.valueOf(times[1]);
		if (noNextResult(times)) {
			return time;
		}
		minute++; // I need to calculate from next minute of current time. So incrementing.
		while (true) { // There will be answer all the time. So while true.
			String curHourString = hour < 10 ? "0" + hour : hour + "";// Add "0" for "0 to 9"
			if (set.contains(curHourString.charAt(0)) && set.contains(curHourString.charAt(1))) {
				while (minute < 60) {
					String curMinuteString = minute < 10 ? "0" + minute : minute + ""; // Add "0" for "0 to 9"
					if (set.contains(curMinuteString.charAt(0)) && set.contains(curMinuteString.charAt(1))) {
						return curHourString + ":" + curMinuteString;
					}
					minute++;
				}
				minute = 0; // Reset minute to start from 00.
			}
			hour = ++hour == 24 ? 0 : hour; // Increment hour by 1 and reset to 0 if hour==24
		}
	}

	public static void main(String[] args) {
		NextClosestTime n = new NextClosestTime();
		//System.out.println(n.nextClosestTime("19:34"));
		//System.out.println(n.nextClosestTime("23:59"));
		System.out.println(n.nextClosestTime("20:48"));
	}

	private boolean noNextResult(String[] times) {
		set.add(times[0].charAt(0));
		set.add(times[0].charAt(1));
		set.add(times[1].charAt(0));
		set.add(times[1].charAt(1));
		// For input 11:11 --> the same number itself next number
		if (set.size() == 1) {
			return true;
		}
		return false;
	}
}
