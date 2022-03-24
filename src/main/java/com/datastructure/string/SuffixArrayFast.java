package com.datastructure.string;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SuffixArrayFast extends SuffixArray {

  private static final int DEFAULT_ALPHABET_SIZE = 256;

  int alphabetSize;
  int[] sa2, rank, tmp, c;

  public SuffixArrayFast(String text) {
    this(toIntArray(text), DEFAULT_ALPHABET_SIZE);
  }

  public SuffixArrayFast(int[] text) {
    this(text, DEFAULT_ALPHABET_SIZE);
  }

  // Designated constructor
  public SuffixArrayFast(int[] text, int alphabetSize) {
    super(text);
    this.alphabetSize = alphabetSize;
  }

  public static void main(String[] args) {
    SuffixArrayFast sa = new SuffixArrayFast("GEEKSFORGEEKS");
    int[] lcp = sa.getLcpArray();
    getLongestRepeatedSubstring(sa, lcp);
  }

  private static void getLongestRepeatedSubstring(SuffixArrayFast sa, int[] lcp) {
    int max = 0;
    for (int i = 0; i < sa.N; i++) {
      if (max < lcp[i]) {
        max = lcp[i];
      }
    }
    int index;
    for (int i = 0; i < sa.N; i++) {
      if (max == lcp[i]) {
        char[] suffixArray;
        index = sa.sa[i];
        suffixArray = IntStream.range(index, index + max)
            .mapToObj(c -> Character.toString((char) sa.T[c])).collect(Collectors.joining())
            .toCharArray();
        // for (int j = sa.sa[i], k = 0; k < max; j++, k++)
        // {
        // suffixArray[k] = (char) sa.T[j];
        // }
        System.out.println(new String(suffixArray));
      }
    }
  }

  @Override
  protected void construct() {
    sa = new int[N];
    sa2 = new int[N];
    rank = new int[N];
    c = new int[Math.max(alphabetSize, N)];

    int i, p, r;
    for (i = 0; i < N; ++i) {
      c[rank[i] = T[i]]++;
    }
    for (i = 1; i < alphabetSize; ++i) {
      c[i] += c[i - 1];
    }
    for (i = N - 1; i >= 0; --i) {
      sa[--c[T[i]]] = i;
    }
    for (p = 1; p < N; p <<= 1) {
      for (r = 0, i = N - p; i < N; ++i) {
        sa2[r++] = i;
      }
      for (i = 0; i < N; ++i) {
        if (sa[i] >= p) {
          sa2[r++] = sa[i] - p;
        }
      }
      java.util.Arrays.fill(c, 0, alphabetSize, 0);
      for (i = 0; i < N; ++i) {
        c[rank[i]]++;
      }
      for (i = 1; i < alphabetSize; ++i) {
        c[i] += c[i - 1];
      }
      for (i = N - 1; i >= 0; --i) {
        sa[--c[rank[sa2[i]]]] = sa2[i];
      }
      for (sa2[sa[0]] = r = 0, i = 1; i < N; ++i) {
        if (!(rank[sa[i - 1]] == rank[sa[i]]
            && sa[i - 1] + p < N
            && sa[i] + p < N
            && rank[sa[i - 1] + p] == rank[sa[i] + p])) {
          r++;
        }
        sa2[sa[i]] = r;
      }
      tmp = rank;
      rank = sa2;
      sa2 = tmp;
     if (r == N - 1) {
      break;
     }
      alphabetSize = r + 1;
    }
  }
}