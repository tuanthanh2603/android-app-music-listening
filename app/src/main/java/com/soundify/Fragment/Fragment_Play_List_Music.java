package com.soundify.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.soundify.Activity.PlayMusicActivity;
import com.soundify.Adapter.PlayMusicAdapter;
import com.soundify.R;

public class Fragment_Play_List_Music extends Fragment {
    View view;
    RecyclerView recyclerViewPlayMusic;
    PlayMusicAdapter playMusicAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_list_music, container, false);
        recyclerViewPlayMusic = view.findViewById(R.id.recyclerViewPlayMusic);
        if(PlayMusicActivity.mangbaihat.size() > 0){
            playMusicAdapter = new PlayMusicAdapter(getActivity(), PlayMusicActivity.mangbaihat);
            recyclerViewPlayMusic.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerViewPlayMusic.setAdapter(playMusicAdapter);
        }

        return view;
    }
}
