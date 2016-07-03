package com.sample.basics;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
    private LinkedHashMap<String, String> Cache = null;
    private final int cacheSize;  
    private ReadWriteLock readWriteLock=null;
    public Cache(LinkedHashMap<String, String> psCacheMap, int size) {
        this.Cache = psCacheMap;
        cacheSize = size;
        readWriteLock=new ReentrantReadWriteLock();
    }

    public void put(String sql, String pstmt) throws SQLException{
        if(Cache.size() >= cacheSize && cacheSize > 0){
            String oldSql = Cache.keySet().iterator().next();
            // Add logic to remove 1 item from Cache.
        }
        Cache.put(sql, pstmt);
    }

    public String get(String sql){
        Lock readLock=readWriteLock.readLock();
        try{
            readLock.lock();
            return Cache.get(sql);
        }finally{
            readLock.unlock();
        }
    }

    public boolean containsKey(String sql){
        Lock readLock=readWriteLock.readLock();
        try{
            readLock.lock();
            return Cache.containsKey(sql);
        }finally{
            readLock.unlock();
        }
    }

    public String remove(String key){
        Lock writeLock=readWriteLock.writeLock();
        try{
            writeLock.lock();
            return Cache.remove(key);
        }finally{
            writeLock.unlock();
        }
    }

    public LinkedHashMap<String, String> getCache() {
        return Cache;
    }

    public void setCache(
            LinkedHashMap<String, String> Cache) {
        this.Cache = Cache;
    }


}