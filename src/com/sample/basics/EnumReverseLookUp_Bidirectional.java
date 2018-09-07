package com.sample.basics;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EnumReverseLookUp_Bidirectional {
	public enum Status {
		WAITING(0), READY(1), SKIPPED(-1), COMPLETED(5);

		private int code;
		private static final Map<Integer, Status> LOOKUP = new HashMap<Integer, Status>();
		static {
			for (Status s : EnumSet.allOf(Status.class))
				LOOKUP.put(s.getCode(), s);
		}

		private static final Set<String> LOOKUP_BY_KEY = new HashSet<>();
		static {
			for (Status s : EnumSet.allOf(Status.class))
				LOOKUP_BY_KEY.add(s.name());
		}

		public static boolean contains(final String key) {
			return LOOKUP_BY_KEY.contains(key);
		}

		private Status(int code) {
			this.code = code;
		}

		public int getCode() {
			return code;
		}

		public static Status get(int code) {
			return LOOKUP.get(code);
		}
	}

	public static void main(String[] args) {
		System.out.println(Status.get(0));
		System.out.println(Status.contains("READY"));
		System.out.println(Status.contains("READ"));
	}
}
