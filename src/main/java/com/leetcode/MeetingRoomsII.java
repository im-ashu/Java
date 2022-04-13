package com.leetcode;

import java.util.Arrays;

public class MeetingRoomsII {

  public static void main(String[] args) {
    MeetingRoomsII meetingRoomsII = new MeetingRoomsII();
    int[][] intervals = {{1, 3}, {8, 10}, {7, 8}, {9, 15}, {2, 6}};
    System.out.println(meetingRoomsII.minMeetingRooms(intervals));
  }

  public int minMeetingRooms(int[][] intervals) {
    int len = intervals.length;
    int[] start = new int[len];
    int[] end = new int[len];
    for (int i = 0; i < len; i++) {
      start[i] = intervals[i][0];
      end[i] = intervals[i][1];
    }
    Arrays.sort(start);
    Arrays.sort(end);
    int i = 1;
    int j = 0;
    int roomsNeeded = 1;
    int maxRooms = 1;
    while (i < len && j < len) {
      if (start[i] < end[j]) {
        roomsNeeded++;
        i++;
      } else {
        roomsNeeded--;
        j++;
      }
      maxRooms = Math.max(maxRooms, roomsNeeded);
    }
    return maxRooms;
  }


}
