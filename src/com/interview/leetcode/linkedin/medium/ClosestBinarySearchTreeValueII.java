package com.interview.leetcode.linkedin.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.interview.leetcode.TreeNode;

/*
* https://leetcode.com/problems/closest-binary-search-tree-value-ii/discuss/70511/AC-clean-Java-solution-using-two-stacks
*
*  1) Traverse and Save the data like "n" shape in to stack. Ex: below
* 					3
*  				2      4
*  				1      5
*  2) Read from top.
*
*
* 1) Traverse using DFS in-order traversal.
* 2) Save target and value less than target in stack lowToHigh. (left, root, right)
* 3) Save value greater than target in stack highToLow.(right, root, left)
* 4) if target-lowToHigh.peek() <= highToLow.peek()-target.
* 5) pop a value from lowToHigh and add it to result.
* 6) else  pop a value from highToLow and add it to result.
*
Ex: [100,80,120,70,90,110,130], target = 95, k = 2
						100
					80		  120
				  70  90    110  130

* Note: Same problem can be solved using approach "FindKClosestElement.java"
*
* ======Same problem can also be solved using PriorityQueue. ============
*/
public class ClosestBinarySearchTreeValueII {
  /*
  for input [70,80,90,100,110,120,130] with k=2 and target 95
  lessThanTarget --> 70 80 90
  moreThanTarget --> 130 120 110 100
  */
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    Deque<Integer> lessThanTargetLEFTToRight = new ArrayDeque<>();
    Deque<Integer> moreThanTargetRIGHTToLeft = new ArrayDeque<>();
    lessThanTargetLEFTToRight(root, target, lessThanTargetLEFTToRight);
    moreThanTargetRIGHTToLeft(root, target, moreThanTargetRIGHTToLeft);
    List<Integer> result = new ArrayList<>();
    while (k > 0) {
      if (lessThanTargetLEFTToRight.isEmpty()) {
        result.add(moreThanTargetRIGHTToLeft.pop());
      } else if (moreThanTargetRIGHTToLeft.isEmpty()) {
        result.add(lessThanTargetLEFTToRight.pop());
      } else {
        if (target - lessThanTargetLEFTToRight.peek()
            <= moreThanTargetRIGHTToLeft.peek() - target) {
          result.add(lessThanTargetLEFTToRight.pop());
        } else {
          result.add(moreThanTargetRIGHTToLeft.pop());
        }
      }
      k--;
    }
    return result;
  }

  public void lessThanTargetLEFTToRight(TreeNode root, double target, Deque<Integer> stack) {
    if (root != null) {
      lessThanTargetLEFTToRight(root.left, target, stack);
      if (root.val < target) {
        stack.push(root.val);
      }
      lessThanTargetLEFTToRight(root.right, target, stack);
    }
  }

  public void moreThanTargetRIGHTToLeft(TreeNode root, double target, Deque<Integer> stack) {
    if (root != null) {
      moreThanTargetRIGHTToLeft(root.right, target, stack);
      if (root.val >= target) {
        stack.push(root.val);
      }
      moreThanTargetRIGHTToLeft(root.left, target, stack);
    }
  }
}
