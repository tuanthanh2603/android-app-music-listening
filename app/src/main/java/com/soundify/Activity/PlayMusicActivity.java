package com.soundify.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.soundify.Model.Discover.BaiHat;
import com.soundify.R;

public class PlayMusicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        Intent intent = getIntent();
        if(intent.hasExtra("baihat")){
            BaiHat baiHat = intent.getParcelableExtra("baihat");
            Toast.makeText(this, baiHat.getTenBaiHat(), Toast.LENGTH_SHORT).show();
        }
    }
}