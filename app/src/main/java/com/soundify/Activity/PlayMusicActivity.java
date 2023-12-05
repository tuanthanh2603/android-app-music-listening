package com.soundify.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
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

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;

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
    int position = 0;
    boolean repeat = false;
    boolean checkrandom = false;
    boolean next = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        getDataFromIntent();
        addControl();
        addEvent();
    }
    private void addEvent(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (adapternhac.getItem(1) != null){
                    if (mangbaihat.size() > 0){
                        fragmentDiaNhac.PlayMusic(mangbaihat.get(0).getHinhBaiHat());
                        handler.removeCallbacks(this);
                    } else {
                        handler.postDelayed(this, 300);
                    }
                }
            }
        }, 500);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.baseline_play_circle_outline_24);
                } else {
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.iconpause);
                }
            }
        });
        btnPhatLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(repeat == false){
                    if(checkrandom == true){
                        checkrandom = false;
//                        btnPhatLai.setImageResource()
                    }
                    repeat = true;

                } else {
                    btnPhatLai.setImageResource(R.drawable.baseline_refresh_24);
                    repeat = false;
                }
            }
        });
        btnNgauNhien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        seekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
        btnTruoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mangbaihat.size() > 0){
                    if(mediaPlayer.isPlaying() || mediaPlayer != null){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if(position < (mangbaihat.size())){
                        btnPlay.setImageResource(R.drawable.iconpause);
                        position++;
                        if(repeat == true){
                            if(position == 0){
                                position = mangbaihat.size();
                            }
                            position -= 1;
                        }
                        if(checkrandom == true){
                            Random random = new Random();
                            int index = random.nextInt(mangbaihat.size());
                            if(index == position){
                                position = index -1;
                            }
                            position = index;
                        }
                        if(position > (mangbaihat.size() - 1)){
                            position = 0;
                        }
                        new PlayMp3().execute(mangbaihat.get(position).getLinkNhac());
                        fragmentDiaNhac.PlayMusic(mangbaihat.get(position).getHinhBaiHat());
                        getSupportActionBar().setTitle(mangbaihat.get(position).getTenBaiHat());
                        UpdateTime();
                    }
                }
                btnTruoc.setClickable(false);
                btnSau.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnTruoc.setClickable(true);
                        btnSau.setClickable(true);
                    }
                }, 500);
            }
        });
        btnSau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mangbaihat.size() > 0){
                    if(mediaPlayer.isPlaying() || mediaPlayer != null){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                    if(position < (mangbaihat.size())){
                        btnPlay.setImageResource(R.drawable.iconpause);
                        position--;
                        if(position < 0){
                            position = mangbaihat.size() - 1;
                        }
                        if(repeat == true){

                            position += 1;
                        }
                        if(checkrandom == true){
                            Random random = new Random();
                            int index = random.nextInt(mangbaihat.size());
                            if(index == position){
                                position = index -1;
                            }
                            position = index;
                        }

                        new PlayMp3().execute(mangbaihat.get(position).getLinkNhac());
                        fragmentDiaNhac.PlayMusic(mangbaihat.get(position).getHinhBaiHat());
                        getSupportActionBar().setTitle(mangbaihat.get(position).getTenBaiHat());
                        UpdateTime();
                    }
                }
                btnTruoc.setClickable(false);
                btnSau.setClickable(false);
                Handler handler1 = new Handler();
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        btnTruoc.setClickable(true);
                        btnSau.setClickable(true);
                    }
                }, 500);
            }
        });


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
                mediaPlayer.stop();
                mangbaihat.clear();
            }
        });
        toolbarPlayMusic.setTitleTextColor(Color.BLUE);
        fragmentDiaNhac = new Fragment_Dia_Nhac();
        fragmentPlayListMusic = new Fragment_Play_List_Music();
        adapternhac = new PlayListMusicAdapter(getSupportFragmentManager());
        adapternhac.AddFragment(fragmentDiaNhac);
        adapternhac.AddFragment(fragmentPlayListMusic);


        viewPager.setAdapter(adapternhac);
//        fragmentDiaNhac = (Fragment_Dia_Nhac) adapternhac.getItem(1);
//
        if (mangbaihat.size() > 0) {
            getSupportActionBar().setTitle(mangbaihat.get(0).getTenBaiHat());
            new PlayMp3().execute(mangbaihat.get(0).getLinkNhac());
            btnPlay.setImageResource(R.drawable.iconpause);
        }
    }
    class PlayMp3 extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        mediaPlayer.stop();
                        mediaPlayer.reset();
                    }
                });

                mediaPlayer.setDataSource(s);
                mediaPlayer.prepare();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            mediaPlayer.start();
            TimeSong();
            UpdateTime();
        }
    }

    private void TimeSong() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        tvTotalTimeSong.setText(simpleDateFormat.format(mediaPlayer.getDuration()));
        seekBarTime.setMax(mediaPlayer.getDuration());
    }
    private void UpdateTime(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer != null){
                    seekBarTime.setProgress(mediaPlayer.getCurrentPosition());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                    tvTimeSong.setText(simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                    handler.postDelayed(this, 300);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            next = true;
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    });
                }
            }
        }, 300);
        Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(next == true){
                    if(mangbaihat.size() > 0){
                        if(mediaPlayer.isPlaying() || mediaPlayer != null){
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            mediaPlayer = null;
                        }
                        if(position < (mangbaihat.size())){
                            btnPlay.setImageResource(R.drawable.iconpause);
                            position++;
                            if(repeat == true){
                                if(position == 0){
                                    position = mangbaihat.size();
                                }
                                position -= 1;
                            }
                            if(checkrandom == true){
                                Random random = new Random();
                                int index = random.nextInt(mangbaihat.size());
                                if(index == position){
                                    position = index -1;
                                }
                                position = index;
                            }
                            if(position > (mangbaihat.size() - 1)){
                                position = 0;
                            }
                            new PlayMp3().execute(mangbaihat.get(position).getLinkNhac());
                            fragmentDiaNhac.PlayMusic(mangbaihat.get(position).getHinhBaiHat());
                            getSupportActionBar().setTitle(mangbaihat.get(position).getTenBaiHat());
                        }
                    }
                    btnTruoc.setClickable(false);
                    btnSau.setClickable(false);
                    Handler handler1 = new Handler();
                    handler1.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            btnTruoc.setClickable(true);
                            btnSau.setClickable(true);
                        }
                    }, 5000);
                    next = false;
                    handler1.removeCallbacks(this);

                } else {
                    handler1.postDelayed(this, 1000);
                }
            }
        }, 1000);
    }
}