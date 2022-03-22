package com.stream;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {

    List<Person> people = getPeople();

    System.out.println(people.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    // Imperative approach ❌

    /*
    List<Person> females = new ArrayList<>();
    for (Person person : people) {
      if (person.getGender().equals(Gender.FEMALE)) {
        females.add(person);
      }
    }
    females.forEach(System.out::println);
    */

    // Declarative approach ✅

    // Filter
    List<Person> females = people.stream()
        .filter(person -> Objects.equals(person.getGender(), Gender.FEMALE))
        .collect(Collectors.toList());

//    females.forEach(System.out::println);

    List<Person> sortPerson = people.stream()
        .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getAge).reversed())
        .collect(
            Collectors.toList());

//    sortPerson.forEach(System.out::println);

    // Sort
    List<Person> sorted = people.stream()
        .sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getGender).reversed())
        .collect(Collectors.toList());

//    sorted.forEach(System.out::println);

    // All match
    boolean allMatch = people.stream()
        .allMatch(person -> person.getAge() > 8);

//    System.out.println(allMatch);
    // Any match
    boolean anyMatch = people.stream()
        .anyMatch(person -> person.getAge() > 121);

//    System.out.println(anyMatch);
    // None match
    boolean noneMatch = people.stream()
        .noneMatch(person -> person.getName().equals("Antonio"));

//    System.out.println(noneMatch);

    // Max
    people.stream()
        .max(Comparator.comparing(Person::getAge));
//        .ifPresent(System.out::println);

    people.stream().max(Comparator.comparing(Person::getAge)).ifPresent(System.out::println);

    // Min
    people.stream()
        .min(Comparator.comparing(Person::getAge));
//        .ifPresent(System.out::println);

    // Group
    Map<Gender, List<Person>> groupByGender = people.stream()
        .collect(Collectors.groupingBy(Person::getGender));

//    groupByGender.forEach((gender, people1) -> {
//      System.out.println(gender);
//      people1.forEach(System.out::println);
//      System.out.println();
//    });

    Optional<String> oldestFemaleAge = people.stream()
        .filter(person -> person.getGender().equals(Gender.FEMALE))
        .max(Comparator.comparing(Person::getAge))
        .map(Person::getName);

//    oldestFemaleAge.ifPresent(System.out::println);

    Stream<Integer> integerStream = Stream.of(5, 13, 4, 21, 13, 27, 2, 59, 59, 64);
    List<Integer> duplicates = integerStream
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
        .stream().filter(map -> map.getValue() > 1).map(
            Entry::getKey).collect(Collectors.toList());
//    Set<Integer> items = new HashSet<>();
//    List<Integer> duplicates = integerStream.filter(n -> !items.add(n)).collect(Collectors.toList());
//    duplicates.stream().forEach(num -> System.out.print(num + " "));
//    System.out.println();
//    items.stream().forEach(num -> System.out.print(num + " "));

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
    Stream<Integer> parallelStream = list.parallelStream();
//    parallelStream.collect(Collectors.toCollection(LinkedList::new)).descendingIterator()
//        .forEachRemaining(System.out::println);

    ArrayDeque<Integer> reverseList = parallelStream
        .collect(Collector.of(() -> new ArrayDeque<Integer>(), ArrayDeque::addFirst, (a, b) -> {
          b.addAll(a);
          return b;
        }));
    reverseList.stream().forEach(System.out::println);
  }

  private static List<Person> getPeople() {
    return Arrays.asList(
        new Person("Antonio", 20, Gender.MALE),
        new Person("Alina Smith", 33, Gender.FEMALE),
        new Person("Helen White", 57, Gender.FEMALE),
        new Person("Alex Boz", 14, Gender.MALE),
        new Person("Jamie Goa", 99, Gender.MALE),
        new Person("Anna Cook", 7, Gender.FEMALE),
        new Person("Zelda Brown", 120, Gender.FEMALE)
    );
  }

}

