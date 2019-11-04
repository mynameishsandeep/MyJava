package com.interview.leetcode.amazon.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.interview.leetcode.TreeNode;
/*
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

============================Note- Recursion vs BFS===============================================
1) This problem is an very good example where recursion stores previous result nicely and reuses it.
2) In case of BFS. I need to store previous result as Pair for each path.
===========================================================================
1) When seeing root with either side not null, calculate currResult for that node.
2) Only at leaf. ie.  cur.left == null && cur.right == null... result will be updated.
===========================================================================
=============Note: Previous result for root node is 0.=====================
				    1        -----level0------
				   / \
				  0   1      -----level1------
		   -----level0------
   					0*2+1 = 1
   		   -----level1------
 					1*2+0 = 2
 					1*2+1 = 3
 					      ===
 					        5
====================================================================================================
				      1       -----level0------
				   /    \
				  0      1    -----level1------
    		     / \    / \
			    0   1  0   1  -----level2------

		   -----level0------
   					0*2+1 = 1
  	       -----level1------
 					1*2+0 = 2
 					1*2+1 = 3
 		   -----level2------
 		 			2*2+0 = 4
 		 			2*2+1 = 5
 		 			3*2+0 = 6
 		 			3*2+1 = 7
 		 			       ===
				            22
====================================================================================================

 */
public class SumOfRootToLeafBinaryNumbers {
  public int sumRootToLeaf(TreeNode root) {
    if (root == null) return result;
    Queue<Object[]> queue = new LinkedList<>();
    queue.offer(new Object[] {root, 0});
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Object[] curr = queue.poll();
        TreeNode cur = (TreeNode) curr[0];
        int prevResult = (Integer) curr[1];
        int currResult = prevResult * 2 + cur.val;
        if (cur.left == null && cur.right == null) {
          result += currResult;
          continue;
        }
        if (cur.left != null) queue.offer(new Object[] {cur.left, currResult});
        if (cur.right != null) queue.offer(new Object[] {cur.right, currResult});
      }
    }
    return result;
  }

  public int sumRootToLeafDFS(TreeNode root) {
    dfs(root, 0);
    return result;
  }

  int result = 0;

  void dfs(TreeNode root, int currResult) {
    currResult = currResult * 2 + root.val;
    if (root.left == null && root.right == null) {
      result += currResult;
      return;
    }
    if (root.left != null) dfs(root.left, currResult);
    if (root.right != null) dfs(root.right, currResult);
  }
}
