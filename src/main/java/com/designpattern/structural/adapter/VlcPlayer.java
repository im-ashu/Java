package com.designpattern.structural.adapter;

public class VlcPlayer implements AdvancedMediaPlayer {

  @Override
  public void playVLC(String name) {
    System.out.println("Playing vlc file name : " + name);
  }

  @Override
  public void playMP4(String name) {

  }
}
