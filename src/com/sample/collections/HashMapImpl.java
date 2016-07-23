package com.sample.collections;

/**
 *http://www.javamadesoeasy.com/2015/02/hashmap-custom-implementation.html
 * This is a simple Hashmap implementation.
 * 1) collission logic not implemented
 * 2) simple mod based logic for identifying right bucket during put and get
 * @author Thangaprabhu
 *
 * @param <K>
 * @param <V>
 */
class MyHashMap<K, V> {
	static class Node<K, V> {
		K key;
		V value;
		Node<K, V> next;
	}

	int size = 0;
	Node<K, V>[] entry;

	public <K, V> MyHashMap() {
		entry = new Node[16]; // 16 index hash....
	}

	public void get(K key) {
		System.out.println(entry[hash(key)].value);
	}

	public int hash(K key) {
		int hashKey = new Integer(key.toString().hashCode());
		return hashKey % 16;
	}

	public void put(K key, V value) {
		Node<K, V> node = new Node<>();
		node.key = key;
		node.value = value;
		Node temp = entry[hash(key)];
		if (temp == null) {
			entry[hash(key)] = node;
		} else {//Find duplicate key
			if(temp.key == key) {
				
			}
		}
		size++;
	}
	
}

public class HashMapImpl {

	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap<>();
		map.put(1, "value");
		map.put(2, "value2");
		map.get(1);
		map.get(2);
	}

}
