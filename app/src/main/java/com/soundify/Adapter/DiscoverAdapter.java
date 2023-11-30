package com.soundify.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.soundify.Model.ChuDe;
import com.soundify.R;

import java.util.ArrayList;

public class DiscoverAdapter extends ArrayAdapter {
    Context context;
    int layoutItem;
    ArrayList<ChuDe> listChuDe = new ArrayList<>();
    public DiscoverAdapter(@NonNull Context context, int resource, ArrayList<ChuDe> listChuDe) {
        super(context, resource, listChuDe);
        this.context = context;
        this.layoutItem = resource;
        this.listChuDe = listChuDe;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ChuDe chuDe = listChuDe.get(position);
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(layoutItem, null);
        }
        TextView tvIdChuDe = (TextView) convertView.findViewById(R.id.tvIdChuDe);
        TextView tvTenChu = (TextView) convertView.findViewById(R.id.tvTenChuDe);

//        tvIdChuDe.setText(chuDe.getIdChuDe());
//        tvTenChu.setText(chuDe.getTenChuDe());
        return convertView;
    }
}
