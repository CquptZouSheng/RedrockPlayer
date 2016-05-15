package com.redrock.witcher.redrockplayer.view.activity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import com.redrock.witcher.redrockplayer.R;
import com.redrock.witcher.redrockplayer.adapter.MyViewPagerAdapter;
import java.util.ArrayList;
public class HotMusicActivity extends AppCompatActivity {
    private ArrayList<View> viewlist;
    private ViewPager viewPager;
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
        LayoutInflater layoutInflater = getLayoutInflater().from(this);
        View westernView = layoutInflater.inflate(R.layout.western_fragment, null);
        View chinaView = layoutInflater.inflate(R.layout.china_fragment, null);
        View gangtaiView = layoutInflater.inflate(R.layout.gangtai_fragment, null);
        View koreaView = layoutInflater.inflate(R.layout.korea_fragment, null);
        View japanView = layoutInflater.inflate(R.layout.japan_fragment, null);
        View folkView = layoutInflater.inflate(R.layout.folk_fragment, null);
        View rockView = layoutInflater.inflate(R.layout.rock_fragment, null);
        View saleView = layoutInflater.inflate(R.layout.sale_fragment, null);
        View popularView = layoutInflater.inflate(R.layout.popular_fragment, null);
        viewlist = new ArrayList<>();
        viewlist.add(westernView);
        viewlist.add(chinaView);
        viewlist.add(gangtaiView);
        viewlist.add(koreaView);
        viewlist.add(japanView);
        viewlist.add(folkView);
        viewlist.add(rockView);
        viewlist.add(saleView);
        viewlist.add(popularView);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(viewlist, titleList);
        viewPager.setAdapter(myViewPagerAdapter);

    }
}

