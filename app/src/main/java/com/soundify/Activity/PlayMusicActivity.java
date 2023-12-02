package com.soundify.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.soundify.Adapter.PlayListMusicAdapter;
import com.soundify.Fragment.Fragment_Dia_Nhac;
import com.soundify.Fragment.Fragment_Play_List_Music;
import com.soundify.Model.Discover.BaiHat;
import com.soundify.R;

import java.util.ArrayList;

public class PlayMusicActivity extends AppCompatActivity {
    Toolbar toolbarPlayMusic;
    TextView tvTimeSong, tvTotalTimeSong;
    SeekBar seekBarTime;
    ImageButton btnNgauNhien, btnTruoc, btnPlay, btnSau, btnPhatLai;
    ViewPager viewPager;
    public static ArrayList<BaiHat> mangbaihat = new ArrayList<>();
    public static PlayListMusicAdapter adapternhac;
    Fragment_Dia_Nhac fragmentDiaNhac;
    Fragment_Play_List_Music fragmentPlayListMusic;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);

        getDataFromIntent();
        addControl();
    }

    private void getDataFromIntent(){
        Intent intent = getIntent();
        mangbaihat.clear();
        if(intent != null){
            if(intent.hasExtra("baihat")){
                BaiHat baiHat = intent.getParcelableExtra("baihat");
                Toast.makeText(this, baiHat.getTenBaiHat(), Toast.LENGTH_SHORT).show();
                mangbaihat.add(baiHat);
            } else if(intent.hasExtra("cacbaihat")){
                ArrayList<BaiHat> listBaiHat = intent.getParcelableArrayListExtra("cacbaihat");
                mangbaihat = listBaiHat;
                for (int i = 0; i < listBaiHat.size(); i++){
                    Toast.makeText(this, listBaiHat.get(i).getTenBaiHat(), Toast.LENGTH_SHORT).show();
                }
            }
        }

    }
    private void addControl(){
        toolbarPlayMusic = findViewById(R.id.toolbarPlayMusic);
        tvTimeSong = findViewById(R.id.tvTimeSong);
        tvTotalTimeSong = findViewById(R.id.tvTotalTimeSong);
        seekBarTime = findViewById(R.id.seekbarSong);
        btnNgauNhien = findViewById(R.id.imageButtonNgauNhien);
        btnTruoc = findViewById(R.id.imageButtonTruoc);
        btnPlay = findViewById(R.id.imageButtonPlay);
        btnSau = findViewById(R.id.imageButtonSau);
        btnPhatLai = findViewById(R.id.imageButtonPhatLai);
        viewPager = findViewById(R.id.viewPager2);
        setSupportActionBar(toolbarPlayMusic);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbarPlayMusic.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbarPlayMusic.setTitleTextColor(Color.BLUE);
        fragmentDiaNhac = new Fragment_Dia_Nhac();
        fragmentPlayListMusic = new Fragment_Play_List_Music();
        adapternhac = new PlayListMusicAdapter(getSupportFragmentManager());
        adapternhac.AddFragment(fragmentDiaNhac);
        adapternhac.AddFragment(fragmentPlayListMusic);


        viewPager.setAdapter(adapternhac);
    }
    class PlayMp3 extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }
    }
}