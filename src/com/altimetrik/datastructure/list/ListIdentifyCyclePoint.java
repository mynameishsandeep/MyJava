package com.altimetrik.datastructure.list;

/*
 * https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 *
1) Detect Loop using single pointer and double pointer approach. Loop point is not same as Cycle point.
2) Count the number of nodes from loop node to loop node, which will give count of nodes from cycle point node to end node.
Let the count be k.
3) Fix one pointer to the head and another to kth node from head.
4) Move both pointers at the same pace, they will meet at last node.
5)  

Ex: [3,2,0,-4]
Cycle is at 2.. That means -4 is connected to 2. Make -4 to point to null.
Note: Self connect in middle node is not possible. Only last nodes connects to any of other node or self itself.

 */
public class ListIdentifyCyclePoint {

  public ListNode detectCycle(ListNode head) {
    ListNode doublePointer = head;
    ListNode singlePointer = head;
    while (doublePointer != null && doublePointer.next != null) {
      singlePointer = singlePointer.next;
      doublePointer = doublePointer.next.next;
      // loop found. But loop point is not cycle point
      if (singlePointer == doublePointer) {
        int totalNodes = getNodeCountFromLoopPointToEnd(singlePointer);
        return removeCyclePoint(head, totalNodes);
      }
    }
    return null;
  }

  private ListNode removeCyclePoint(ListNode head, int k) {
    ListNode node1 = head;
    // move node2 to k node from head
    ListNode node2 = head;
    while (k != 0) {
      node2 = node2.next;
      k--;
    }
    // move both node1 and node2.. The meeting point is cycle point
    while (node1 != node2) {
      node1 = node1.next;
      node2 = node2.next;
    }
    return node1.next = null;
  }

  private int getNodeCountFromLoopPointToEnd(ListNode meetNode) {
    // Get the cycle count
    ListNode node1 = meetNode;
    ListNode node2 = meetNode;
    int k = 0;
    do {
      node2 = node2.next;
      k++;
    } while (node1 != node2);
    return k;
  }
}
