package com.soundify;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.soundify.Fragment.DiscoverFragment;
import com.soundify.Fragment.LibraryFragment;
import com.soundify.Fragment.RadioFragment;
import com.soundify.Fragment.SoundifyFragment;
import com.soundify.Fragment.UserFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    FrameLayout frameLayout;
    Toolbar toolbar;
//Hoang Huy
    //Committ
    //Tuanthanh
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();
        loadFragment(new LibraryFragment());

    }

    @Override
    protected void onStart() {
        super.onStart();
    }
    private void connected(){

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void addControl(){

        bottomNavigationView = findViewById(R.id.bottom_nav);
        frameLayout = findViewById(R.id.frameFragment);
        toolbar = findViewById(R.id.toolbar);
    }
    private void addEvent(){
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id == R.id.action_library){
                    loadFragment(new LibraryFragment());
                    toolbar.setTitle("Thư viện");
                    return true;
                } else if(id == R.id.actiton_discorver){
                    loadFragment(new DiscoverFragment());
                    toolbar.setTitle("Khám phá");
                    return true;
                } else if (id == R.id.action_rating) {
                    loadFragment(new SoundifyFragment());
                    toolbar.setTitle("Soundify");
                    return true;
                } else if (id == R.id.action_radio) {
                    loadFragment(new RadioFragment());
                    toolbar.setTitle("Radio");
                    return true;
                } else if (id == R.id.action_user) {
                    loadFragment(new UserFragment());
                    toolbar.setTitle("Cá nhân");
                    return true;
                }
                return false;
            }
        });
    }
    private void loadFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameFragment, fragment);
        fragmentTransaction.commit();
    }
}