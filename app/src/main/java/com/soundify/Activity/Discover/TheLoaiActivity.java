package com.soundify.Activity.Discover;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.soundify.R;

public class TheLoaiActivity extends AppCompatActivity {
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_loai);
        Intent intent = getIntent();
        if(intent != null){
            String idTheLoai = intent.getStringExtra("ID_THELOAI");
            Toast.makeText(this, "ID: " + idTheLoai, Toast.LENGTH_SHORT).show();
        }
        addControl();
        addEvent();
    }
    private void addControl(){
        imageButton = (ImageButton) findViewById(R.id.back);
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