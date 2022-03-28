package com.leetcode;

/**
 * Let's approach this problem another way, which can allow us to make it generic. Give the sum of
 * all digits of the numbers from 0 to n. Express the result in base 10. I let you read the problem
 * again, to convince you it is exactly the same. Thinking about the problem like this will allow us
 * to see things in base 10, which is more intuitive that base2.
 * <p>
 * What happens when you multiply a number by 10? This is easy, we just add a zero at the end.
 * Considering our problem, when you multiply a number by 10, then the sum of its digits does not
 * change. So, for any n, we can say that if n is a multiple of 10, then the sum of its digits is
 * the sum of all the digits of the number n/10. Example : The sum of the digits of 1170 (which is a
 * multiple of 10) is the same as the sum of the digits of 117 (which is 9 actually) And what if the
 * number is not a multiple of 10 The previous step allowed us to remove 10% of the job only. Let's
 * try to guess the sum of the digits of 1174. Actually, we know the sum of the digits of the number
 * n/10, which is 9 (as seen previously). So we just need to add 4 to this sum. So the sum of the
 * digits of a number is (sumOfTheNumberOf(n/10))+n%10. So if we try to do this for all numbers in
 * an array, this would be easy, we just have to consider num[i] = num[i/10]+i%10. And we will
 * ensure by doing this step from 0 to n, that num[i/10] has already been calculated. * And here
 * comes the magic ** The equality num[i] = num[i/10]+i%10 is true, whatever base we choose.
 * Starting from now, I will start using the Java implementation With base 16? Easy num[i] =
 * num[i/0x10]+i%0x10; With base 2 ? Easy num[i] = num[i/0B10]+i%0B10; There is only one thing to
 * take care about now, and it's the zero value. Because num[0] = num[0] will make us go into some
 * loop troubles. But lucky we are, when we initialize an array in Java, all the values are set to
 * 0, so the equality num[0] = num[0/0B10] + i%0B10; will still be OK. This makes us come to the
 * final solution
 **/
public class CountingBits {

  public static void main(String[] args) {
    int n = 5;
    int[] countBits = new CountingBits().countBits(n);
    for (int countBit : countBits) {
      System.out.print(countBit + " ");
    }

  }

  public int[] countBits(int n) {
    int[] t = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      t[i] = t[i / 0B10] + (i % 0B10);
    }
    return t;
  }
}