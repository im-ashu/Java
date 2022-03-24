package com.datastructure.string;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class WinnerOfAnElection {

  public static void main(String[] args) {
    String[] votes = {"john", "johnny", "jackie", "johnny", "john",
        "jackie", "jamie", "jamie", "john", "johnny", "jamie",
        "johnny", "john"};
    Arrays.stream(winner(votes, votes.length)).forEach(e -> System.out.print(e + " "));
  }

  public static String[] winner(String[] arr, int n) {
    // add your code
    String[] result = new String[2];
    TreeMap<String, Integer> votesMap = new TreeMap<>();
    TreeMap<Integer, TreeSet<String>> votesNameMap = new TreeMap<>();
    for (String s : arr) {
      int votesFreq = votesMap.getOrDefault(s, 0);
      TreeSet<String> voters = votesNameMap.getOrDefault(votesFreq, new TreeSet<>());
      voters.remove(s);
      votesNameMap.put(votesFreq, voters);
      int newFreq = votesFreq + 1;
      TreeSet<String> newVoterFreq = votesNameMap.getOrDefault(newFreq, new TreeSet<>());
      newVoterFreq.add(s);
      votesNameMap.put(newFreq, newVoterFreq);
      votesMap.put(s, newFreq);
    }
    Map.Entry<Integer, TreeSet<String>> resultSet = votesNameMap.pollLastEntry();
    result[0] = resultSet.getValue().pollFirst();
    result[1] = String.valueOf(resultSet.getKey());

    return result;
  }
}