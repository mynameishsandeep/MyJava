package com.sample.collections;

/**
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
		int hash;
		K key;
		V value;
	}

	int size = 0;
	Node<K, V>[] entry;

	public <K, V> MyHashMap() {
		entry = new Node[16];
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
		node.hash = key.hashCode();
		node.key = key;
		node.value = value;
		entry[hash(key)] = node;
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
