package com.redrock.witcher.redrockplayer.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redrock.witcher.redrockplayer.Internet.NetRequest;
import com.redrock.witcher.redrockplayer.Object.HotSong;
import com.redrock.witcher.redrockplayer.R;
import com.redrock.witcher.redrockplayer.adapter.HotSongAdapter;

import java.util.ArrayList;

/**
 * Created by Zou Sheng on 2016/5/14.
 */
public class WesternFragment extends Fragment {
    private  static HotSongAdapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<HotSong>hotSongList;
    public static final String TAG="HotMusicActivity";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.western_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        hotSongList=new ArrayList<HotSong>();
        adapter = new HotSongAdapter(hotSongList);
        NetRequest netRequest=new NetRequest(hotSongList,
                "http://route.showapi.com/213-4?showapi_appid=19023&topid=5&" +
                        "showapi_sign=9c7441232d11469d94472d57bf30b582",adapter);
        netRequest.sendRequestWithHttpURLConnection();
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }
}
