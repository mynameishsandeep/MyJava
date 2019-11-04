package com.interview.leetcode.facebook.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * https://leetcode.com/problems/smallest-range/
 * https://www.educative.io/collection/page/5668639101419520/5671464854355968/5553519291531264
 *
 * Key logic is based on  Merge K Sorted Lists.
 * 1) Insert 0th element of all arrays to minHeap.
 * 2) Cache the rangeEnd or rangeMax, during the step1.
 * 3) Poll a element from heap, which is rangeStart or rangeMin.
 * 4) if rangeEnd-rangeStart is smaller than previous range. update range.
 * 5) If there is next element available, from the list picked in step3. offer it to heap.
 * 6) Update rangeMax.
 * 7) go to step3 till ---minHeap.size() == lists.size()
 *
 *
 * Data Points:
 * Ex1:[[1][4][7]].....output 1,7
 * Ex2:[[1,5][4][7]]...output 4,7
 *
 * 1) pick rangeStart(minimum) from heap.
 * 2) cache rangeEnd using Math.max every time, by comparing 2 element.
 *
 * =====When to end logic==
 *	while (minHeap.size() == lists.size()) {}
 *	if a specific row is exhausted then we can terminate.i.e range cannot be determined further.
 *====================Time Complexity===
 *  O(N∗logM) + N --> O(N∗logM) for priority queue insert/move operation. 
 *  N (Number of Element), M(Number of Rows)  
 *
 */
public class SmallestRange {

  public int[] smallestRange(List<List<Integer>> lists) {
    Queue<Node> minHeap = new PriorityQueue<>((n1, n2) -> n1.element - n2.element);
    int previousRangeStart = 0, previousRangeEnd = Integer.MAX_VALUE;
    int currentRangeStart = 0, currentRangeEnd = 0;
    // put the 1st element of each array in the min heap
    int i = 0;
    for (List<Integer> list : lists) {
      int zeroThElement = list.get(0);
      minHeap.add(new Node(i++, 0, zeroThElement));
      currentRangeEnd = Math.max(currentRangeEnd, zeroThElement);
    }

    // take the smallest element form the min heap, if it gives us smaller range, update the ranges,
    // if the array of the top element has more elements, insert the next element in the heap
    while (minHeap.size() == lists.size()) {
      Node currentNode = minHeap.poll();
      currentRangeStart = currentNode.element;
      if (currentRangeEnd - currentRangeStart < previousRangeEnd - previousRangeStart) {
        previousRangeStart = currentRangeStart;
        previousRangeEnd = currentRangeEnd;
      }
      if (lists.get(currentNode.arrayIndex).size() > currentNode.elementIndex + 1) {
        int nextMinNumber = lists.get(currentNode.arrayIndex).get(currentNode.elementIndex + 1);
        Node nextNode =
            new Node(currentNode.arrayIndex, currentNode.elementIndex + 1, nextMinNumber);
        minHeap.add(nextNode); // insert the next element in the heap
        currentRangeEnd = Math.max(currentRangeEnd, nextMinNumber);
      }
    }
    return new int[] {previousRangeStart, previousRangeEnd};
  }

  static class Node {
    int arrayIndex;
    int elementIndex;
    int element;

    public Node(int arrayIndex, int elementIndex, int number) {
      this.arrayIndex = arrayIndex;
      this.elementIndex = elementIndex;
      this.element = number;
    }
  }

  public static void main(String[] args) {
    SmallestRange s = new SmallestRange();
    List<Integer> l1 = Arrays.asList(1, 5);
    List<Integer> l2 = Arrays.asList(4);
    List<Integer> l3 = Arrays.asList(7);
    List<List<Integer>> lists = new ArrayList<>();
    lists.add(l1);
    lists.add(l2);
    lists.add(l3);
    int[] result = s.smallestRange(lists);
    System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
  }
}
