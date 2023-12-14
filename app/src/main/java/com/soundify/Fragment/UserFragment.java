package com.soundify.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soundify.Adapter.CardUserAdapter;
import com.soundify.CardItem;
import com.soundify.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserFragment extends Fragment {
    private static final int RC_SIGN_IN = 9001;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private List<CardItem> cardItemList;
    private CardUserAdapter cardAdapter;

    public UserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserFragment newInstance(String param1, String param2) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        // Tạo danh sách CardItem
        cardItemList = new ArrayList<>();
        cardItemList.add(new CardItem("SOUND VIP", "19,000đ", "Nghe với chất lượng cao nhất, không quảng cáo", "Nghe nhạc không quảng cáo", "Nghe và tải nhạc lossless", "Lưu trữ nhạc không giới hạn",
                R.drawable.ad_block, R.drawable.sound_wave, R.drawable.download, Color.parseColor("#F0E8FD")));
        cardItemList.add(new CardItem("SOUND PREMIUM", "49,000đ", "Toàn bộ đặc quyền VIP cùng kho nhạc Premium", "Kho nhạc Premium", "Nghe nhạc không quảng cáo", "Nghe và tải nhạc lossless",
                R.drawable.premium, R.drawable.sound_wave_premium, R.drawable.download_premium, Color.parseColor("#FCF5E3")));

        // Tạo Adapter và gắn vào RecyclerView
        cardAdapter = new CardUserAdapter(cardItemList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        recyclerView = view.findViewById(R.id.cardRecycle);

        // Thiết lập layout cho RecyclerView (ví dụ: LinearLayoutManager)
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // Gắn Adapter vào RecyclerView
        recyclerView.setAdapter(cardAdapter);

        return view;

    }

}