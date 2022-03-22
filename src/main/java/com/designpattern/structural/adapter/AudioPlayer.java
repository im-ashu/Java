package com.designpattern.structural.adapter;

public class AudioPlayer implements MediaPlayer {

  private MediaPlayer mediaAdapter;

  @Override
  public void play(String name, FileType type) {
    if (type.equals(FileType.MP3)) {
      System.out.println("Playing mp3 file name " + name);
    } else if (type.equals(FileType.MP4) || type.equals(FileType.VLC)) {
      mediaAdapter = new MediaAdapter(type);
      mediaAdapter.play(name, type);
    }
  }
}
