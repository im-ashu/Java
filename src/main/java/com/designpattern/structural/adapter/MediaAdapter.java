package com.designpattern.structural.adapter;

public class MediaAdapter implements MediaPlayer {

  private AdvancedMediaPlayer advancedMediaPlayer;

  public MediaAdapter(FileType type) {
    if (type.equals(FileType.VLC)) {
      advancedMediaPlayer = new VlcPlayer();
    } else if (type.equals(FileType.MP4)) {
      advancedMediaPlayer = new Mp4Player();
    }
  }

  @Override
  public void play(String name, FileType type) {

    if (type.equals(FileType.VLC)) {
      advancedMediaPlayer.playVLC(name);
    } else if (type.equals(FileType.MP4)) {
      advancedMediaPlayer.playMP4(name);
    }

  }
}
