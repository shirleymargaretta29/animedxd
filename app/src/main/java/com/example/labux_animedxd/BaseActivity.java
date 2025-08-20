package com.example.labux_animedxd;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import com.example.labux_animedxd.HomeActivity;


public abstract class BaseActivity extends AppCompatActivity {

    protected void setupNavbar() {
        ImageButton navList = findViewById(R.id.navList);
        ImageButton navHome = findViewById(R.id.navHome);
        ImageButton navAbout = findViewById(R.id.navAbout);

        if (navList != null) {
            navList.setOnClickListener(v -> {
                if (!(this instanceof ListActivity)) {
                    startActivity(new Intent(this, ListActivity.class));
                }
            });
        }
        if (navHome != null) {
            navHome.setOnClickListener(v -> {
                if (!(this instanceof HomeActivity)) {
                        startActivity(new Intent(this, HomeActivity.class));
                }
            });
        }
        if (navAbout != null) {
            navAbout.setOnClickListener(v -> {
                if (!(this instanceof AboutUsActivity)) {
                    startActivity(new Intent(this, AboutUsActivity.class));
                }
            });
        }
    }
}
