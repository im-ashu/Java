package com.basic;

import java.util.HashSet;
import java.util.Set;

public class TwiceCounter {

  public static void main(String[] args) {
    String[] list = {"Tom", "Jerry", "Thomas", "Tom", "Jerry",
        "Courage", "Tom", "Courage"};
    System.out.println(countWords(list, list.length));
  }

  public static int countWords(String[] list, int n) {
    Set<String> s = new HashSet<>();
    Set<String> result = new HashSet<>();
    Set<String> moreThan2 = new HashSet<>();
    for (String string : list) {
      if (moreThan2.contains(string)) {
        continue;
      }
      if (result.contains(string)) {
        result.remove(string);
        moreThan2.add(string);
        continue;
      }
      if (s.contains(string) && !result.contains(string)) {
        s.remove(string);
        result.add(string);
      } else {
        s.add(string);
      }
    }
    return result.size();
  }
}