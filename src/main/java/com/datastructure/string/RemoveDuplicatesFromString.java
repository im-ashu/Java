package com.datastructure.string;

import java.util.Arrays;

public class RemoveDuplicatesFromString {

  public static void main(String[] args) {
    RemoveDuplicatesFromString r = new RemoveDuplicatesFromString();
    String s = "BANANABAN";
    System.out.println("Remove Using Arrays " + String.valueOf(r.removeDuplicatesUsingArray(s)));
    System.out.println(
        "Remove Using Bit Operation " + String.valueOf(r.removeDuplicatesUsingBitOperation(s)));
  }

  private char[] removeDuplicatesUsingArray(String s) {
    int[] table = new int[256];
    char[] characters = s.toCharArray();
    int endIndex = 0;
    for (int i = 0; i < characters.length; i++) {
      int x = characters[i] - 'A';
      if (table[x] == 0) {
        table[x]--;
        characters[endIndex++] = characters[i];
      }
    }
    return Arrays.copyOf(characters, endIndex);
  }

  private char[] removeDuplicatesUsingBitOperation(String s) {
    char[] characters = s.toCharArray();
    int endIndex = 0;
    int counter = 0;
    for (int i = 0; i < characters.length; i++) {
      int x = characters[i] - 'A';
      if ((counter & 1 << x) == 0) { //check if xth bit is set or not
        counter = counter | (1 << x); //Set xth Bit
        characters[endIndex++] = characters[i];
      }
    }
    return Arrays.copyOf(characters, endIndex);
  }
}