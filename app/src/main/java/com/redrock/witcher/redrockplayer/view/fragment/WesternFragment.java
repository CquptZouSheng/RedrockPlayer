package com.redrock.witcher.redrockplayer.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redrock.witcher.redrockplayer.Internet.NetRequest;
import com.redrock.witcher.redrockplayer.R;
import com.redrock.witcher.redrockplayer.adapter.HotSongAdapter;
import com.redrock.witcher.redrockplayer.view.activity.HotMusicActivity;

/**
 * Created by Zou Sheng on 2016/5/14.
 */
public class WesternFragment extends Fragment {
    private HotSongAdapter adapter;
    private RecyclerView recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.western_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        recyclerView = (RecyclerView) view.findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new HotSongAdapter(hotSongList);
        recyclerView.setAdapter(adapter);
        NetRequest netRequest=new NetRequest(hotSongList,,adapter);
    }
}
