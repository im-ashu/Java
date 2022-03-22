package com.designpattern.structural.adapter;


public class Main {

  public static void main(String[] args) {
    MediaPlayer mediaPlayer = new AudioPlayer();
    mediaPlayer.play("xyz.mp3", FileType.MP3);
    mediaPlayer.play("abc.mp4", FileType.MP4);
    mediaPlayer.play("qwe.vlc", FileType.VLC);
  }
}
