package com.datastructure.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class InterleaveQueue {

  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(11);
    queue.add(12);
    queue.add(13);
    queue.add(14);
    queue.add(15);
    queue.add(16);
    queue.add(17);
    queue.add(18);
    queue.add(19);
    queue.add(20);

    interLeaveQueue(queue);

    int length = queue.size();
    for (int i = 0; i < length; i++) {
      System.out.print(queue.peek() + " ");
      queue.poll();
    }
  }

  private static void interLeaveQueue(Queue<Integer> queue) {
    int length = queue.size();
    if (length % 2 != 0) {
      return;
    }
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < length / 2; i++) {
      stack.push(queue.poll());
    }
    /*
     * Queue : 16 17 18 19 20
     * Stack : 15(T) 14 13 12 11
     * */

    for (int i = 0; i < length / 2; i++) {
      queue.offer(stack.pop());
    }
    /*
     * Queue : 16 17 18 19 20 15 14 13 12 11
     * Stack : Empty
     * */

    for (int i = 0; i < length / 2; i++) {
      queue.offer(queue.poll());
    }
    /*
     * Queue : 15 14 13 12 11 16 17 18 19 20
     * Stack : Empty
     * */

    for (int i = 0; i < length / 2; i++) {
      stack.push(queue.poll());
    }
    /*
     * Queue : 16 17 18 19 20
     * Stack : 11(T) 12 13 14 15
     * */

    while (!stack.isEmpty()) {
      queue.offer(stack.pop());
      queue.offer(queue.poll());
    }
    /*
     * Queue : 11 16 12 17 13 18 14 19 15 20
     * Stack : Empty
     * */
  }


}
