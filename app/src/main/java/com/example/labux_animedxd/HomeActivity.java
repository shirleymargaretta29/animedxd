package com.example.labux_animedxd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // 1. Inisialisasi semua komponen tampilan (Views)
        TextView welcomeMessage = findViewById(R.id.welcome_text);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager2 viewPager = findViewById(R.id.viewPager);

        // 2. Terima dan tampilkan username dari Intent
        Intent intent = getIntent();
        String username = intent.getStringExtra("USERNAME");
        if (username != null && !username.isEmpty()) {
            welcomeMessage.setText("Welcome, " + username);
        }

        // 3. Setup Adapter dan hubungkan ke ViewPager
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);

        // 4. Hubungkan TabLayout dengan ViewPager, sekaligus set nama Tab
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            if (position == 0) {
                tab.setText("News");
            } else {
                tab.setText("Manga");
            }
        }).attach();

        // 5. Setup Listener untuk efek BOLD pada tab yang aktif
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ViewGroup viewGroup = (ViewGroup) tab.view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View child = viewGroup.getChildAt(i);
                    if (child instanceof TextView) {
                        ((TextView) child).setTypeface(null, android.graphics.Typeface.BOLD);
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ViewGroup viewGroup = (ViewGroup) tab.view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View child = viewGroup.getChildAt(i);
                    if (child instanceof TextView) {
                        ((TextView) child).setTypeface(null, android.graphics.Typeface.NORMAL);
                    }
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                // Tidak perlu melakukan apa-apa
            }
        });

        // 6. Set tab pertama agar BOLD saat pertama kali dibuka
        tabLayout.post(() -> {
            ViewGroup viewGroup = (ViewGroup) tabLayout.getTabAt(0).view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View child = viewGroup.getChildAt(i);
                if (child instanceof TextView) {
                    ((TextView) child).setTypeface(null, android.graphics.Typeface.BOLD);
                }
            }
        });
    }
}