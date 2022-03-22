package com.optional;

import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    Optional<Object> empty = Optional.empty();
//    System.out.println(empty.isPresent());

    Optional<String> optional = Optional.of("HELLO");
//    optional.ifPresent(System.out::println);

    Optional<String> optional1 = Optional.ofNullable(null);
    String str = optional.map(name -> name.toLowerCase()).get();
    System.out.println(str);
  }
}
