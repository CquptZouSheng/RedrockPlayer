package com.redrock.witcher.redrockplayer.Internet;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Zou Sheng on 2016/5/15.
 */
public class Net {
    public static final String TAG="HotMusicActivity";
    public static InputStream get(String url) {
        HttpURLConnection connection = null;
        try {
            Log.d(TAG, url);
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setReadTimeout(8000);
            connection.setConnectTimeout(8000);
            return connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}