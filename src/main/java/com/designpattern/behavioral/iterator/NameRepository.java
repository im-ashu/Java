package com.designpattern.behavioral.iterator;

public class NameRepository implements Container {

  public final String names[] = {"Robert", "John", "Michael", "Lora"};

  @Override
  public Iterator getIterator() {
    return new NameIterator();
  }

  private class NameIterator implements Iterator {

    int index;

    @Override
    public boolean hasNext() {
      if (index < names.length) {
        return true;
      }
      return false;
    }

    @Override
    public Object next() {
      if (hasNext()) {
        return names[index++];
      }
      return null;
    }
  }

}
