package com.sample.tricky;

/**
 * https://leetcode.com/problems/find-the-celebrity/discuss/
 *
 * 
 * 1) There will be only 1 celebrity or no celebrity
 * 
 */
public class FindCelebrity {

	/**
	 * I came up with this idea and found that there is already single pointer
	 * solutions which is basically the same. But I think it might be a good
	 * addition to the discussion. The idea is similar as the two pointer
	 * solution for the sorted two sum problem. It should be straight forward to
	 * understand. Please check the code:
	 * 
	 * 1) First loop identify the celebrity 2) Second loop assures celebrity.
	 * 
	 * EX: for n people... instead of calling n square times... we are finding 1
	 * people. Then calling knows for that one... which makes this solution
	 * calling knows 2n time
	 * 
	 */
	public int findCelebrity(int n) {
		if (n < 0)
			return 0;
		int l = 0, r = n - 1;
		while (l < r) {
			if (knows(l, r))
				l++;
			else
				r--;
		}
		int i = 0;
		while (i < n) {
			if (i != l && (knows(l, i) || !knows(i, l)))
				return -1;
			i++;
		}
		return l;
	}
}
