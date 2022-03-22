package com.designpattern.structural.filter;

import java.util.Set;

public class AndCriteria implements Criteria {

  private final Criteria criteria;
  private final Criteria otherCriteria;

  public AndCriteria(Criteria criteria, Criteria otherCriteria) {
    this.criteria = criteria;
    this.otherCriteria = otherCriteria;
  }

  @Override
  public Set<Person> meetCriteria(Set<Person> people) {
    Set<Person> personList = criteria.meetCriteria(people);
    return otherCriteria.meetCriteria(personList);
  }
}
