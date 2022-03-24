package com.datastructure.stack;

import java.util.Stack;

public class MinStackO1 extends Stack<Integer> {

  Stack<Integer> s = new Stack<>();
  private int minElement;
  private int minEle;

  public static void main(String[] args) {
    MinStackO1 s = new MinStackO1();
    System.out.println(s.popNew());
    s.pushNew(16);
    System.out.println(s.getMinNew());
    System.out.println(s.popNew());
    System.out.println(s.popNew());
    s.pushNew(50);
    System.out.println(s.popNew());
    System.out.println(s.getMinNew());
    System.out.println(s.popNew());
    System.out.println(s.getMinNew());
    System.out.println(s.popNew());
    System.out.println(s.getMinNew());
    System.out.println(s.popNew());
    s.pushNew(27);
    System.out.println(s.popNew());
    System.out.println(s.popNew());
    System.out.println(s.getMinNew());
    System.out.println(s.getMinNew());
    s.pushNew(30);
    System.out.println(s.getMinNew());
    System.out.println(s.getMinNew());
    System.out.println(s.getMinNew());
    System.out.println(s.popNew());
    System.out.println(s.popNew());
    System.out.println(s.popNew());
    System.out.println(s.getMinNew());
    s.pushNew(23);
    s.pushNew(70);
    s.pushNew(94);
    System.out.println(s.popNew());
    System.out.println(s.popNew());
    System.out.println(s.popNew());
    s.pushNew(74);
  }

  /*returns min element from stack*/
  int getMinNew() {
    // Your code here
    if (s.isEmpty()) {
      return -1;
    }
    return minEle;
  }

  /*returns poped element from stack*/
  int popNew() {
    // Your code here
    if (!s.isEmpty()) {
      if (s.peek() < minEle) {
        int temp = minEle;
        minEle = (2 * minEle) - s.pop();
        return temp;
      } else {
        return s.pop();
      }
    }
    return -1;
  }

 /*@Override
 public Integer push(Integer item)
 {
 if (isEmpty())
 {
 minElement = item;
 }
 if (minElement > item)
 {
 int temp = item;
 item = (2 * item) - minElement;
 minElement = temp;
 }
 return super.push(item);
 }

 @Override
 public synchronized Integer pop()
 {
 if (super.peek() < minElement)
 {
 int temp = minElement;
 minElement = 2 * minElement - super.peek();
 super.pop();
 return temp;
 }
 return super.pop();
 }

 @Override
 public synchronized Integer peek()
 {
 int len = size();
 if (len == 0)
 throw new EmptyStackException();
 Integer top = super.peek();
 if (top >= minElement)
 {
 return top;
 }
 else
 {
 return minElement;
 }
 }*/

  /*push element x into the stack*/
  void pushNew(int x) {
    // Your code here
    if (s.isEmpty()) {
      s.push(x);
      minEle = x;
      return;
    }
    if (x <= minEle) {
      int temp = x;
      x = (2 * x) - minEle;
      minEle = temp;
    }
    s.push(x);
  }

  private int getMin() {
    return minElement;
  }
}