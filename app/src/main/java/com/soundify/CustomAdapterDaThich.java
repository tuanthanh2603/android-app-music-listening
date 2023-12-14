package com.soundify;

import android.content.Context;
import android.graphics.Color;
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

public class CustomAdapterDaThich extends ArrayAdapter {
    Context context;
    int layoutItem;
    ArrayList<Artist> lsArtist= new ArrayList<>();

    public CustomAdapterDaThich(@NonNull Context context, int layoutItem, ArrayList<Artist> lsArtist) {
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

        TextView tvNameTitle = (TextView) convertView.findViewById(R.id.tvNameTitle);
        TextView tvNameArtist = (TextView) convertView.findViewById(R.id.tvNameArtist);
        ImageView imgAlbum = (ImageView) convertView.findViewById(R.id.imgAlbum);

        tvNameTitle.setText(artist.getTitle());
        tvNameArtist.setText(artist.getArtist());
        Picasso.get().load(artist.getPicture()).resize(100, 100).into(imgAlbum);

        return  convertView;
    }
}
