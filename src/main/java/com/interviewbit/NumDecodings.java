package com.interviewbit;

import java.util.Arrays;

public class NumDecodings {

  public static void main(String[] args) {
    String A = "261";
    //        System.out.println(numDecodings(A));
    System.out.println(numDecodingTopDownApproach(A));
  }

  private static int numDecodingTopDownApproach(String A) {
    int n = A.length();
    int[] dp = new int[n];
    if (A.charAt(0) == '0') {
      return 0;
    }
    dp[0] = 1;
    for (int i = 1; i < n; i++) {
      if (A.charAt(i - 1) == '0' && A.charAt(i) == '0') {
        dp[i] = 0;
      } else if (A.charAt(i - 1) != '0' && A.charAt(i) == '0') {
        if (A.charAt(i - 1) == '1' || A.charAt(i - 1) == '2') {
            if (i >= 2) {
                dp[i] = dp[i - 2];
            } else {
                dp[i] = 1;
            }
        } else {
          dp[i] = 0;
        }
      } else if (A.charAt(i - 1) == '0' && A.charAt(i) != '0') {
        dp[i] = dp[i - 1];
      } else {
        if (Integer.parseInt(A.substring(i - 1, i + 1)) <= 26) {
          dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
        } else {
          dp[i] = dp[i - 1];
        }
      }
    }
    return dp[n - 1];
  }

  public static int numDecodings(String A) {
    int n = A.length();
    if (n == 0) {
      return 1;
    }
    int[] dp = new int[n];
    Arrays.fill(dp, -1);
    return decodeMessage(dp, 0, A, n);
  }

  private static int decodeMessage(int[] dp, int s, String str, int n) {
      if (s >= n) {
          return 1;
      }

      if (dp[s] != -1) {
          return dp[s];
      }

    int num, tc;
    num = tc = 0;
    int mod = 1000000007;
    for (int i = s; i < n; i++) {
      num = num * 10 + (str.charAt(i) - '0');

        if (num >= 1 && num <= 26) {
            int c = decodeMessage(dp, i + 1, str, n);

            tc = (tc % mod + c % mod) % mod;
        } else {
            break;
        }
    }

    return (dp[s] = tc);
  }
}