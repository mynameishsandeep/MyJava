package com.sample.tricky;

import java.util.HashMap;

/*
 * https://leetcode.com/problems/lru-cache/
 *
 * https://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 *
 * Logic:
 * 1) Keep new data(when adding/updating data or when an element is accessed) at head.
 * 2) When put is happening and not enough space, remove tail. Add new element to head
 * 3) When get is happening move data from anywhere to head.
 *
 * Tactics:
 * 1) Reason why doubly linked list selected is, during removal operation, get that node. join previous with next.
 * Which makes the operation 0(1). If Single linked list is selected. Then entire list has to be traversed for removal operation O(n).
 * 2) Node key is used in only one scenario. Because when LRU is full. tail is deleted. from tail key,map key is removed.
 *
 *
 * put:
 * 1) add the node to head always.
 * 2) if key exists, replace data. move the node (remove, setHead) to head.
 * 3) if key don't exists, create node.
 * 	  a) if LRU is full, remove tail, add the node to head.
 *    b) Else create node, add it the head.
 * 4) put the node to map.
 *
 * get :
 * 1) Whenever data is accessed, move(remove from current and move) that to head.
 * So, that old data will always present in tail and we can delete tail during LRU is full during put operation.
 * 2) if key is present  do above
 * 3) else -1.
 *
 */
public class LRUCache {
  class DLLNode {
    int key;
    int value;
    DLLNode prevNode;
    DLLNode nextNode;

    public DLLNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  int capacity;
  HashMap<Integer, DLLNode> map = new HashMap<>();
  DLLNode head = null;
  DLLNode tail = null;

  public LRUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      DLLNode n = map.get(key);
      remove(n);
      setHead(n);
      return n.value;
    }

    return -1;
  }

  private void remove(DLLNode n) {
    if (n.prevNode != null) {
      n.prevNode.nextNode = n.nextNode;
    } else {
      head = n.nextNode;
    }

    if (n.nextNode != null) {
      n.nextNode.prevNode = n.prevNode;
    } else {
      tail = n.prevNode;
    }
  }

  private void setHead(DLLNode n) {
    n.nextNode = head;
    n.prevNode = null;

    if (head != null) head.prevNode = n;

    head = n;

    if (tail == null) tail = head;
  }

  public void put(int key, int value) {
    DLLNode old = map.get(key);
    if (old != null) {
      old.value = value;
      remove(old);
      setHead(old);
    } else {
      DLLNode created = new DLLNode(key, value);
      if (map.size() >= capacity) {
        map.remove(tail.key);
        remove(tail);
        setHead(created);

      } else {
        setHead(created);
      }

      map.put(key, created);
    }
  }

  public void print() {
    DLLNode temp = head;
    while (true) {
      if (temp != null) {
        System.out.println(temp.value);
      }
      if (temp.nextNode == null) {
        break;
      } else {
        temp = temp.nextNode;
      }
    }
  }

  public static void main(String[] args) {

    LRUCache cache = new LRUCache(10);
    cache.put(1, 1);
    cache.put(2, 2);
    cache.put(3, 3);
    cache.put(4, 4);
    cache.put(5, 5);
    cache.put(6, 6);
    cache.put(7, 7);
    cache.put(8, 8);
    cache.put(9, 9);
    cache.put(10, 10);

    cache.get(1);

    cache.put(11, 11);

    cache.print();
  }
}
