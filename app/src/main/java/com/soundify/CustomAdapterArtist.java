package com.soundify;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapterArtist extends ArrayAdapter {
    Context context;
    int layoutItem;
    ArrayList<Artist> lsArtist= new ArrayList<>();
    public CustomAdapterArtist(@NonNull Context context, int layoutItem, ArrayList<Artist> lsArtist) {
        super(context, layoutItem, lsArtist);
        this.context=context;
        this.layoutItem=layoutItem;
        this.lsArtist=lsArtist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Artist artist = lsArtist.get(position);

        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(layoutItem,null);
        }
        TextView tvNameArtist = (TextView) convertView.findViewById(R.id.txtNameAritis);
        ImageView imgArtist = (ImageView) convertView.findViewById(R.id.imgArtist);
        TextView tvNumFan = (TextView) convertView.findViewById(R.id.txtNufans);

        Picasso.with(context).load(artist.getPicLink()).resize(100, 100).into(imgArtist);
        tvNameArtist.setText(artist.getName());
        tvNumFan.setText(String.valueOf(artist.getNumOfFans()));

        return  convertView;
    }
}
