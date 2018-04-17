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
	 * The idea is similar as the two pointer solution for the sorted two sum problem. 
	 * 
	 * 1) First loop identify the celebrity by 2sum approach.
	 * 2) Second loop assures celebrity.
	 * Take the selected celebrity call "knows" against each person 
	 * 	1) each person know him 2) celebrity doesn't know that person. 
	 * 
	 * EX: for n people... instead of calling n square times... we are finding 1
	 * people. Then calling knows for that one... which makes this solution
	 * calling knows 2n time
	 * 
	 * So the complexity of the program is O(3n) that is approximately equal to O(n)
	 */
	public int findCelebrity(int n) {
		int left = 0;
		int right = n - 1;
		int celeb = -1;
		while (left < right) {
			if (knows(left, right)) {
				celeb = right;
				left++;
			} else {
				celeb = left;
				right--;
			}
		}
		for (int i = 0; i < n; i++) {
			// skip the self compare on celebrity
			if (i != celeb) {
				// Make sure current one knows celebrity
				if (knows(i, celeb)) {
					// Make sure celebrity doesn't know the current one
					if (!knows(celeb, i)) {
					} else {
						celeb = -1;
						break;
					}
				} else {
					celeb = -1;
					break;
				}
			}
		}
		return celeb;
	}

	// Not completed fully
	public boolean knows(int i, int j) {
		return true;
	}
}
