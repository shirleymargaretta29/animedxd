package com.example.labux_animedxd;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Menentukan Fragment mana yang akan ditampilkan berdasarkan posisi tab
        if (position == 1) {
            return new MangaFragment();
        }
        // Jika bukan posisi 1 (maka posisi 0), tampilkan NewsFragment
        return new NewsFragment();
    }

    @Override
    public int getItemCount() {
        // Jumlah total tab yang kita miliki
        return 2;
    }
}