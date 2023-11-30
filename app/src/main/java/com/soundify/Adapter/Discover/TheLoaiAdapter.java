package com.soundify.Adapter.Discover;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.soundify.Activity.Discover.TheLoaiActivity;
import com.soundify.Model.Discover.TheLoai;
import com.soundify.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class TheLoaiAdapter extends RecyclerView.Adapter<TheLoaiAdapter.ViewHolder> {
    Context context;
    int layoutItem;
    ArrayList<TheLoai> listTheLoai;
    public TheLoaiAdapter(Context context, ArrayList<TheLoai> listTheLoai){
        this.context = context;
        this.listTheLoai = listTheLoai;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_theloai, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TheLoai theLoai = listTheLoai.get(position);
//        holder.idTheLoai.setText("TL: " + theLoai.getIdTheLoai());
//        holder.idChuDe.setText("CD: " + theLoai.getIdChuDe());
        holder.tenTheLoai.setText(theLoai.getTenTheLoai());
        Picasso.get().load(theLoai.getHinhTheLoai()).into(holder.hinhTheLoai);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String clickedItemId = theLoai.getIdTheLoai();
                Toast.makeText(context, "ID Thể loại: " + clickedItemId, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, TheLoaiActivity.class);
                intent.putExtra("ID_THELOAI", clickedItemId);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listTheLoai.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView idTheLoai;
        TextView idChuDe;
        TextView tenTheLoai;
        ImageView hinhTheLoai;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idTheLoai = itemView.findViewById(R.id.idTheLoai);
            idChuDe = itemView.findViewById(R.id.idChuDe);
            tenTheLoai = itemView.findViewById(R.id.tenTheLoai);
            hinhTheLoai = itemView.findViewById(R.id.hinhTheLoai);
        }
    }

//    public TheLoaiAdapter(@NonNull Context context, int resource, ArrayList<TheLoai> listTheLoai) {
//        super(context, resource, listTheLoai);
//        this.context = context;
//        this.layoutItem = resource;
//        this.listTheLoai = listTheLoai;
//    }
//
//    @NonNull
//    @Override
//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        TheLoai theLoai = listTheLoai.get(position);
//        if(convertView == null){
//            convertView = LayoutInflater.from(context).inflate(layoutItem, null);
//        }
//        TextView idTheLoai = (TextView) convertView.findViewById(R.id.idTheLoai);
//        TextView idChuDe = (TextView) convertView.findViewById(R.id.idChuDe);
//        TextView tenTheLoai = (TextView) convertView.findViewById(R.id.tenTheLoai);
//        ImageView hinhTheLoai = (ImageView) convertView.findViewById(R.id.hinhTheLoai);
//
//
//
//        idTheLoai.setText("TL: " + theLoai.getIdTheLoai());
//        idChuDe.setText("CD: "+theLoai.getIdChuDe());
//        tenTheLoai.setText(theLoai.getTenTheLoai());
//        Picasso.get().load(theLoai.getHinhTheLoai()).into(hinhTheLoai);
//        return convertView;
//    }
}
