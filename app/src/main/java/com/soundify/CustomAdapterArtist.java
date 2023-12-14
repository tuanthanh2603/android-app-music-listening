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
        TextView tvSequentialNumber = convertView.findViewById(R.id.textViewSequentialNumber);
        TextView tvNameTitle = (TextView) convertView.findViewById(R.id.tvNameTitle);
        TextView tvNameArtist = (TextView) convertView.findViewById(R.id.tvNameArtist);
        ImageView imgAlbum = (ImageView) convertView.findViewById(R.id.imgAlbum);


        if (tvSequentialNumber != null) {
            int sequentialNumber = artist.getSequentialNumber();
            tvSequentialNumber.setText(String.valueOf(sequentialNumber));
            if (sequentialNumber == 1) {
                tvSequentialNumber.setTextColor(Color.RED);
                tvSequentialNumber.setTextSize(40);
                tvNameArtist.setTextColor(Color.parseColor("#D3D3D3"));
                tvNameTitle.setTextColor(Color.parseColor("#D3D3D3"));
                tvNameTitle.setTextSize(18);
            } else if (sequentialNumber == 2) {
                tvSequentialNumber.setTextColor(Color.YELLOW);
                tvSequentialNumber.setTextSize(23);
                tvNameArtist.setTextColor(Color.parseColor("#D3D3D3"));
                tvNameTitle.setTextColor(Color.parseColor("#D3D3D3"));
                tvNameTitle.setTextSize(15);
            } else if (sequentialNumber == 3) {
                tvSequentialNumber.setTextColor(Color.GREEN);
                tvSequentialNumber.setTextSize(20);
                tvNameArtist.setTextColor(Color.parseColor("#D3D3D3"));
                tvNameTitle.setTextColor(Color.parseColor("#D3D3D3"));
                tvNameTitle.setTextSize(15);
            } else {
                tvSequentialNumber.setTextColor(Color.WHITE);
                tvSequentialNumber.setTextSize(18);
                tvNameArtist.setTextColor(Color.parseColor("#D3D3D3"));
                tvNameTitle.setTextColor(Color.parseColor("#D3D3D3"));
                tvNameTitle.setTextSize(15);
            }
        }


        tvNameTitle.setText(artist.getTitle());
        tvNameArtist.setText(artist.getArtist());
        Picasso.get().load(artist.getPicture()).resize(100, 100).into(imgAlbum);

        return  convertView;
    }
}
