package com.redrock.witcher.redrockplayer.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.redrock.witcher.redrockplayer.R;

/**
 * Created by Zou Sheng on 2016/5/14.
 */
public class KoreaFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.korea_fragment, container, false);
    }
}
