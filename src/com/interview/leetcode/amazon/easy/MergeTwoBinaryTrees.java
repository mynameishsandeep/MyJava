package com.interview.leetcode.amazon.easy;

import java.util.LinkedList;
import java.util.Queue;

import com.interview.leetcode.TreeNode;

/*
* https://leetcode.com/problems/merge-two-binary-trees/description/
*==============Solution Using Queue===================
* 1) If either one null return other.
* 2) Add root as pair in queue.
* 3) Keep root1 as result.
* 3a) ==============Start the loop==============
* 4) Add value from root1 & root2 and update root1.
* 5) Now 4 cases comes b4 adding left of both
*    case 1) (t1.left != null && t2.left != null)
*    case 2) t1.left == null && t2.left != null
*    case 3) t1.left != null && t2.left == null
*    case 4) t1.left == null && t2.left == null
*  In case3 and case4 no need to do anything, because t1 is the result.
* 6) Apply step4 to right.
*==============Solution Using Forward Recursion===================
*1) "Solution Using Queue" can be applied with recursion stack.
*==============Solution Using Recursion - BackTrack - Best short solution===================
*  Just explain-understand with 2 nodes in root1 and root2
*	 |     root1	|		root2           |			result
*	 |		60		|			60			|			120
*	 |			70	|		50				|  		50		70
============================================================================
*	 |     root1	|		root2           |			result
*	 |		60		|			60			|			120
*	 |	50			|				70		|  		50		70

*
*	if root1 null. return root2.
*	if root2 null. return root1.
*  root1.left = assign left.
*  root1.left = assign right.
*
*  return root1
*
*/
public class MergeTwoBinaryTrees {

  public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    if (root1 == null) return root2;
    if (root2 == null) return root1;
    root1.val += root2.val;
    root1.left = mergeTrees(root1.left, root2.left);
    root1.right = mergeTrees(root1.right, root2.right);
    return root1;
  }

  public TreeNode mergeTreesCreateThirdNode(TreeNode root1, TreeNode root2) {
    if (root1 == null) return root2;
    if (root2 == null) return root1;
    TreeNode root3 = new TreeNode(root1.val + root2.val);
    root3.left = mergeTreesCreateThirdNode(root1.left, root2.left);
    root3.right = mergeTreesCreateThirdNode(root1.right, root2.right);
    return root3;
  }

  public TreeNode mergeTreesForwardRecursion(TreeNode root1, TreeNode root2) {
    if (root1 == null) return root2;
    if (root2 == null) return root1;
    recur(root1, root2);
    return root1;
  }

  public void recur(TreeNode root1, TreeNode root2) {
    root1.val += root2.val;
    if (root1.left != null && root2.left != null) {
      recur(root1.left, root2.left);
    } else if (root1.left == null && root2.left != null) {
      root1.left = root2.left;
    }
    if (root1.right != null && root2.right != null) {
      recur(root1.right, root2.right);
    } else if (root1.right == null && root2.right != null) {
      root1.right = root2.right;
    }
  }

  public TreeNode mergeTreesBFS(TreeNode root1, TreeNode root2) {
    Queue<TreeNode[]> q = new LinkedList<>();
    if (root1 == null) return root2;
    if (root2 == null) return root1;
    q.offer(new TreeNode[] {root1, root2});
    while (!q.isEmpty()) {
      TreeNode[] t1T2 = q.poll();
      TreeNode t1 = t1T2[0];
      TreeNode t2 = t1T2[1];
      t1.val += t2.val;
      if (t1.left != null && t2.left != null) {
        q.offer(new TreeNode[] {t1.left, t2.left});
      } else if (t1.left == null && t2.left != null) {
        t1.left = t2.left;
      }
      if (t1.right != null && t2.right != null) {
        q.offer(new TreeNode[] {t1.right, t2.right});
      } else if (t1.right == null && t2.right != null) {
        t1.right = t2.right;
      }
    }
    return root1;
  }
}
