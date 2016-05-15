package com.redrock.witcher.redrockplayer.Internet;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.redrock.witcher.redrockplayer.Object.HotSong;
import com.redrock.witcher.redrockplayer.adapter.HotSongAdapter;
import com.redrock.witcher.redrockplayer.view.activity.HotMusicActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Zou Sheng on 2016/5/15.
 */
public class NetRequest {
    public static ArrayList<HotSong> hotSongList;
    private static String url;
    public static HotSongAdapter adapter;
    public static final int SHOW_RESPONSE=1;

    public static final String TAG="HotMusicActivity";
    public NetRequest(ArrayList<HotSong> hotSongList, String url,HotSongAdapter adapter) {
        this.hotSongList = hotSongList;
        this.url = url;
        this.adapter=adapter;
    }



    public static void sendRequestWithHttpURLConnection() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Net.get(url)));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        response.append(line).append("\n");
                        Log.d("HotMusicActivity",line);
                    }
                    parseJSONWithJSONObject(response.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SHOW_RESPONSE:
                    HotSong hotSong= (HotSong) msg.obj;
                    hotSongList.add(hotSong);
                    adapter.notifyDataSetChanged();
            }
        }
    };

    private static void parseJSONWithJSONObject(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray = jsonObject.getJSONArray("songlist");
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                Message message = new Message();
                message.what = SHOW_RESPONSE;
                HotSong hotSong=new HotSong(BitmapFactory.decodeStream(Net.get(jsonObject.getString("albumpic_small"))),jsonObject.getString("singername"),jsonObject.getString("songname"));
                message.obj = hotSong;
                handler.sendMessage(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String getUrl() {
        return url;}
}
