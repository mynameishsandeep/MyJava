package com.sample.basics;

import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CDLToString {
	public static void main(String[] args) {

		JSONArray j = new JSONArray();
		JSONObject jo = new JSONObject();
		jo.put("k", "v");

		JSONArray jj = new JSONArray();
		jj.put("cat1");
		jj.put("cat2");
		jo.put("categories", jj);

		JSONArray jj1 = new JSONArray();
		jj1.put("cat3");
		jo.put("categories1", jj1);

		j.put(jo);

		System.out.println(CDL.toString(j));
		System.out.println(toString(j));
		System.out.println(CDL.rowToString(j));

	}

	public static String toString(JSONArray ja) throws JSONException {
		JSONObject jo = ja.optJSONObject(0);
		if (jo != null) {
			JSONArray names = jo.names();
			if (names != null) {
				return rowToString(names) + toString(names, ja);
			}
		}
		return null;
	}

	public static String toString(JSONArray names, JSONArray ja) throws JSONException {
		if (names == null || names.length() == 0) {
			return null;
		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ja.length(); i += 1) {
			JSONObject jo = ja.optJSONObject(i);
			if (jo != null) {
				sb.append(rowToString(jo.toJSONArray(names)));
			}
		}
		return sb.toString();
	}

	public static String rowToString(JSONArray ja) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < ja.length(); i += 1) {
			if (i > 0) {
				sb.append(',');
			}
			Object object = ja.opt(i);
			if (object != null) {
				String string = object.toString();
				if (string.length() > 0 && (string.indexOf(',') >= 0 || string.indexOf('\n') >= 0
						|| string.indexOf('\r') >= 0 || string.indexOf(0) >= 0 || string.charAt(0) == '"')) {
					if (object instanceof JSONArray) {
						JSONArray jsonArrayObject = (JSONArray) object;
						sb.append('[');
						for (int j = 0; j < jsonArrayObject.length(); j++) {
							sb.append('"');
							sb.append(jsonArrayObject.get(j));
							sb.append('"');
							sb.append(',');
						}
						sb.delete(sb.length() - 1, sb.length());
						sb.append(']');
					} else {
						sb.append('"');
						int length = string.length();
						for (int j = 0; j < length; j += 1) {
							char c = string.charAt(j);
							if (c >= ' ' && c != '"') {
								sb.append(c);
							}
						}
						sb.append('"');
					}
				} else {
					sb.append(string);
				}
			}
		}
		sb.append('\n');
		return sb.toString();
	}

}
