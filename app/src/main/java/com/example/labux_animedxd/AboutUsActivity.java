package com.example.labux_animedxd;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class AboutUsActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private LinearLayout dotsLayout;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        viewPager = findViewById(R.id.viewPager);
        dotsLayout = findViewById(R.id.dotsLayout);

        List<AboutUsItem> items = new ArrayList<>();
        items.add(new AboutUsItem(R.drawable.logo, getString(R.string.title_1), getString(R.string.desc_1)));
        items.add(new AboutUsItem(R.drawable.lock, getString(R.string.title_2), getString(R.string.desc_2)));
        items.add(new AboutUsItem(R.drawable.news, getString(R.string.title_3), getString(R.string.desc_3)));
        items.add(new AboutUsItem(R.drawable.book, getString(R.string.title_4), getString(R.string.desc_4)));
        items.add(new AboutUsItem(R.drawable.board, getString(R.string.title_5), getString(R.string.desc_5)));
        items.add(new AboutUsItem(R.drawable.review, getString(R.string.title_6), getString(R.string.desc_6)));
        items.add(new AboutUsItem(R.drawable.star, getString(R.string.title_7), getString(R.string.desc_7)));

        viewPager.setAdapter(new AboutUsAdapter(items));
        setupDots(items.size());
        selectDot(0);

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                selectDot(position);
            }
        });
    }

    private void setupDots(int count) {
        dots = new ImageView[count];
        dotsLayout.removeAllViews();

        for (int i = 0; i < count; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageResource(R.drawable.dot_inactive);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(20, 20);
            params.setMargins(8, 0, 8, 0);
            dots[i].setLayoutParams(params);
            dotsLayout.addView(dots[i]);
        }
    }

    private void selectDot(int index) {
        for (int i = 0; i < dots.length; i++) {
            if (i == index) {
                dots[i].setImageResource(R.drawable.dot_active);
            } else {
                dots[i].setImageResource(R.drawable.dot_inactive);
            }
        }
    }
}
