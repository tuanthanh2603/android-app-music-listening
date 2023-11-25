package com.soundify.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.soundify.Artist;
import com.soundify.CustomAdapterArtist;
import com.soundify.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SoundifyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SoundifyFragment extends Fragment {
    TextView tvArtist;
    ListView lvArtist;
    ArrayList<Artist> lsArtist = new ArrayList<>();
    String url = "https://soundiiz.com/data/fileExamples/artistsExport.json";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SoundifyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SoundifyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SoundifyFragment newInstance(String param1, String param2) {
        SoundifyFragment fragment = new SoundifyFragment();
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

        RequestQueue requestQueue = Volley.newRequestQueue(requireContext());
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println(response);
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject artistJson = jsonArray.getJSONObject(i);
                        String name = artistJson.getString("name");
                        String fanNumber = artistJson.getString("fans");
                        String linkPic = artistJson.getString("picture");
                        Artist artist = new Artist(name, fanNumber, linkPic);
                        lsArtist.add(artist);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                CustomAdapterArtist adapter = new CustomAdapterArtist(requireContext(), R.layout.layout_items_artist, lsArtist);
                lvArtist.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getApplicationContext(), "Co loi", Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(request);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_soundify, container, false);


        lvArtist = view.findViewById(R.id.lvArtist);

        // Initialize your request queue


        // Rest of your code...

        return view;
    }
}