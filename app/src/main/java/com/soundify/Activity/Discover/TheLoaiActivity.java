package com.soundify.Activity.Discover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.soundify.Adapter.Discover.BaiHatAdapter;
import com.soundify.Model.Discover.BaiHat;
import com.soundify.R;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TheLoaiActivity extends AppCompatActivity {
    private ImageButton imageButton;
    private ImageView imageView;
    private RecyclerView recyclerView;
    private ArrayList<BaiHat> listBaiHat = new ArrayList<>();
    private String base_url = "https://musicapp29263.000webhostapp.com/Server/getsongbygenre.php";
    private BaiHatAdapter baiHatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);
        Intent intent = getIntent();
        if(intent != null){
            String idTheLoai = intent.getStringExtra("ID_THELOAI");
//            Toast.makeText(this, "ID: " + idTheLoai, Toast.LENGTH_SHORT).show();
        }

        addControl();
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        addEvent();
        fetchDataFromUrl();
    }

    private void fetchDataFromUrl(){
        RequestQueue queue = Volley.newRequestQueue(this);
        String idTheLoai = getIntent().getStringExtra("ID_THELOAI");
        final String finalIdTheLoai = idTheLoai != null ? idTheLoai: "";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, base_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i <jsonArray.length(); i++){
                        JSONObject baihatJson = jsonArray.getJSONObject(i);
                        String idBaiHat = baihatJson.getString("IdBaiHat");
                        String tenBaiHat = baihatJson.getString("TenBaiHat");
                        String tenCaSi = baihatJson.getString("CaSi");
                        String hinhBaiHat = baihatJson.getString("HinhBaiHat");
                        String idTheLoai = baihatJson.getString("IdTheLoai");
                        String hinhTheLoai = baihatJson.getString("HinhTheLoai");
                        if(idTheLoai.equals(finalIdTheLoai)){
                            BaiHat bh = new BaiHat(idBaiHat, tenBaiHat, hinhBaiHat, tenCaSi, idTheLoai, hinhTheLoai);
                            listBaiHat.add(bh);
                        }

                    }

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
                baiHatAdapter = new BaiHatAdapter(TheLoaiActivity.this, listBaiHat);
                recyclerView.setAdapter(baiHatAdapter);
                if(!listBaiHat.isEmpty()){
                    String imageUrl = listBaiHat.get(0).getHinhTheLoai();
                    Picasso.get().load(imageUrl).into(imageView);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(TheLoaiActivity.this, "Lỗi lấy dữ liệu", Toast.LENGTH_LONG).show();
            }
        });
        queue.add(stringRequest);
    }
    private void addControl(){

        imageButton = (ImageButton) findViewById(R.id.back);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewBaiHat);
        imageView = (ImageView) findViewById(R.id.hinhTheLoai2);

    }
    private void addEvent(){
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}