package com.datastructure.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PrintAnagramsTogether {

  public static void main(String[] args) {
    String[] stringList = {"kptkwp", "czdvgr", "osbqrs", "shhqjd", "ydavzo", "bltcjf", "vuoswt",
        "gkgbjk", "hzfoyu", "tujlak", "wgmuab", "wtdeno", "cemizj", "dryfqd", "hxuzdd", "zpanxz",
        "lnakfa", "yovytp", "yqtjyd", "baoyal", "vbwgaf", "bmmdgq", "akmnxe", "koaaan", "jlarwn",
        "dbhapu", "bspgln"};
// stringList = new String[]{"kptkwp","vuoswt", "wtdeno"};
    List<List<String>> anagrams = AnagramsAlternate(stringList);
    for (List<String> strings : anagrams) {
      for (String string : strings) {
        System.out.print(string + " ");
      }
      System.out.println();
    }
  }

  public static List<List<String>> Anagrams(String[] string_list) {
    // Code here
    List<List<String>> result = new ArrayList<>();
    int n = string_list.length;
    if (result.isEmpty()) {
      result = new ArrayList<>();
      ArrayList<String> objects = new ArrayList<>();
      objects.add(string_list[0]);
      result.add(objects);
    }
    boolean isAnagram;
    for (int i = 1; i < n; i++) {
      isAnagram = false;
      for (List<String> strings : result) {
        String s = strings.get(0);
        if (anagram(s, string_list[i])) {
          strings.add(string_list[i]);
          isAnagram = true;
          break;
        }
      }
      if (!isAnagram) {
        ArrayList<String> objects = new ArrayList<>();
        objects.add(string_list[i]);
        result.add(objects);
      }
    }
    return result;
  }

  private static boolean anagram(String s, String s1) {
    if (s.length() != s1.length()) {
      return false;
    }
    int[] count = new int[256];
    for (int i = 0; i < s.length(); i++) {
      count[s.charAt(i)] += 1;
    }
    for (int i = 0; i < s1.length(); i++) {
      count[s1.charAt(i)] -= 1;
    }
    for (int j : count) {
      if (j != 0) {
        return false;
      }
    }
    return true;
  }

  public static List<List<String>> AnagramsAlternate(String[] string_list) {
    // Code here
    List<List<String>> result = new ArrayList<>();
    HashMap<String, List<String>> map = new HashMap<>();
    for (String s : string_list) {
      String[] charArray = s.split("");
      Arrays.sort(charArray);
      String s1 = String.join("", charArray);
      map.putIfAbsent(s1, new ArrayList<>());
      map.get(s1).add(s);
    }
    result = new ArrayList<>(map.values());
    return result;
  }
}