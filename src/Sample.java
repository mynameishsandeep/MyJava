class Sample {
  public String removeDuplicates(String S) {
    StringBuilder s = new StringBuilder();
    for (Character c : S.toCharArray()) {
      if (s.length() > 0 && c == s.charAt(s.length() - 1)) {
        s.deleteCharAt(s.length() - 1);
      } else {
        s.append(c);
      }
    }
    return s.toString();
  }
}
