package com.hackerrank.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTablesRansomNote {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the checkMagazine function below.
  static void checkMagazine(String[] magazine, String[] note) {
    Map<String, Integer> magazineMap = new HashMap<>();
    for (String str : magazine) {
      magazineMap.put(str, magazineMap.getOrDefault(str, 0) + 1);
    }
    for (String n : note) {
      if (magazineMap.containsKey(n) && magazineMap.get(n) > 0) {
        magazineMap.put(n, magazineMap.get(n) - 1);
      } else {
        System.out.println("No");
        return;
      }
    }
    System.out.println("Yes");
  }

  public static void main(String[] args) {
    String[] mn = scanner.nextLine().split(" ");

    int m = Integer.parseInt(mn[0]);

    int n = Integer.parseInt(mn[1]);

    String[] magazine = new String[m];

    String[] magazineItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < m; i++) {
      String magazineItem = magazineItems[i];
      magazine[i] = magazineItem;
    }

    String[] note = new String[n];

    String[] noteItems = scanner.nextLine().split(" ");
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < n; i++) {
      String noteItem = noteItems[i];
      note[i] = noteItem;
    }

    checkMagazine(magazine, note);

    scanner.close();
  }
}
