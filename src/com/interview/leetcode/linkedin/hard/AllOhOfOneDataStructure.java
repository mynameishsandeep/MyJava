package com.interview.leetcode.linkedin.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/all-oone-data-structure/discuss/91383/An-accepted-JAVA-solution-detailed-explanation.(HashMap-+-double-linked-list)

      =====Operations to be Implemented in O(1)=======
1) Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
2) Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
3) GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
4) GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
=====Why Can't I use simple HashMap=====
1) If I keep Map<String,Integer> where integer keeps count of Key.
2) Inc/Dec will work perfectly.
3) But after Increment and Decrement, MaxKey and MinKey will be changed. So O(1) operation is not possible.
===========================================

* Look into the picture "AllOhOneDataStructure.png"
*
* 1) hashMap key is key(count of string) itself, value is doubleLinkedList.
* 2) tail holds the lowest count value
* 3) head holds the highest count value
* 4) If there is a duplicate in value it will be saved in existing node.
* 5) To save a, b... there will be 2 key in map, but there will be only one doubleLinkedList node.
* But the doubleLinkedList curKeys will have 2 keys. i.e tail (curKeys)will be updated.
* 6) To save a, a, b... there will be 2 key in map, and there will be 2 doubleLinkedList node.
*  tail will have value 1 with curKeys(b). head will have value 2 with curKeys(a)
* 7) To save a, a, b, c, c, c, d... there will be 4 key in map, but there will be 3 doubleLinkedList node.
* tail will have value 1 with curKeys(b,d). head will have value 3 with curKeys(c).
* there will be a node between tail with value 2 and curKeys(a).
==============Solution==========
	 =====inc operation=====
1) Very first time, tail will be null. Create DLL node. Update head and tail both with this new node. Add node to map.
 
*/
public class AllOhOfOneDataStructure {
  static class DoubleLinkedList {
    private DoubleLinkedList preNode;
    private DoubleLinkedList nextNode;
    private int countOfKey; // number of occurances of Key
    private Set<String> curKeys; // store the key at the value of curNode.value;

    public DoubleLinkedList(int value, String key) {
      this.countOfKey = value;
      curKeys = new HashSet<>();
      curKeys.add(key);
    }
  }

  private DoubleLinkedList head;
  private DoubleLinkedList tail;
  private HashMap<String, DoubleLinkedList> keyMap = new HashMap<>();

  /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
  public void inc(String key) {
    if (tail == null) { // which means head must be null too and the keyMap must be empty.
      DoubleLinkedList curNode = new DoubleLinkedList(1, key);
      head = curNode;
      tail = curNode;
      keyMap.put(key, curNode);
    } else if (!keyMap.containsKey(key)) { // which means that this key should be add to the tail.
      if (tail.countOfKey == 1) { // which means just add the key to the tail list.
        tail.curKeys.add(key);
        keyMap.put(key, tail);
      } else { // which means have to add a value= 1 node.
        DoubleLinkedList curNode = new DoubleLinkedList(1, key);
        curNode.preNode = tail;
        tail.nextNode = curNode;
        tail = curNode;
        keyMap.put(key, curNode);
      }
    } else { // which the string already exists.
      DoubleLinkedList curNode = keyMap.get(key);
      if (curNode.preNode != null) { // which means the node is in the middle.
        if (curNode.preNode.countOfKey == curNode.countOfKey + 1) {
          curNode.preNode.curKeys.add(key);
          curNode.curKeys.remove(key);
          keyMap.put(key, curNode.preNode);
          checkEmpty(curNode);
        } else { // which means the preNode value != curNode.value;
          DoubleLinkedList newNode = new DoubleLinkedList(curNode.countOfKey + 1, key);
          newNode.preNode = curNode.preNode;
          newNode.nextNode = curNode;
          newNode.preNode.nextNode = newNode;
          curNode.preNode = newNode;
          curNode.curKeys.remove(key);
          keyMap.put(key, newNode);
          checkEmpty(curNode);
        }
      } else { // which means the node is the head. so we build a new head.
        head = new DoubleLinkedList(curNode.countOfKey + 1, key);
        head.nextNode = curNode;
        curNode.preNode = head;
        curNode.curKeys.remove(key);
        keyMap.put(key, head);
        checkEmpty(curNode);
      }
    }
  }

  /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
  public void dec(String key) {
    if (head == null || !keyMap.containsKey(key)) return; // which means nothing here.
    // or  means no key in the structrue.
    DoubleLinkedList curNode = keyMap.get(key);
    if (curNode.nextNode != null) { // which means the node is in the middle.
      if (curNode.nextNode.countOfKey == curNode.countOfKey - 1) { // which means we can just
        curNode.nextNode.curKeys.add(key);
        curNode.curKeys.remove(key);
        keyMap.put(key, curNode.nextNode);
        checkEmpty(curNode);
      } else { // which means the nextNode value != curNode.value-1;
        DoubleLinkedList newNode = new DoubleLinkedList(curNode.countOfKey - 1, key);
        newNode.nextNode = curNode.nextNode;
        newNode.preNode = curNode;
        newNode.nextNode.preNode = newNode;
        curNode.curKeys.remove(key);
        curNode.nextNode = newNode;
        keyMap.put(key, newNode);
        checkEmpty(curNode);
      }
    } else { // which means the node is the tail. so we build a new head.
      if (curNode.countOfKey == 1) { // just to delete the key.
        curNode.curKeys.remove(key);
        keyMap.remove(key);
        checkEmpty(curNode);
      } else { // build another tail.
        tail = new DoubleLinkedList(curNode.countOfKey - 1, key);
        tail.preNode = curNode;
        curNode.nextNode = tail;
        curNode.curKeys.remove(key);
        keyMap.put(key, tail);
        checkEmpty(curNode);
      }
    }
  }

  /** Returns one of the keys with maximal value. */
  public String getMaxKey() {
    if (head == null) return ""; // which means nothing here.
    return head.curKeys.iterator().next();
  }

  /** Returns one of the keys with Minimal value. */
  public String getMinKey() {
    if (tail == null) return ""; // which means nothing here.
    return tail.curKeys.iterator().next();
  }

  // to check whether the node should be delete because the keyList is empty.
  private void checkEmpty(DoubleLinkedList checkNode) {
    if (!checkNode.curKeys.isEmpty()) return;
    if (checkNode.preNode == null && checkNode.nextNode == null) {
      tail = null;
      head = null;
    } else if (checkNode.preNode == null && checkNode.nextNode != null) {
      head = checkNode.nextNode;
      head.preNode = null;
    } else if (checkNode.nextNode == null && checkNode.preNode != null) {
      tail = checkNode.preNode;
      tail.nextNode = null;
    } else {
      checkNode.preNode.nextNode = checkNode.nextNode;
      checkNode.nextNode.preNode = checkNode.preNode;
    }
  }

  public static void main(String[] args) {
    AllOhOfOneDataStructure a = new AllOhOfOneDataStructure();
    a.inc("a");
    a.inc("b");
    a.inc("a");
  }
}
