package com.example.labux_animedxd;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MangaFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_manga, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // 1. Siapkan data dummy
        List<MangaItem> mangaList = new ArrayList<>();
        // Pastikan Anda sudah menambahkan gambar-gambar ini ke folder drawable
        mangaList.add(new MangaItem(R.drawable.manga_one_piece, "One Piece", "A legendary tale of pirates in search of the ultimate treasure."));
        mangaList.add(new MangaItem(R.drawable.manga_naruto, "Naruto", "A story of a mischievous ninja who dreams big."));
        mangaList.add(new MangaItem(R.drawable.manga_attack_on_titan, "Attack on Titan", "Humanity fights for survival behind massive walls."));
        mangaList.add(new MangaItem(R.drawable.manga_jujutsu_kaisen, "Jujutsu Kaisen", "Curses roam the world unseen by ordinary people."));
        mangaList.add(new MangaItem(R.drawable.manga_my_hero_academia, "My Hero Academia", "A world where having superpowers, or “quirks,” is the norm."));
        mangaList.add(new MangaItem(R.drawable.manga_demon_slayer, "Demon Slayer", "A demon attack changes Tanjiro's peaceful life forever."));
        mangaList.add(new MangaItem(R.drawable.manga_tokyo_revengers, "Tokyo Revengers", "Time travel and gang wars collide in this emotional thriller."));
        mangaList.add(new MangaItem(R.drawable.manga_spy_x_family, "Spy x Family", "A fake family, real secrets, and unexpected warmth."));
        mangaList.add(new MangaItem(R.drawable.manga_chainsaw_man, "Chainsaw Man", "Denji hunts devils to survive—but becomes one himself."));
        mangaList.add(new MangaItem(R.drawable.manga_blue_lock, "Blue Lock", "What if soccer was a battle for the ego?"));

        // 2. Setup RecyclerView
        RecyclerView mangaRecyclerView = view.findViewById(R.id.manga_recycler_view);
        mangaRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // 3. Buat dan pasang adapter
        MangaAdapter adapter = new MangaAdapter(mangaList);
        mangaRecyclerView.setAdapter(adapter);
    }
}