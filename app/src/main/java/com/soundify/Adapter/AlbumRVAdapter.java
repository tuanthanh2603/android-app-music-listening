package com.soundify.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soundify.Activity.AlbumDetailActivity;
import com.soundify.Model.AlbumRV;
import com.soundify.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumRVAdapter extends RecyclerView.Adapter<AlbumRVAdapter.ViewHolder> {
    private ArrayList<AlbumRV> albumRVArrayList;
    private Context context;
    public AlbumRVAdapter(ArrayList<AlbumRV> albumRVArrayList, Context context){
        this.albumRVArrayList = albumRVArrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public AlbumRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumRVAdapter.ViewHolder holder, int position) {
        AlbumRV albumRV = albumRVArrayList.get(position);
        Picasso.with(context).load(albumRV.imageUrl).into(holder.albumIV);
        holder.albumNameTV.setText(albumRV.name);
        holder.albumDetailTV.setText(albumRV.artistName);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, AlbumDetailActivity.class);
                i.putExtra("id", albumRV.id);
                i.putExtra("name", albumRV.name);
                i.putExtra("img", albumRV.imageUrl);
                i.putExtra("artist", albumRV.artistName);
                i.putExtra("albumUrl", albumRV.external_urls);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return albumRVArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView albumIV;
        private TextView albumNameTV, albumDetailTV;
        public ViewHolder(View itemView) {
            super(itemView);
            albumIV = itemView.findViewById(R.id.idIVAlbum);
            albumNameTV = itemView.findViewById(R.id.idTVAlbumName);
            albumDetailTV = itemView.findViewById(R.id.idTVALbumDetails);
        }
    }
}
