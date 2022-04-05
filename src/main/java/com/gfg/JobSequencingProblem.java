package com.gfg;

import java.util.Arrays;

public class JobSequencingProblem {

  static class Job {

    int id;
    int profit;
    int deadline;

    Job(int x, int y, int z) {
      this.id = x;
      this.deadline = y;
      this.profit = z;
    }
  }

  public static void main(String[] args) {
    int n = 17;
    Job[] arr = {new Job(1, 56, 288), new Job(2, 27, 435), new Job(3, 67, 401), new Job(4, 64, 368),
        new Job(5, 94, 248), new Job(6, 54, 361), new Job(7, 43, 108), new Job(8, 96, 167),
        new Job(9, 73, 251), new Job(10, 96, 170), new Job(11, 14, 156), new Job(12, 78, 184),
        new Job(13, 61, 370), new Job(14, 77, 424), new Job(15, 68, 397), new Job(16, 40, 375),
        new Job(17, 36, 218)};
    JobSequencingProblem jobSequencingProblem = new JobSequencingProblem();
    int[] result = jobSequencingProblem.JobScheduling(arr, n);
    System.out.println(result[0] + " " + result[1]);
  }

  int[] JobScheduling(Job[] arr, int n) {
    Integer[] res = new Integer[n + 1];
    Arrays.sort(arr, (job1, job2) -> Integer.compare(job2.profit, job1.profit));
    int[] r = new int[]{0, 0};
    for (int i = 0; i < n; i++) {
      Job job = arr[i];
      int deadline = Math.min(job.deadline, n);
      for (int j = deadline; j > 0; j--) {
        if (res[j] == null) {
          res[j] = job.id;
          r[0]++;
          r[1] += job.profit;
          break;
        }
      }
    }
    return r;
  }

}
