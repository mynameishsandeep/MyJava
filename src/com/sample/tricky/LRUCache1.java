package com.sample.tricky;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache1<K, V> extends LinkedHashMap<K, V> {
	    private int size;

	    public static void main(String[] args) {
	    	LRUCache1<Integer, Integer> cache = LRUCache1.newInstance(2);
	        cache.put(1, 1);
	        cache.put(2, 2);
	        cache.put(1, 1);
	        cache.put(3, 3);

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