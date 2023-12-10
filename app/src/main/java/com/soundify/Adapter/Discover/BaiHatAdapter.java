package com.soundify.Adapter.Discover;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;


import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.soundify.Activity.PlayMusicActivity;
import com.soundify.Model.Discover.BaiHat;
import com.soundify.R;
import com.squareup.picasso.Picasso;


import java.io.IOException;
import java.util.ArrayList;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


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
        ImageButton imageButton;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idBaiHat = itemView.findViewById(R.id.idBaiHat);
            tenBaiHat = itemView.findViewById(R.id.tenBaiHat);
            hinhBaiHat = itemView.findViewById(R.id.hinhBaiHat);
            tenCaSi = itemView.findViewById(R.id.tenCaSi);
            imageButton = itemView.findViewById(R.id.imageButton2);

            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        BaiHat baiHat = listBaiHat.get(position);
                        String itemId = baiHat.getIdBaiHat();
//                        Toast.makeText(itemView.getContext(), "ID: " + itemId, Toast.LENGTH_SHORT).show();

                        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(itemView.getContext());
                        bottomSheetDialog.setContentView(R.layout.bottom_sheet_layout);

                        LinearLayout option1 = bottomSheetDialog.findViewById(R.id.option1);
                        LinearLayout option2 = bottomSheetDialog.findViewById(R.id.option2);
                        LinearLayout option3 = bottomSheetDialog.findViewById(R.id.option3);
                        TextView tenBaiHat = bottomSheetDialog.findViewById(R.id.tenBaiHat2);
                        TextView tenCaSi = bottomSheetDialog.findViewById(R.id.tenCaSi2);
                        ImageView hinhBaiHat = bottomSheetDialog.findViewById(R.id.hinhBaiHat2);

                        tenBaiHat.setText(baiHat.getTenBaiHat());
                        tenCaSi.setText(baiHat.getCaSi());
                        Picasso.get().load(baiHat.getHinhBaiHat()).into(hinhBaiHat);

                        option1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                bottomSheetDialog.dismiss();
                            }
                        });
                        option2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                bottomSheetDialog.dismiss();
                            }
                        });
                        option3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                bottomSheetDialog.dismiss();
                            }
                        });


                        bottomSheetDialog.show();
                    }
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlayMusicActivity.class);
                    intent.putExtra("baihat", listBaiHat.get(getPosition()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
