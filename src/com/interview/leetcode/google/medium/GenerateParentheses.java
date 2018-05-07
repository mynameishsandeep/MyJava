package com.interview.leetcode.google.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/generate-parentheses/description/

The idea here is to only add ')' after '('. 
Solution is based on GroupSum Approach.
But here, move "openCount" and "closeCount" to equal n number of times
Note: it is "openCount<n" and not openCount<closeCount

 */

public class GenerateParentheses {

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		permute(0, 0, result, "", n);
		//permuteModifiedGroupSumStyle(0, 0, result, "", n);
		return result;
	}

	private void permute(int openCount, int closeCount, List<String> result, String currentCombo, int n) {
		if (openCount < n) {
			permute(openCount + 1, closeCount, result, currentCombo + "(", n);
		}
		if (closeCount < openCount) {
			permute(openCount, closeCount + 1, result, currentCombo + ")", n);
		}
		if (openCount + closeCount == n * 2) {
			result.add(currentCombo);
			return;
		}

	}

	private String permuteModifiedGroupSumStyle(int openCount, int closeCount, List<String> result, String currentCombo,
			int n) {
		if (openCount + closeCount == n * 2) {
			return currentCombo;
		}
		String left = "";
		if (openCount < n) {
			left = permuteModifiedGroupSumStyle(openCount + 1, closeCount, result, currentCombo + "(", n);
		}
		String right = "";
		if (closeCount < openCount) {
			right = permuteModifiedGroupSumStyle(openCount, closeCount + 1, result, currentCombo + ")", n);
		}
		if (left != null && !"".equals(left))
			result.add(left);
		if (right != null && !"".equals(right))
			result.add(right);
		return null;

	}

	public static void main(String[] args) {
		GenerateParentheses g = new GenerateParentheses();
		System.out.println(g.generateParenthesis(3));
	}

}
