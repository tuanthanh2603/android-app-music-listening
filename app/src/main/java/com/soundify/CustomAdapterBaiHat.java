package com.soundify;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapterBaiHat extends ArrayAdapter<Artist> {
    Context context;
    int layoutItem;
    ArrayList<Artist> lsArtist;

    public CustomAdapterBaiHat(@NonNull Context context, int layoutItem, ArrayList<Artist> lsArtist) {
        super(context, layoutItem, lsArtist);
        this.context = context;
        this.layoutItem = layoutItem;
        this.lsArtist = lsArtist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        Artist artist = lsArtist.get(position);
//
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(layoutItem, null);
//        }
//
//        // Find views in the layout_item_rotating_disc.xml
////        ImageView imgRotatingDisc = convertView.findViewById(R.id.imgRotatingDisc);
//        TextView tvNameTitle = convertView.findViewById(R.id.tvNameTitle);
//        TextView tvNameArtist = convertView.findViewById(R.id.tvNameArtist);
//
//        // Set data to views
//        tvNameTitle.setText(artist.getTitle());
//        tvNameArtist.setText(artist.getArtist());
//        Picasso.get().load(artist.getPicture()).resize(100, 100).into(imgRotatingDisc);
//
//        // Start rotation animation for the disc
//        startRotationAnimation(imgRotatingDisc);

        return convertView;
    }

    private void startRotationAnimation(ImageView rotatingDisc) {
        Animation rotation = AnimationUtils.loadAnimation(context, R.anim.rotate_anim);
        rotatingDisc.startAnimation(rotation);
    }
}

