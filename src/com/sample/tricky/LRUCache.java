package com.sample.tricky;

import java.util.Map;
import java.util.TreeMap;

public class LRUCache {

    private  Map<Integer, String> cache;
    private Integer index = 0;
    private final Integer CACHE_SIZE;
    
    public LRUCache(int size) {
        cache = new TreeMap<>();
        CACHE_SIZE = size;
    }
    public void addProduct(String product) {
        if(CACHE_SIZE == cache.size()) {
            // Evict a Element
        	cache.remove(cache.entrySet().iterator().next().getKey());
        }
        cache.put(++index, product);
    }
    
    public String getProduct(String product) {
        //Check from Cache before going real service.
        Integer index = null;//cache.get(product);// Use BiDirectional Map Here to get key from value
        cache.remove(index);
        cache.put(++index, product);
        return product;
    }
    
}
