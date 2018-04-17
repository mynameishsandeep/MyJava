package com.interview.leetcode.amazon.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OnlineTest1 {

	/**
	 *  
	 *
	 */
	public static List<String> reorderLines(int logFileSize, List<String> loglines) {
		TreeMap<String, ArrayList> strLog = new TreeMap<String, ArrayList>();
		LinkedHashMap<String, String> numberLogs = new LinkedHashMap<>();
		for (int i = 0; i < loglines.size(); i++) {
			String identifier = loglines.get(i).split(" ")[0];
			String line = loglines.get(i).replace(identifier, "");
			//System.out.println(line.trim().charAt(0));
			if (line.trim().charAt(0) >= 48 && line.trim().charAt(0) <= 57)
				numberLogs.put(identifier, line);
			else if (!strLog.containsKey(line)) {
				ArrayList<String> list = new ArrayList<>();
				list.add(identifier);
				strLog.put(line, list);
			} else {
				ArrayList oldList = strLog.get(line);
				oldList.add(identifier);
				strLog.put(line, oldList);
			}
		}

		ArrayList finalList = new ArrayList<>();
		TreeMap strLog1 = new TreeMap((strLog));
		Iterator it = strLog.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			String str = (String) pair.getKey();
			ArrayList<String> listIden = (ArrayList<String>) pair.getValue();
			Collections.sort(listIden);
			for (int i = 0; i < listIden.size(); i++) {
				finalList.add(listIden.get(i) + "" + pair.getKey());
			}
			it.remove(); // avoids a ConcurrentModificationException
		}
		it = numberLogs.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			finalList.add(pair.getKey() + "" + pair.getValue());
			it.remove(); // avoids a ConcurrentModificationException
		}

		return finalList;

	}
	public static void main(String[] args) {
		OnlineTest1 s = new OnlineTest1();
		List<String> logLines = new ArrayList<>();
		logLines.add("a123 ab bc");
		logLines.add("23 ab bc");
		logLines.add("023 1cb bc");
		logLines.add("923 bb bc");
		logLines.add("013 1cb bc");
		System.out.println(s.reorderLines(0, logLines));

	}
}
