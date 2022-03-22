package com.lambda;

public class Main {

  public static void main(String[] args) {
    FuncInter1 add = (x, y) -> x + y;
    FuncInter1 multiply = (x, y) -> x * y;
    Main main = new Main();
    System.out.println(main.operate(10, 5, add));
    System.out.println(main.operate(10, 5, multiply));

    FuncInter2 print = (message -> System.out.println("Hello " + message));
    print.sayMessage("Ashu");
  }

  private int operate(int a, int b, FuncInter1 funcInter1) {
    return funcInter1.operation(a, b);
  }

  interface FuncInter1 {

    int operation(int a, int b);
  }

  interface FuncInter2 {

    void sayMessage(String message);
  }
}
