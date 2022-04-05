package com.leetcode;

import java.util.Arrays;

public class MaximumProfitJobScheduling {

  public static void main(String[] args) {
    MaximumProfitJobScheduling maxProfit = new MaximumProfitJobScheduling();
    int[] start = {6, 15, 7, 11, 1, 3, 16, 2};
    int[] end = {19, 18, 19, 16, 10, 8, 19, 8};
    int[] profit = {2, 9, 1, 19, 5, 7, 3, 19};
    System.out.println(maxProfit.jobScheduling(start, end, profit));
  }

  static class Job implements Comparable<Job> {

    int start;
    int end;
    int profit;

    public Job(int start, int end, int profit) {
      this.start = start;
      this.end = end;
      this.profit = profit;
    }

    @Override
    public int compareTo(Job job) {
      if (end == job.end) {
        return -Integer.compare(start, job.start);
      }
      return Integer.compare(end, job.end);
    }
  }

  public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    long maxProfit = 0;
    int jobsCount = startTime.length;
    Job[] jobs = new Job[jobsCount];
    for (int i = 0; i < jobsCount; i++) {
      jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
    }
    Arrays.sort(jobs);
    long[] t = new long[jobsCount];
    for (int i = 0; i < jobsCount; i++) {
      long max = 0;
      for (int j = 0; j < i; j++) {
        if (jobs[j].end <= jobs[i].start && t[j] > max) {
          max = t[j];
        }
      }
      t[i] = max + jobs[i].profit;
      maxProfit = Math.max(maxProfit, t[i]);
    }
    return (int) maxProfit;
  }
}
