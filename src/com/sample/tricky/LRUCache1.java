package com.sample.tricky;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache1<K, V> extends LinkedHashMap<K, V> {
	    private int size;

	    public static void main(String[] args) {
	    	LRUCache1<Integer, Integer> cache = LRUCache1.newInstance(10);
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

	        System.out.println(cache);
	    }

	    private LRUCache1(int size) {
	        super(size, 0.75f, true);
	        this.size = size;
	    }

	   @Override
	    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
	        return size() > size;
	    }

	    public static <K, V> LRUCache1<K, V> newInstance(int size) {
	        return new LRUCache1<K, V>(size);
	    }

	}