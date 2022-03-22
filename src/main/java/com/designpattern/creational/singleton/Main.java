package com.designpattern.creational.singleton;

public class Main {

  SingletonEager singletonEager = SingletonEager.getInstance();
  SingletonLazy singletonLazy = SingletonLazy.getInstance();
  SingletonStaticBlock singletonStaticBlock = SingletonStaticBlock.getInstance();
  SingletonThreadSafe singletonThreadSafe = SingletonThreadSafe.getInstance();
  SingletonDoubleCheck singletonDoubleCheck = SingletonDoubleCheck.getInstance();
  SingletonBillPugh singletonBillPugh = SingletonBillPugh.getInstance();
  SingletonCloneSafe singletonCloneSafe = SingletonCloneSafe.getInstance();
}
