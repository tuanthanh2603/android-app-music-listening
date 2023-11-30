package com.soundify.Adapter.Discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soundify.Model.Discover.BaiHat;
import com.soundify.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BaiHatAdapter extends RecyclerView.Adapter<BaiHatAdapter.ViewHolder> {
    Context context;
    ArrayList<BaiHat> listBaiHat;
    public BaiHatAdapter(Context context, ArrayList<BaiHat> listBaiHat){
        this.context = context;
        this.listBaiHat = listBaiHat;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_baihat, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat = listBaiHat.get(position);
        holder.tenBaiHat.setText(baiHat.getTenBaiHat());
        holder.tenCaSi.setText(baiHat.getCaSi());
//        holder.idBaiHat.setText(baiHat.getIdBaiHat());
        Picasso.get().load(baiHat.getHinhBaiHat()).into(holder.hinhBaiHat);

    }

    @Override
    public int getItemCount() {
        return listBaiHat.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView idBaiHat;
        TextView tenBaiHat;
        TextView tenCaSi;
        ImageView hinhBaiHat;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idBaiHat = itemView.findViewById(R.id.idBaiHat);
            tenBaiHat = itemView.findViewById(R.id.tenBaiHat);
            hinhBaiHat = itemView.findViewById(R.id.hinhBaiHat);
            tenCaSi = itemView.findViewById(R.id.tenCaSi);
        }
    }
}
