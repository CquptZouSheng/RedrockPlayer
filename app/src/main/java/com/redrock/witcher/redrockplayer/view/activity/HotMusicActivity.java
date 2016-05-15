package com.redrock.witcher.redrockplayer.view.activity;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.redrock.witcher.redrockplayer.R;
import com.redrock.witcher.redrockplayer.adapter.MyFragmentPager;
import com.redrock.witcher.redrockplayer.view.fragment.ChinaFragment;
import com.redrock.witcher.redrockplayer.view.fragment.FolkFragment;
import com.redrock.witcher.redrockplayer.view.fragment.GangTaiFragment;
import com.redrock.witcher.redrockplayer.view.fragment.JapanFragment;
import com.redrock.witcher.redrockplayer.view.fragment.KoreaFragment;
import com.redrock.witcher.redrockplayer.view.fragment.PopularFragment;
import com.redrock.witcher.redrockplayer.view.fragment.RockFragment;
import com.redrock.witcher.redrockplayer.view.fragment.SaleFragment;
import com.redrock.witcher.redrockplayer.view.fragment.WesternFragment;

import java.util.ArrayList;
public class HotMusicActivity extends AppCompatActivity {
    private ArrayList<android.support.v4.app.Fragment> fragmentArrayList;
    private ArrayList<String> titleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotmusic);
        initView();
    }
    private void initView() {
        titleList = new ArrayList<String>();
        titleList.add("欧美");
        titleList.add("内地");
        titleList.add("港台");
        titleList.add("韩国");
        titleList.add("日本");
        titleList.add("民谣");
        titleList.add("摇滚");
        titleList.add("销量");
        titleList.add("热歌");
        fragmentArrayList=new ArrayList<android.support.v4.app.Fragment>();
        fragmentArrayList.add(new WesternFragment());
        fragmentArrayList.add(new ChinaFragment());
        fragmentArrayList.add(new GangTaiFragment());
        fragmentArrayList.add(new KoreaFragment());
        fragmentArrayList.add(new JapanFragment());
        fragmentArrayList.add(new FolkFragment());
        fragmentArrayList.add(new RockFragment());
        fragmentArrayList.add(new SaleFragment());
        fragmentArrayList.add(new PopularFragment());
        MyFragmentPager adapter = new MyFragmentPager(getSupportFragmentManager(), fragmentArrayList,titleList);
        ViewPager vp = (ViewPager)findViewById(R.id.viewpager);
        vp.setAdapter(adapter);
    }
}

