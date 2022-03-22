package com.hackerrank.array;


import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

public class ArrayManipulation {

  private static final Scanner scanner = new Scanner(System.in);

  // Complete the arrayManipulation function below.
  static long arrayManipulation(int n, int[][] queries) {
//    long[] arr = new long[n];
//    Arrays.stream(queries).forEach(query ->
//        IntStream.rangeClosed(query[0] - 1, query[1] - 1)
//            .forEach(j -> arr[j] = arr[j] + query[2]));
//    return LongStream.of(arr).max().getAsLong();

    long[] arr = new long[n];
    Arrays.stream(queries).forEach(query -> {
      int a = query[0] - 1;
      int b = query[1];
      int k = query[2];
      arr[a] += k;
      if (b < n) {
        arr[b] -= k;
      }
    });
    Arrays.parallelPrefix(arr, Long::sum);
    return LongStream.of(arr).max().getAsLong();
  }

  public static void main(String[] args) throws IOException {
//    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    String[] nm = scanner.nextLine().split(" ");

    int n = Integer.parseInt(nm[0]);

    int m = Integer.parseInt(nm[1]);

    int[][] queries = new int[m][3];

    for (int i = 0; i < m; i++) {
      String[] queriesRowItems = scanner.nextLine().split(" ");
      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

      for (int j = 0; j < 3; j++) {
        int queriesItem = Integer.parseInt(queriesRowItems[j]);
        queries[i][j] = queriesItem;
      }
    }

    long result = arrayManipulation(n, queries);

    System.out.println(result);

//    bufferedWriter.write(String.valueOf(result));
//    bufferedWriter.newLine();
//
//    bufferedWriter.close();

    scanner.close();
  }
}
