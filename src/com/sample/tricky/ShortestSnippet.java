package com.sample.tricky;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class ShortestSnippet{
    Map<String, List<Integer>> dictMap;

    private void buildDict(Iterator listIterator){
        StringBuilder s = new StringBuilder();
        while(listIterator.hasNext()){
            s = listIterator.next().getString();
            i = listIterator.next().getIndex();
            List<Integer> list;
            if(existsInMap(s)){
                list = dictMap.get(s);
                list.add(i);
            }else{
                list= new ArrayList();
                addToMap(s, i);
            }
        }
    }
    ShortestSnippet(Iterator listIterator){
        dictMap = new HashMap();

        buildDict(listIterator); //todo

    }

    public String shortestWindow(List<String> words){
        List list;
        List<List<Integer>> kLists = new ArrayList();
        for(String word: words){
            if(dictMap.containsKey(word)){
                list = dictMap.get(word);
                kLists.add(list);
            }
        }

        PriorityQueue<Iterator> pqIterators = new PriorityQueue();
        PriorityQueue<Iterator> pq = new PriorityQueue();

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < kLists.size(); i++){
            if(kLists.get(i) != null){
                pq.add(kLists.get(0).get(0)); //get 1st element from every list
                pqIterators.add(kLists.Iterator());
            }
        }

        while(!pq.isEmpty()){
            min = findMin(pq);
            max = findMax(pq);
            diff = Math.min(diff, max-min);
            listIterator = pqIterators.poll();
            pq.offer(listIterator.next());
        }
        return diff;
    }

}