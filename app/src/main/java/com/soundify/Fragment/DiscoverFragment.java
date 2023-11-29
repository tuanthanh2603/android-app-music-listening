package com.soundify.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soundify.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DiscoverFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DiscoverFragment extends Fragment {

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



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        return view;
    }
//    private void initializeSearchView(){
//        View view = getView();
//        if(view != null){
//            EditText searchEdt = view.findViewById(R.id.idEdtSearch);
//            searchEdt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//                @Override
//                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//                    if(i == EditorInfo.IME_ACTION_DONE){
//                        searchTracks(searchEdt.getText().toString());
//                        return true;
//                    }
//                    return false;
//                }
//            });
//        }
//    }
//    private void searchTracks(String searchQuery){
//        Context context =  requireContext();
//        Intent i = new Intent(context, SearchActivity.class);
//        i.putExtra("searchQuery", searchQuery);
//        context.startActivity(i);
//    }
//    private String getToken(){
//        SharedPreferences sh = getContext().getSharedPreferences("MySharedPref", MODE_PRIVATE);
//        return sh.getString("token", "Not Found");
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        generateToken();
//    }
//    private void generateToken(){
//        String url = "https://accounts.spotify.com/api/token?grant_type=client_credentials";
//        RequestQueue queue = Volley.newRequestQueue(getContext());
//        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
//            @Override
//            public void onResponse(String response) {
//                try {
//                    JSONObject jsonObject = new JSONObject(response);
//                    String tk = jsonObject.getString("access_token");
//                    SharedPreferences sharedPreferences = getContext().getSharedPreferences("MySharedPref", MODE_PRIVATE);
//                    SharedPreferences.Editor myEdit = sharedPreferences.edit();
//                    myEdit.putString("token", "Bearer " + tk);
//                    myEdit.apply();
//                } catch (JSONException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(getContext(), "Fail to get response = " + error, Toast.LENGTH_SHORT).show();
//            }
//        }) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String, String> headers = new HashMap<>();
//                headers.put("Authorization", " Add your authorization here.");
//                headers.put("Content-Type", "application/x-www-form-urlencoded");
//                return headers;
//            }
//        };
//        queue.add(request);
//    }
//    private void initializeAlbumsRV(){
//        View view = getView();
//        if(view != null){
//            RecyclerView albumsRV = view.findViewById(R.id.idRVAlbums);
//
//            ArrayList<AlbumRV> albumRVArrayList = new ArrayList<>();
//            AlbumRVAdapter albumRVAdapter = new AlbumRVAdapter(albumRVArrayList, getContext());
//            albumsRV.setAdapter(albumRVAdapter);
//
//            String url = "https://api.spotify.com/v1/albums?ids=2oZSF17FtHQ9sYBscQXoBe%2C0z7bJ6UpjUw8U4TATtc5Ku%2C36UJ90D0e295TvlU109Xvy%2C3uuu6u13U0KeVQsZ3CZKK4%2C45ZIondgVoMB84MQQaUo9T%2C15CyNDuGY5fsG0Hn9rjnpG%2C1HeX4SmCFW4EPHQDvHgrVS%2C6mCDTT1XGTf48p6FkK9qFL";
//            RequestQueue queue = Volley.newRequestQueue(getContext());
//
//            JsonObjectRequest albumObjReq = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//                @Override
//                public void onResponse(JSONObject response) {
//                    try {
//                        JSONArray albumArray = response.getJSONArray("albums");
//                        for (int i = 0; i < albumArray.length(); i++) {
//                            JSONObject albumObj = albumArray.getJSONObject(i);
//                            String album_type = albumObj.getString("album_type");
//                            String artistName = albumObj.getJSONArray("artists").getJSONObject(0).getString("name");
//                            String external_ids = albumObj.getJSONObject("external_ids").getString("upc");
//                            String external_urls = albumObj.getJSONObject("external_urls").getString("spotify");
//                            String href = albumObj.getString("href");
//                            String id = albumObj.getString("id");
//                            String imgUrl = albumObj.getJSONArray("images").getJSONObject(1).getString("url");
//                            String label = albumObj.getString("label");
//                            String name = albumObj.getString("name");
//                            int popularity = albumObj.getInt("popularity");
//                            String release_date = albumObj.getString("release_date");
//                            int total_tracks = albumObj.getInt("total_tracks");
//                            String type = albumObj.getString("type");
//                            albumRVArrayList.add(new AlbumRV(album_type, artistName, external_ids, external_urls, href, id, imgUrl, label, name, popularity, release_date, total_tracks, type));
//                        }
//                        albumRVAdapter.notifyDataSetChanged();
//                    } catch (JSONException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//                    Toast.makeText(getContext(), "Fail to get data : " + error, Toast.LENGTH_SHORT).show();
//                }
//            });
//            queue.add(albumObjReq);
//
//        }
//
//    }
}