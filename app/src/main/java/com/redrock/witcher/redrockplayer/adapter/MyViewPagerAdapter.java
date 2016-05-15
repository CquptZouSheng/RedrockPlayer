package com.redrock.witcher.redrockplayer.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Zou Sheng on 2016/5/14.
 */
public class MyViewPagerAdapter extends PagerAdapter {
    private List<View> mListViews;
    private List<String> titleList;
    public MyViewPagerAdapter(List<View> mListViews,List<String> titleList) {
        this.mListViews = mListViews;
        this.titleList=titleList;
    }
    @Override
    public int getCount() {
        return  mListViews.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0==arg1;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object)   {
        container.removeView(mListViews.get(position));
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mListViews.get(position), 0);
        return mListViews.get(position);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

}
