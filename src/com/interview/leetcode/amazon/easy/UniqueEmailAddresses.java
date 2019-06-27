package com.interview.leetcode.amazon.easy;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/unique-email-addresses/submissions/
 * 
 * Problem is mostly care about knowing String methods : split, replace, indexOf, substring..
 *
 */
public class UniqueEmailAddresses {
	public int numUniqueEmails(String[] emails) {
		Set<String> set = new HashSet<>();
		for (String email : emails) {
			String[] s = email.split("@");
			String localName = s[0].replace(".", "");
			int index = localName.indexOf('+');
			//System.out.println("localName " + localName);
			if (index != -1) {
				localName = localName.substring(0, index);
			}

			set.add(localName + "@" + s[1]);
		}
		return set.size();
	}
}
