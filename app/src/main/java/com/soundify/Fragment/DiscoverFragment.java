package com.soundify.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.soundify.Adapter.Discover.DangChuYAdapter;
import com.soundify.Adapter.Discover.TheLoaiAdapter;
import com.soundify.Model.Discover.DangChuY;
import com.soundify.Model.Discover.TheLoai;
import com.soundify.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DiscoverFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiscoverFragment extends Fragment {

    private RecyclerView recyclerView;

    private ArrayList<TheLoai> listTheLoai = new ArrayList<>();
    private ViewPager viewPager;
    private ArrayList<DangChuY> listDangChuY = new ArrayList<>();
    private Handler handler;
    private Runnable runnable;
    private final long DELAY_TIME = 4500;
    private final long PERIOD_TIME = 4500;
    private  DangChuYAdapter dangChuYAdapter1;



    private String url_theloai = "https://musicapp29263.000webhostapp.com/Server/gettheloai.php";
    private String url_dangchuy = "https://musicapp29263.000webhostapp.com/Server/dangchuy.php";


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DiscoverFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DiscoverFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DiscoverFragment newInstance(String param1, String param2) {
        DiscoverFragment fragment = new DiscoverFragment();
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
        RequestQueue requestQueueTheLoai = Volley.newRequestQueue(requireContext());
        StringRequest requestTheLoai = new StringRequest(Request.Method.GET, url_theloai, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(getContext(), response, Toast.LENGTH_LONG).show();
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for(int i = 0; i < jsonArray.length(); i++){
                        JSONObject theloaiJson = jsonArray.getJSONObject(i);
                        String idTheLoai = theloaiJson.getString("IdTheLoai");
                        String idChuDe = theloaiJson.getString("IdChuDe");
                        String tenTheLoai = theloaiJson.getString("TenTheLoai");
                        String hinhTheLoai = theloaiJson.getString("HinhTheLoai");
                        TheLoai tl = new TheLoai(idTheLoai,idChuDe, tenTheLoai, hinhTheLoai);
                        listTheLoai.add(tl);
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                TheLoaiAdapter adapter = new TheLoaiAdapter(requireContext(), listTheLoai);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Lỗi lấy dữ liệu", Toast.LENGTH_LONG).show();
            }
        });
        requestQueueTheLoai.add(requestTheLoai);

        RequestQueue requestQueueDangChuY = Volley.newRequestQueue(requireContext());
        StringRequest requestDangChuY = new StringRequest(Request.Method.GET, url_dangchuy, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++){
                        JSONObject dangchuyJson = jsonArray.getJSONObject(i);
                        String idQuangCao = dangchuyJson.getString("IdQuangCao");
                        String hinhQuangCao = dangchuyJson.getString("HinhQuangCao");
                        String noiDung = dangchuyJson.getString("NoiDung");
                        String idBaiHat = dangchuyJson.getString("IdBaiHat");
                        String tenBaiHat = dangchuyJson.getString("TenBaiHat");
                        String hinhBaiHat = dangchuyJson.getString("HinhBaiHat");

                        DangChuY dcy = new DangChuY(idQuangCao, hinhQuangCao, noiDung, idBaiHat, tenBaiHat, hinhBaiHat);
                        listDangChuY.add(dcy);
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                dangChuYAdapter1 = new DangChuYAdapter(requireContext(), listDangChuY);
                viewPager.setAdapter(dangChuYAdapter1);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Lỗi lấy dữ liệu", Toast.LENGTH_LONG).show();
            }
        });
        requestQueueDangChuY.add(requestDangChuY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
//        gridView = view.findViewById(R.id.gridViewTheLoai);
        recyclerView = view.findViewById(R.id.recyclerView);
        viewPager = view.findViewById(R.id.viewPager);
        handler = new Handler(Looper.getMainLooper());

        runnable = new Runnable() {
            @Override
            public void run() {
                int next = viewPager.getCurrentItem() + 1;
                if(next >= dangChuYAdapter1.getCount()){
                    next = 0;
                }
                viewPager.setCurrentItem(next , true);
                handler.postDelayed(this, PERIOD_TIME);
            }
        };

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(layoutManager);



        return view;
    }


    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable, DELAY_TIME);
    }

    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }
}