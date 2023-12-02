package com.soundify.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soundify.Model.Discover.BaiHat;
import com.soundify.R;

import java.util.ArrayList;

public class PlayMusicAdapter extends RecyclerView.Adapter<PlayMusicAdapter.ViewHolder>{
    Context context;
    ArrayList<BaiHat> listBaiHat;

    public PlayMusicAdapter(Context context, ArrayList<BaiHat> listBaiHat) {
        this.context = context;
        this.listBaiHat = listBaiHat;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_baihat_2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BaiHat baiHat = listBaiHat.get(position);
        holder.tvCaSi.setText(baiHat.getCaSi());
        holder.tvIndex.setText(position + 1 + "");
        holder.tvTenBaiHat.setText(baiHat.getTenBaiHat());
    }

    @Override
    public int getItemCount() {
        return listBaiHat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvIndex, tvTenBaiHat, tvCaSi;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvIndex = itemView.findViewById(R.id.tvPlayNumberMusicIndex);
            tvTenBaiHat = itemView.findViewById(R.id.tvPlayNameMusic);
            tvCaSi = itemView.findViewById(R.id.tvPlayNameCaSi);
        }
    }
}
