package com.example.labux_animedxd;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends BaseActivity  {

    private RecyclerView recyclerView;
    private AnimeAdapter adapter;
    private List<AnimeItem> animeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setupNavbar();

        // 1. Temukan RecyclerView
        recyclerView = findViewById(R.id.recyclerViewAnime);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 2. Isi data anime (Dummy)
        animeList = new ArrayList<>();
        animeList.add(new AnimeItem(
                "My Neighbor Totoro",
                "April 16, 1988",
                "1 hour 26 minutes",
                "Fantasy",
                "Sisters Satsuki and Mei move to the countryside to be near their hospitalized mother. In their new home, they discover magical creatures, including Totoro, a friendly giant forest spirit.",
                8.1,
                R.drawable.my_neighbor_totoro
        ));

        animeList.add(new AnimeItem(
                "Ocean Waves",
                "May 5, 1993",
                "1 hour 12 minutes",
                "Romance",
                "Taku Morisaki, a university student, reminisces about his high school days in Kochi when a transfer student from Tokyo named Rikako arrives, changing the dynamics of his friendships and feelings.",
                6.6,
                R.drawable.ocean_waves
        ));

        animeList.add(new AnimeItem(
                "Howl's Moving Castle",
                "November 20, 2004",
                "1 hour 59 minutes",
                "Comedy",
                "Sophie, a young hat maker, is cursed into an old woman by a wicked witch. To break the curse, she enters a magical world filled with wonder and danger.",
                8.2,
                R.drawable.howls_moving_castle
        ));

        animeList.add(new AnimeItem(
                "Mary and the Witch's Flower",
                "July 8, 2017",
                "1 hour 42 minutes",
                "Fantasy",
                "Mary discovers a mysterious flower that grants magical powers for one night.",
                6.7,
                R.drawable.mary_and_the_witchs_flower
        ));

        animeList.add(new AnimeItem(
                "Pom Poko",
                "July 16, 1994",
                "1 hour 59 minutes",
                "Comedy",
                "The raccoons of the Tama Hills face the threat of their forest being destroyed by Tokyo's urban development. Using their magical ability to shapeshift, they try to defend their habitat from humans.",
                7.3,
                R.drawable.pompoko
        ));

        // 3. Set adapter
        adapter = new AnimeAdapter(this, animeList);
        recyclerView.setAdapter(adapter);

        ImageButton btnMenu = findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(v -> {
            View popupView = getLayoutInflater().inflate(R.layout.popup_menu_custom, null);

            PopupWindow popupWindow = new PopupWindow(popupView,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    true);

            popupWindow.setOutsideTouchable(true);
            popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            // Event klik logout
            TextView tvLogout = popupView.findViewById(R.id.tvLogout);
            tvLogout.setOnClickListener(view -> {
                Intent intent = new Intent(ListActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                popupWindow.dismiss();
            });

            popupWindow.showAsDropDown(v, 0, 0);
        });


        // 5. Bottom Navigation
        ImageButton navList = findViewById(R.id.navList);
        ImageButton navHome = findViewById(R.id.navHome);
        ImageButton navAbout = findViewById(R.id.navAbout);

        navHome.setOnClickListener(v -> {
            Intent intent = new Intent(ListActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        navAbout.setOnClickListener(v -> {
            Intent intent = new Intent(ListActivity.this, AboutUsActivity.class);
            startActivity(intent);
        });
    }
}
