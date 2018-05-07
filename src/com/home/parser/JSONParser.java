package com.home.parser;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

public class JSONParser {
	public static void main(String[] args) {
		JSONObject j = new JSONObject();
		String s = null;
		j.put("k", "");
		
		String v = j.optString("k", null);
		System.out.println("Result K" + v);
		if(StringUtils.isEmpty(v)) {
			System.out.println("Blank");
		}
		
		String value = j.optString("a", null);
		System.out.println("Result A" + value);
		if(StringUtils.isEmpty(value)) {
			System.out.println("Blank");
		}
		int val =-1;
		val = j.optInt("NotPresent" );
		System.out.println("optInt default is "+val);
		

	}
}
