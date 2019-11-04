package com.interview.leetcode.amazon.easy;

/*
 * https://leetcode.com/problems/design-hashmap

https://leetcode.com/problems/design-hashmap/discuss/238843/Separate-Chaining-Java-Solution
https://leetcode.com/problems/design-hashmap/discuss/295547/Easy-Java-Code
====Mixed best approach from above 2 link========
1) The general implementation of HashMap uses bucket which is basically a chain of linked
lists and each node containing <key, value> pair.
2) When we insert the pair (10, 20) and then (10, 30), there is technically no collision involved.
We are just replacing the old value with the new value for a given key 10, since in both cases,
10 is equal to 10 and also the hash code for 10 is always 10.
3) Collision happens when multiple keys hash to the same bucket. In that case,
we need to make sure that we can distinguish between those keys. Chaining collision resolution
is one of those techniques which is used for this.
4) Just for the information. In JDK 8, HashMap has been tweaked so that if keys can be compared for ordering,
then any densely-populated bucket is implemented as a tree, so that even if there are lots of
entries with the same hash-code, the complexity isO(log n).

Time complexity: O(1) average and O(n) worst case - for all get(),put() and remove() methods.
Space complexity: O(n) - where n is the number of entries in HashMap

========PUT Operation========
1) During the first time. head is null. So create a node and assign it to entry[hashKey].
2) During the second time.
		a) If node has collision, then the new node will be chained at first. Entry Used will be 1.
		b) If there is duplicate, then existing node data will be replaced. Entry Used will be 1.
		c) Else node will be entered in new Entry. Entry Used will be 2.
	=========Tricky How Collision works in PUT==========================
		table[hash] = new Entry(key, value, table[hash]);
		1) Above code "third argument --> table[hash]" is tricky.
		2) Lets say my hashCode always returns 100. All data lands in same bucket due to collision.
		3) During first time table[hash] will be null
		4) During second time table[hash] will have previous value in step3
		5) During third time table[hash] will have previous value in step4
		6) So data will chained like "third-->second-->first" on bucket 100.
=========REMOVE Operation===========
1) If the hashKey is not found. Then data not found. No Operation.
1) If the node to be deleted is at first. Then I need to connect the bucket head with 2nd node.
2) For rest of the case simply join next with next.next
==========FIND=======
find will be used during PUT and GET to verify node exists or not
===============
 */
public class DesignHashMap {
  static class Entry {
    private int key, val;
    private Entry next;

    public Entry(final int key, final int val, final Entry next) {
      this.key = key;
      this.val = val;
      this.next = next;
    }
  }

  private Entry[] table = new Entry[10000];

  /*
   * 1) During collision (PUT operation) find will return null.
   * 2) During duplicate it will return node.
   */
  private Entry find(final Entry entry, final int key) {
    if (entry == null) return null;
    if (entry.key == key) return entry;
    return find(entry.next, key);
  }

  private int getHashKey(final int key) {
    return key % 10000;
  }

  public void put(final int key, final int value) {
    int hash = getHashKey(key);
    Entry head = table[hash];
    if (head == null) table[hash] = new Entry(key, value, null);
    else {
      Entry existingEntry = find(head, key);
      if (existingEntry != null) existingEntry.val = value;
      else table[hash] = new Entry(key, value, head);
    }
  }

  /**
   * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping
   * for the key
   */
  public int get(final int key) {
    int hashKey = getHashKey(key);
    Entry existingEntry = find(table[hashKey], key);
    if (existingEntry != null) return existingEntry.val;
    return -1;
  }

  public void remove(final int key) {
    int hashKey = getHashKey(key);
    Entry head = table[hashKey];
    if (head == null) return;
    if (head.key == key) table[hashKey] = head.next;
    else
      for (Entry e = head; e.next != null; e = e.next)
        if (e.next.key == key) {
          e.next = e.next.next;
          return;
        }
  }

  public static void main(String[] args) {
    DesignHashMap hashMapCustom = new DesignHashMap();
    hashMapCustom.put(1, 1);
    hashMapCustom.put(2, 2);
    hashMapCustom.put(3, 3);
    hashMapCustom.remove(1);
    hashMapCustom.put(35, 89);
    System.out.println("value corresponding to key 21=" + hashMapCustom.get(21));
    System.out.println("value corresponding to key 51=" + hashMapCustom.get(51));
  }
}
