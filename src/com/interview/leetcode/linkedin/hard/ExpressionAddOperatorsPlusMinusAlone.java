package com.interview.leetcode.linkedin.hard;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/expression-add-operators/solution/
 * 
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators 
 * +, -, or * between the digits so they evaluate to the target value.
 * Solution: 
 * 1) We have multiple choices of what operators to use and what the operands can be and hence, 
 * we have to look at all the possibilities to find all valid expressions.
 * 2) recursion step will have an index and the original string of digits as input along with the expression built till now.
 * 3) At every step, we consider all possible operands starting from index 0 to n-1 i.e. 
 * all substrings digits[index : ]digits[index:] and once we fix an operand, 
 * we will have three recursive calls wherein we try 3 different operators after this operand.

 * Note: The result should include all input characters.
 * 
 * Skipping if condition will get result "-1+2-3+4" for target 2 which is wrong

 */
public class ExpressionAddOperatorsPlusMinusAlone {
	public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<String>();
		if (num == null || num.length() == 0)
			return result;
		helper(result, "", num, target, 0, 0);
		return result;
	}

	public void helper(List<String> result, String prefix, String input, int target, int index, long currentResult) {
		if (index == input.length()) {
			if (target == currentResult) {
				result.add(prefix);
			}
			return;
		}
		for (int i = index; i < input.length(); i++) {
			long suffix = Long.parseLong(input.substring(index, i + 1));
			System.out.println("suffix" + suffix);
			if (index == 0) {
				helper(result, prefix + suffix, input, target, i + 1, suffix);
			} else {
				helper(result, prefix + "+" + suffix, input, target, i + 1, currentResult + suffix);

				helper(result, prefix + "-" + suffix, input, target, i + 1, currentResult - suffix);

			}
		}
	}

	public static void main(String[] args) {
		ExpressionAddOperatorsPlusMinusAlone e = new ExpressionAddOperatorsPlusMinusAlone();
		e.addOperators("123", 6);
		e.addOperators("1234", 2); // Skipping if condition will get result "-1+2-3+4" which is wrong
	}

}
