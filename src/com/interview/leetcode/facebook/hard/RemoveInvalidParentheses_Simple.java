package com.interview.leetcode.facebook.hard;

/*
 * https://leetcode.com/problems/remove-invalid-parentheses/
 * 
 *  1) 
 */
public class RemoveInvalidParentheses_Simple {

	public void removeInvalidParentheses(String s) {

		dfs(s, "", 0);
	}

	public void dfs(String left, String right, int countLeft) {

		if (left.length() == 0) {
			return;
		}
		System.out.println(left + right);
		if (left.charAt(0) == '(') {
			dfs(left.substring(1), right + "(", countLeft + 1);//keep (
			dfs(left.substring(1), right, countLeft);//drop (
		} else if (left.charAt(0) == ')') {
			if (countLeft > 0) {
				dfs(left.substring(1), right + ")", countLeft - 1);
			}
			dfs(left.substring(1), right, countLeft);
		} else {
			dfs(left.substring(1), right + String.valueOf(left.charAt(0)), countLeft);
		}

	}

	public static void main(String[] args) {
		RemoveInvalidParentheses_Simple r = new RemoveInvalidParentheses_Simple();
		r.removeInvalidParentheses("(()");
		System.out.println();
	}
}
