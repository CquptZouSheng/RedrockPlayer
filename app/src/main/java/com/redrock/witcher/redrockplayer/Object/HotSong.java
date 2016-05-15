package com.redrock.witcher.redrockplayer.Object;

import android.graphics.Bitmap;

/**
 * Created by Zou Sheng on 2016/5/15.
 */
public class HotSong {
    String singerName,songName;
    Bitmap albumPicSmall;
    public HotSong(Bitmap albumPicSmall, String singerName, String songName) {
        this.albumPicSmall = albumPicSmall;
        this.singerName = singerName;
        this.songName = songName;
    }

    public Bitmap getAlbumPicSmall() {
        return albumPicSmall;
    }

    public String getSingerName() {
        return singerName;
    }

    public String getSongName() {
        return songName;
    }
}
