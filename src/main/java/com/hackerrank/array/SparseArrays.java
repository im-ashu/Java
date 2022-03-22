package com.hackerrank.array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SparseArrays {

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws IOException {
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("SparseArrays.txt"));

    int stringsCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    Map<String, Integer> map = new HashMap<>();

    for (int i = 0; i < stringsCount; i++) {
      String stringsItem = scanner.nextLine();
      map.put(stringsItem, map.getOrDefault(stringsItem, 0) + 1);
    }

    int queriesCount = scanner.nextInt();
    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

    for (int i = 0; i < queriesCount; i++) {
      String queriesItem = scanner.nextLine();
      bufferedWriter.write(String.valueOf(map.getOrDefault(queriesItem, 0)));
      bufferedWriter.write("\n");
    }

    bufferedWriter.newLine();

    bufferedWriter.close();

    scanner.close();
  }
}
