package com.datastructure.stack;

import java.util.Stack;


public class ImplementQueueUsingTwoStacks {

  public static void main(String[] args) {
    QueueWithTwoStacks queue = new QueueWithTwoStacks();
    queue.enQueue(1);
    queue.enQueue(3);
    queue.enQueue(5);
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
  }

  static class QueueWithTwoStacks {

    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public QueueWithTwoStacks() {
      this.stack1 = new Stack<>();
      this.stack2 = new Stack<>();
    }

    public void enQueue(int data) {

      stack1.push(data);

      /*
       * Making enQueue operation costly : Start
       * */
//    while (!stack1.empty()) {
//      stack2.push(stack1.pop());
//    }
//    stack1.push(data);
//    while (!stack2.empty()) {
//      stack1.push(stack2.pop());
//    }
      /*
       * Making enQueue operation costly : End
       * */

    }

    public int deQueue() {
//    if(!stack1.empty()){
//      return stack1.pop();
//    }
//    return Integer.MIN_VALUE;

      /*
       * Making deQueue operation costly : Start
       * */
      if (stack1.isEmpty() && stack2.isEmpty()) {
        return Integer.MIN_VALUE;
      }
      if (stack2.isEmpty()) {
        while (!stack1.isEmpty()) {
          stack2.push(stack1.pop());
        }
      }
      return stack2.pop();
      /*
       * Making deQueue operation costly : End
       * */
    }

  }

}


