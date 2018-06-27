package com.sample.collections;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;

public class SetUserDefinedObject {
	public static void main(String[] args) {
		Set<JSONObject> set = new HashSet<>();
		JSONObject j1 = new JSONObject();
		j1.put("id", 1);
		
		JSONObject j2 = new JSONObject();
		j2.put("id", 2);
		
		JSONObject j3 = new JSONObject();
		j3.put("id", 3);
		
		JSONObject j4 = new JSONObject();
		j4.put("id", 1);
		
		set.add(j1);
		set.add(j2);
		set.add(j3);
		set.add(j4);
		
		System.out.println(set);
		
	}
}
