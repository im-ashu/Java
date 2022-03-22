package com.designpattern.structural.adapter;

public class Mp4Player implements AdvancedMediaPlayer {

  @Override
  public void playVLC(String name) {

  }

  @Override
  public void playMP4(String name) {
    System.out.println("Playing mp4 file name : " + name);
  }
}
