package com.soundify;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.icu.text.Transliterator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.android.volley.Request;
import androidx.core.content.ContextCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class baihatdacho extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private Button buttonPlayPause;
    private SeekBar seekBar;
    private Handler handler = new Handler();
    private boolean isPlaying = false;
    private boolean isRepeatMode = false;
    private boolean isRandomMode = false;
    private ArrayList<Artist> lsSeThich = new ArrayList<>();
    private ArrayList<Artist> lsArtist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baihatdacho);
        ListView lvChon,lvSeThich;
        lvChon = findViewById(R.id.lvChon);
        lvSeThich = findViewById(R.id.lvSeThich);
        buttonPlayPause = findViewById(R.id.buttonPlayPause);
        seekBar = findViewById(R.id.seekBar);
        Button buttonRepeat = findViewById(R.id.buttonRepeat);
        Button buttonPhatNgauNhien = findViewById(R.id.buttonPhatNgauNhien);
        String selectedLinkNhac = getIntent().getStringExtra("selectedLinkNhac");
        String url = "https://soundiiz.com/data/fileExamples/playlistExport.json";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String selectedId = getIntent().getStringExtra("selectedId");
        String selectedPosition = getIntent().getStringExtra("selectedPosition");
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                CustomAdapterArtist adapter = new CustomAdapterArtist(baihatdacho.this, R.layout.layout_item_baihatchon, lsArtist);
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject artistJson = jsonArray.getJSONObject(i);
                        String id = artistJson.getString("id");
                        if (id.equals(selectedId)) {
                            String title = artistJson.getString("title");
                            String artist = artistJson.getString("artist");
                            String picture = artistJson.getString("picture");
                            String linkNhac = artistJson.getString("preview");
                            String position = artistJson.getString("position");
                            Artist album = new Artist(id, title, artist, picture, linkNhac, position);
                            lsArtist.add(album);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                lvChon.setAdapter(adapter);


                CustomAdapterDaThich adapter1 = new CustomAdapterDaThich(baihatdacho.this, R.layout.layout_items_artist, lsSeThich);
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject artistJson = jsonArray.getJSONObject(i);
                        String id = artistJson.getString("id");
                        String position = artistJson.getString("position");
                        if (position.equals(selectedPosition)) {
                            String title = artistJson.getString("title");
                            String artist = artistJson.getString("artist");
                            String picture = artistJson.getString("picture");
                            String linknhac = artistJson.getString("preview");
                            Artist album = new Artist(id, title, artist, picture, linknhac, position);
                            lsSeThich.add(album);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                lvSeThich.setAdapter(adapter1);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {}
        });
        requestQueue.add(request);
        lvSeThich.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pauseMediaPlayer();
                Artist selectedArtist = lsSeThich.get(position);
                mediaPlayer = new MediaPlayer();
                try {
                    String selectedLinkNhac = selectedArtist.getLinknhac();
                    getIntent().putExtra("selectedLinkNhac", selectedLinkNhac);
                    mediaPlayer.setDataSource(selectedLinkNhac);
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String selectedId = selectedArtist.getId();
                getIntent().putExtra("selectedId", selectedId);
                updateLvChon(selectedId);
                buttonRepeat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (isRepeatMode == false) {
                            buttonRepeat.setText("Repeat On");
                            isRepeatMode = true;
                            buttonRepeat.setTextColor(Color.GREEN);
                            buttonPhatNgauNhien.setText("Random Off");
                            isRandomMode = false;
                            buttonPhatNgauNhien.setTextColor(Color.WHITE);
                        } else {
                            buttonRepeat.setText("Repeat Off");
                            isRepeatMode = false;
                            buttonRepeat.setTextColor(Color.WHITE);
                        }
                    }
                });
                buttonPhatNgauNhien.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (isRandomMode == false) {
                            buttonPhatNgauNhien.setText("Random On");
                            isRandomMode = true;
                            buttonPhatNgauNhien.setTextColor(Color.GREEN);
                            buttonRepeat.setText("Repeat Off");
                            isRepeatMode = false;
                            buttonRepeat.setTextColor(Color.WHITE);
                        } else {
                            buttonPhatNgauNhien.setText("Random Off");
                            isRandomMode = false;
                            buttonPhatNgauNhien.setTextColor(Color.WHITE);
                        }
                    }
                });
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        if (isRandomMode) {
                            phatNgauNhien();
                        }
                        if (isRepeatMode) {
                            // If repeat mode is on, restart the media player
                            mp.seekTo(0);
                            mp.start();
                        } else {
                            buttonPlayPause.setText("Play");
                            isPlaying = false;
                        }
                    }
                });
                playMediaPlayer();
            }
        });
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(selectedLinkNhac);
            mediaPlayer.prepare();
        } catch (IOException e) {e.printStackTrace();}
        buttonPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer != null) {
                    if (isPlaying) {
                        pauseMediaPlayer();
                    } else {
                        playMediaPlayer();
                    }
                }
            }
        });
        if (mediaPlayer != null) {
            seekBar.setMax(mediaPlayer.getDuration());
        }
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && mediaPlayer != null) {
                    mediaPlayer.seekTo(progress);
                }
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Không làm gì khi bắt đầu chạm vào SeekBar
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Không làm gì khi kết thúc chạm vào SeekBar
            }
        });
        buttonRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRepeatMode == false) {
                    buttonRepeat.setText("Repeat On");
                    isRepeatMode = true;
                    buttonRepeat.setTextColor(Color.GREEN);
                    buttonPhatNgauNhien.setText("Random Off");
                    isRandomMode = false;
                    buttonPhatNgauNhien.setTextColor(Color.WHITE);
                } else {
                    buttonRepeat.setText("Repeat Off");
                    isRepeatMode = false;
                    buttonRepeat.setTextColor(Color.WHITE);
                }
            }
        });
        buttonPhatNgauNhien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isRandomMode == false) {
                    buttonPhatNgauNhien.setText("Random On");
                    isRandomMode = true;
                    buttonPhatNgauNhien.setTextColor(Color.GREEN);
                    buttonRepeat.setText("Repeat Off");
                    isRepeatMode = false;
                    buttonRepeat.setTextColor(Color.WHITE);
                } else {
                    buttonPhatNgauNhien.setText("Random Off");
                    isRandomMode = false;
                    buttonPhatNgauNhien.setTextColor(Color.WHITE);
                }
            }
        });
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (isRandomMode) {
                    phatNgauNhien();
                }
                if (isRepeatMode) {
                    mp.seekTo(0);
                    mp.start();
                } else {
                    buttonPlayPause.setText("Play");
                    isPlaying = false;
                }
            }
        });



        updateSeekBar();
        playMediaPlayer();
    }




    private void phatNgauNhien() {
        Random random = new Random();
        int index = random.nextInt(lsSeThich.size());
        Artist baiHatNgauNhien = lsSeThich.get(index);

        Intent intent = new Intent();
        intent.putExtra("selectedId", baiHatNgauNhien.getId());
        intent.putExtra("selectedLinkNhac", baiHatNgauNhien.getLinknhac());

        Toast.makeText(getApplicationContext(), "Selected link nhac: " + baiHatNgauNhien.getLinknhac(), Toast.LENGTH_SHORT).show();

        updateLvChon(baiHatNgauNhien.getId());

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                if (isRandomMode) {
                    phatNgauNhien();
                }
                if (isRepeatMode) {
                    mp.seekTo(0);
                    mp.start();
                } else {
                    buttonPlayPause.setText("Play");
                    isPlaying = false;
                }
            }
        });
        try {
            mediaPlayer.setDataSource(baiHatNgauNhien.getLinknhac());
            mediaPlayer.prepare();
            playMediaPlayer();
        } catch (IOException e) {
            e.printStackTrace(); // Log the exception for debugging
            Toast.makeText(getApplicationContext(), "Error playing the selected song", Toast.LENGTH_SHORT).show();
        }
    }
    public void updateLvSeThich(String selectedPosition){
        ListView lvSeThich;
        ArrayList<Artist> lsSeThich =new ArrayList<>();
        lvSeThich=findViewById(R.id.lvSeThich);
        String url = "https://soundiiz.com/data/fileExamples/playlistExport.json";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject artistJson = jsonArray.getJSONObject(i);
                        String id= artistJson.getString("id");
                        String position = artistJson.getString("position");
                        if ( position.equals(selectedPosition)) {
                            String title = artistJson.getString("title");
                            String artist = artistJson.getString("artist");
                            String picture = artistJson.getString("picture");
                            String linknhac = artistJson.getString("preview");
                            Artist Album = new Artist( id,title,  artist,  picture,linknhac,position);
                            lsSeThich.add(Album);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                CustomAdapterArtist adapter1 = new CustomAdapterArtist(baihatdacho.this, R.layout.layout_items_artist, lsSeThich);
                lvSeThich.setAdapter(adapter1);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR", "Volley error: " + error.getMessage());
            }
        });
        requestQueue.add(request);
    }
    public void updateLvChon(String selectedId) {
        ListView lvChon;
        ArrayList<Artist> lsArtist = new ArrayList<>();
        lvChon = findViewById(R.id.lvChon);
        String url = "https://soundiiz.com/data/fileExamples/playlistExport.json";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject artistJson = jsonArray.getJSONObject(i);
                        String id = artistJson.getString("id");
                        if (id.equals(selectedId)) {
                            String title = artistJson.getString("title");
                            String artist = artistJson.getString("artist");
                            String picture = artistJson.getString("picture");
                            String linkNhac = artistJson.getString("preview");
                            String position = artistJson.getString("position");
                            Artist album = new Artist(id, title, artist, picture, linkNhac, position);
                            lsArtist.add(album);
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                CustomAdapterArtist adapter = new CustomAdapterArtist(baihatdacho.this, R.layout.layout_item_baihatchon, lsArtist);
                lvChon.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("ERROR", "Volley error: " + error.getMessage());
            }
        });
        requestQueue.add(request);
    }
    private void updateSeekBar() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null && mediaPlayer.isPlaying()) {
                    int currentPosition = mediaPlayer.getCurrentPosition();
                    seekBar.setProgress(currentPosition);

                    // Cập nhật thời gian hiện tại
                    TextView textViewStartTime = findViewById(R.id.textViewStartTime);
                    textViewStartTime.setText(formatTime(currentPosition));

                    // Cập nhật thời gian kết thúc
                    TextView textViewEndTime = findViewById(R.id.textViewEndTime);
                    textViewEndTime.setText(formatTime(mediaPlayer.getDuration()));

                    // Tiếp tục cập nhật vị trí SeekBar
                    updateSeekBar();
                }
            }
        }, 1000); // Cập nhật mỗi 1 giây
    }
    private String formatTime(int timeInMillis) {
        int seconds = (timeInMillis / 1000) % 60;
        int minutes = (timeInMillis / (1000 * 60)) % 60;
        return String.format("%d:%02d", minutes, seconds);
    }
    private void playMediaPlayer() {
        if (mediaPlayer != null && !mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            isPlaying = true;
            buttonPlayPause.setText("Pause");
            updateSeekBar();
        }
    }
    private void pauseMediaPlayer() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
            isPlaying = false;
            buttonPlayPause.setText("Play");
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}

