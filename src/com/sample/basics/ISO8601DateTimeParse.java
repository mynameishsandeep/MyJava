package com.sample.basics;

import java.time.Duration;
import java.time.Period;

public class ISO8601DateTimeParse {
  public static void main(String[] args) {
    String input = "P2YT3H10M";
    String[] v = input.split("T");
    Period p;
    Duration d;
    if (v.length == 1) { // has only date-based fields
      p = Period.parse(input);
      d = Duration.ZERO;
    } else {
      if ("P".equals(v[0])) { // has only time-based fields
        p = Period.ZERO;
      } else {
        p = Period.parse(v[0]);
      }
      d = Duration.parse("PT" + v[1]);
    }
  }
}
