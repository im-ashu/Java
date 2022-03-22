package com.hackerrank.virtusa;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CountTriplets {

  // Complete the countTriplets function below.
  static long countTriplets(List<Long> arr, long r) {
    Map<Long, Long> t2 = new HashMap<>();
    Map<Long, Long> t3 = new HashMap<>();
    long result = 0L;

    for (Long a : arr) {
      result += t3.getOrDefault(a, 0L);
      if (t2.containsKey(a)) {
        t3.put(a * r, t3.getOrDefault(a * r, 0L) + t2.get(a));
      }
      t2.put(a * r, t2.getOrDefault(a * r, 0L) + 1);
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(
        new FileWriter("CountTriplets.txt"));

    String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    int n = Integer.parseInt(nr[0]);

    long r = Long.parseLong(nr[1]);

    List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Long::parseLong)
        .collect(toList());

    long ans = countTriplets(arr, r);

    bufferedWriter.write(String.valueOf(ans));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
