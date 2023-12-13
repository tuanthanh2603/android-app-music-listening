package com.soundify.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.soundify.R;

// Import statements...

public class DualImageFragment extends Fragment {

    private int[] imageResources; // Danh sách các tài nguyên hình ảnh
    private int position;

    public DualImageFragment() {
        // Required empty public constructor
    }

    public static DualImageFragment newInstance(int[] imageResources, int position) {
        DualImageFragment fragment = new DualImageFragment();
        Bundle args = new Bundle();
        args.putIntArray("imageResources", imageResources);
        args.putInt("position", position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imageResources = getArguments().getIntArray("imageResources");
            position = getArguments().getInt("position");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.item_dual_image, container, false);

        ImageView imageView1 = view.findViewById(R.id.imageView1);
        ImageView imageView2 = view.findViewById(R.id.imageView2);

        // Set images to the ImageViews based on the position and image resources
        imageView1.setImageResource(imageResources[position]);
        imageView2.setImageResource(imageResources[position + 1]);

        return view;
    }
}
