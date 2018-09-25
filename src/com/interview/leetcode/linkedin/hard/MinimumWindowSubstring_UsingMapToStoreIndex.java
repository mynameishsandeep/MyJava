package com.interview.leetcode.linkedin.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/minimum-window-substring/description/
 * 
 */
/*
 * Below code works only when search string doesn't have duplicates
 * 
 * 1) Put the search string in a Set.
 * 2) Iterate input String.
 * 3) If the input.char(i) present in SearchStringSet 
 * 4) Save the "input.char(i)" with "index" in a map
 * 5) if the "size of map" == "max length of search string" 1 result formed.
 * 6) Get the min index and max index from the map and do substring on input, Which gets 1 result 
 * 
 *  
 */
public class MinimumWindowSubstring_UsingMapToStoreIndex {

	public String minWindow(String s, String t) {
		if (t.length() > s.length()) {
			return "";
		}
		final Map<Character, Integer> duplicateCheck = new HashMap<>();
		for (Character c : t.toCharArray()) {
			if (duplicateCheck.containsKey(c)) {
				duplicateCheck.put(c, duplicateCheck.get(c) + 1);
			} else {
				duplicateCheck.put(c, 1);
			}
		}
		return pangram(s, duplicateCheck, t);
	}

	public String pangram(final String input, final Map<Character, Integer> duplicateCheck, final String searchString) {
		boolean subStringFilledOnce = false;
		//List<String> allResult = new ArrayList<>();
		String finalResult = null;
		Map<Character, List<Integer>> subStringMap = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			System.out.println(subStringMap);
			if (duplicateCheck.containsKey(input.charAt(i))) {
				if (subStringMap.containsKey(input.charAt(i))) {
					subStringMap.get(input.charAt(i)).add(i);
				} else {
					subStringMap.put(input.charAt(i), new ArrayList<>(Arrays.asList(i)));
				}

				if (subStringFilledOnce || verifySubStringFilled(subStringMap, duplicateCheck, searchString.length())) {
					subStringFilledOnce = true;
					String result = getTheSubString(subStringMap, duplicateCheck, input);
					if (finalResult == null || finalResult.length() > result.length()) {
						finalResult = result;
					}
					//allResult.add(result);
				}
			}
		}
		//System.out.println(allResult.toString());

		return finalResult == null ? "" : finalResult;
	}

	private String getTheSubString(final Map<Character, List<Integer>> subStringMap,
			Map<Character, Integer> duplicateCheck, String input) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (Map.Entry<Character, Integer> entry : duplicateCheck.entrySet()) {
			List<Integer> l = subStringMap.get(entry.getKey());
			for (int i = l.size() - 1; i >= l.size() - entry.getValue(); i--) {
				if (l.get(i) < min) {
					min = l.get(i);
				}
				if (l.get(i) > max) {
					max = l.get(i);
				}
			}
		}

		return input.substring(min, max + 1);
	}

	private Boolean verifySubStringFilled(final Map<Character, List<Integer>> subStringMap,
			Map<Character, Integer> duplicateCheck, Integer keyLength) {
		System.out.println("called");
		for (Map.Entry<Character, Integer> entry : duplicateCheck.entrySet()) {
			if (!subStringMap.containsKey(entry.getKey())) {
				return false;
			}
			if (subStringMap.get(entry.getKey()).size() < entry.getValue()) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		MinimumWindowSubstring_UsingMapToStoreIndex m = new MinimumWindowSubstring_UsingMapToStoreIndex();
		System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
		//System.out.println(m.minWindow("AA", "AA"));
		//System.out.println(m.minWindow("acbbaca", "aba"));
		//System.out.println(m.minWindow("aaflslflsldkalskaaa", "aaa"));
		//System.out.println(m.minWindow("bba", "ab"));

	}
}
