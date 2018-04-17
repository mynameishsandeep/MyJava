package com.interview.leetcode.amazon.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 2 points missed. 
 * 1) Ignore punctuation or split also by punctuation
 * 2) wordsToExclude ignorecase is not implemented
 */
public class OnlineTest2 {

	private boolean containsIgnoreCase(List<String> list, String soughtFor) {
	    for (String current : list) {
	        if (current.equalsIgnoreCase(soughtFor)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	// METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
	List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {
		if (null == literatureText) {
			return null;
		}
		String[] literatureTextArray = literatureText.split("[ (){}?!'.,;:\"]");
		Integer max = 1;
		Map<String, Integer> map = new HashMap<>();
		for (String literatureTextItem : literatureTextArray) {
			if (!wordsToExclude.contains(literatureTextItem.toLowerCase())) {
				Integer itemCount = map.get(literatureTextItem.toLowerCase());
				if (itemCount == null) {
					map.put(literatureTextItem.toLowerCase(), 1);
				} else {
					map.put(literatureTextItem.toLowerCase(), itemCount + 1);
					if (itemCount + 1 > max) {
						max = itemCount + 1;
					}
				}

			}
		}

		List<String> result = new ArrayList<>();
		for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
			if (max == mapEntry.getValue()) {
				result.add(mapEntry.getKey());
			}
		}
		return result;
	}
	// METHOD SIGNATURE ENDS
}
