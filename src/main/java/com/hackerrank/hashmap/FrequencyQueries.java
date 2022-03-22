package com.hackerrank.hashmap;

import static java.util.stream.Collectors.joining;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FrequencyQueries {

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("FrequencyQueries.txt"));

    int q = Integer.parseInt(bufferedReader.readLine().trim());
    Pattern p = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");

    List<Integer> ans = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int i = 0; i < q; i++) {
      try {
        Matcher m = p.matcher(bufferedReader.readLine());
        if (m.matches()) {
          int operation = Integer.parseInt(m.group(1));
          int key = Integer.parseInt(m.group(2));
          if (operation == 1) {
            Integer frequency = map.getOrDefault(key, 0);
            map.put(key, frequency + 1);
            freqMap.put(frequency, Math.max(freqMap.getOrDefault(frequency, 0) - 1, 0));
            freqMap.put(frequency + 1, freqMap.getOrDefault(frequency + 1, 0) + 1);
          } else if (operation == 2) {
            int frequency = map.getOrDefault(key, 0);
            if (frequency > 0) {
              map.put(key, frequency - 1);
              freqMap.put(frequency, Math.max(freqMap.getOrDefault(frequency, 0) - 1, 0));
              freqMap.put(frequency - 1, freqMap.getOrDefault(frequency - 1, 0) + 1);
            }
          } else {
            ans.add(freqMap.getOrDefault(key, 0) > 0 ? 1 : 0);
          }
        }

      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    }

    bufferedWriter.write(
        ans.stream()
            .map(Object::toString)
            .collect(joining("\n"))
            + "\n"
    );

    bufferedReader.close();
    bufferedWriter.close();
  }
}
