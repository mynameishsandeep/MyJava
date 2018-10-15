package com.interview.leetcode.linkedin.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.interview.leetcode.TreeNode;

/*
 * https://leetcode.com/problems/closest-binary-search-tree-value-ii/discuss/70511/AC-clean-Java-solution-using-two-stacks
 * 
 * 1) Since it is a binary tree, traverse using in-order traversal.
 * 2) Save target and value less than target in stack lowToHigh. (left, root, right)
 * 3) Save value greater than target in stack highToLow.(right, root, left)
 * 4) if target-lowToHigh.peek() <= highToLow.peek()-target. 
 * 5) pop a value from lowToHigh and add it to result.
 * 6) else  pop a value from highToLow and add it to result.
 * 
 * Note: Same problem can be solved using approach "FindKClosestElement.java"
 * 
 * ======Same problem can also be solved using PriorityQueue. ============
 */
public class ClosestBinarySearchTreeValueII {
	/*
	for input [1 2 3 4 5 6 7 8 9 10] with k=2 and target 5.5
	lowToHigh --> 1 2 3 4 5
	highToLow --> 6 7 8 9 10
	*/
	public List<Integer> closestKValues(TreeNode root, double target, int k) {
		Deque<Integer> lowToHigh = new ArrayDeque<>();
		Deque<Integer> highToLow = new ArrayDeque<>();
		inOrder(root, target, lowToHigh, false);
		inOrder(root, target, highToLow, true);
		List<Integer> result = new ArrayList<>();
		while (k > 0) {
			if (lowToHigh.isEmpty()) {
				result.add(highToLow.pop());
			} else if (highToLow.isEmpty()) {
				result.add(lowToHigh.pop());
			} else {
				if (target - lowToHigh.peek() <= highToLow.peek() - target) {
					result.add(lowToHigh.pop());
				} else {
					result.add(highToLow.pop());
				}
			}
			k--;
		}
		return result;
	}

	/*
	 * Optimization to be done
	 * 1) Number of lines can be reduced by passing conditional if inside recursion method.
	 * 2) we can  return if element > target during lowToHigh stack filling 
	 * 			    and  if element < target during highToLow stack filling. 
	 */
	public void inOrder(TreeNode root, double target, Deque<Integer> stack, boolean reverse) {
		if (root == null) {
			return;
		}
		if (!reverse) {
			inOrder(root.left, target, stack, reverse);
			if (root.val <= target) {
				stack.push(root.val);
			}
			inOrder(root.right, target, stack, reverse);
		} else {
			inOrder(root.right, target, stack, reverse);
			if (root.val > target) {
				stack.push(root.val);
			}
			inOrder(root.left, target, stack, reverse);
		}

	}
}
