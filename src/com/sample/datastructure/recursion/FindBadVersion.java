package com.sample.datastructure.recursion;

/**
 * https://leetcode.com/problems/first-bad-version/description/
 * 
 * @author chandrasekhar
 *
 */
public class FindBadVersion {

	public static void main(String[] args) {

		System.out.println(new FindBadVersion().firstBadVersion(2126753390));
	}

	public int firstBadVersion(int n) {
		return recurse(1, n);
	}

	public Integer recurse(int low, int high) {
		if (low <= high) {
			int mid = low + ((high - low) / 2);
			if (isBadVersion(mid)) {
				return Math.min(recurse(low, mid - 1), mid);
			}
			return recurse(mid + 1, high);
		}
		return Integer.MAX_VALUE;
	}

	public Boolean isBadVersion(int version) {
		if (version >= 1702766719) {
			return true;
		}

		return false;

	}
}
