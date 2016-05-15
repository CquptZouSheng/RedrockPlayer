package com.redrock.witcher.redrockplayer.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.redrock.witcher.redrockplayer.Object.HotSong;
import com.redrock.witcher.redrockplayer.R;

import java.util.List;

/**
 * Created by Zou Sheng on 2016/5/15.
 */
public class HotSongAdapter extends RecyclerView.Adapter<HotSongAdapter.MyViewHolder> {
    private List<HotSong> list;
    public HotSongAdapter(List<HotSong> list){
        this.list=list;
    }
    @Override
    public HotSongAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.albumpicsmall.setImageBitmap(list.get(position).getAlbumPicSmall());
        holder.songname.setText(list.get(position).getSongName());
        holder.singername.setText(list.get(position).getSingerName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView singername,songname;
        private ImageView albumpicsmall;
        public MyViewHolder(View itemView) {
            super(itemView);
            singername= (TextView) itemView.findViewById(R.id.singername);
            songname= (TextView) itemView.findViewById(R.id.songname);
            albumpicsmall= (ImageView) itemView.findViewById(R.id.albumpicsmall);
        }
    }
}