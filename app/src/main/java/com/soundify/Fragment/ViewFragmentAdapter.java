package com.soundify.Fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewFragmentAdapter extends FragmentStateAdapter {
    public ViewFragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new LibraryFragment();
            case 1:
                return new DiscoverFragment();
            case 2:
                return new SoundifyFragment();
            case 3:
                return new RadioFragment();
            case 4:
                return new UserFragment();
        }

        return null;
    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
