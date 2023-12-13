package com.soundify.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soundify.R;

public class DualImageAdapter extends RecyclerView.Adapter<DualImageAdapter.ViewHolder> {

    private Context context;
    private int[] images;

    public DualImageAdapter(Context context, int[] images) {
        this.context = context;
        this.images = images;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dual_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int firstImage = images[position * 2];
        int secondImage = images[position * 2 + 1];

        holder.imageView1.setImageResource(firstImage);
        holder.imageView2.setImageResource(secondImage);

        // Hiển thị chữ "Live" dưới mỗi hình ảnh
        holder.textLive1.setVisibility(View.VISIBLE);
        holder.textLive2.setVisibility(View.VISIBLE);
    }

    @Override
    public int getItemCount() {
        // Số lượng hàng trong RecyclerView
        return (int) Math.ceil(images.length / 2.0);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView1;
        ImageView imageView2;
        TextView textLive1;
        TextView textLive2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView1 = itemView.findViewById(R.id.imageView1);
            imageView2 = itemView.findViewById(R.id.imageView2);
            textLive1 = itemView.findViewById(R.id.textLive1);
            textLive2 = itemView.findViewById(R.id.textLive2);
        }
    }
}


