package com.soundify.Adapter.Discover;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.soundify.Model.Discover.DangChuY;
import com.soundify.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DangChuYAdapter extends PagerAdapter {
    private Context context;
    private ArrayList<DangChuY> listDangChuY;

    @Override
    public int getCount() {
        return listDangChuY.size();
    }
    public DangChuYAdapter(Context context, ArrayList<DangChuY> listDangChuY){
        this.context = context;
        this.listDangChuY = listDangChuY;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_dang_chu_y, container, false);

        ImageView hinhQuangCao = view.findViewById(R.id.hinhQuangCao);
        ImageView hinhBaiHatQuangCao = view.findViewById(R.id.hinhBaiHatQuangCao);
        TextView tenBaiHatQuangCao = view.findViewById(R.id.tenBaiHatQuangCao);
        TextView noiDungQuangCao = view.findViewById(R.id.noiDungQuangCao);

        DangChuY dangChuY = listDangChuY.get(position);

        tenBaiHatQuangCao.setText(dangChuY.getTenBaiHat());
        noiDungQuangCao.setText(dangChuY.getNoiDung());
        Picasso.get().load(dangChuY.getHinhBaiHat()).into(hinhBaiHatQuangCao);
        Picasso.get().load(dangChuY.getHinhQuangCao()).into(hinhQuangCao);
        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
