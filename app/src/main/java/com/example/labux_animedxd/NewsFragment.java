package com.example.labux_animedxd;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    private Handler autoScrollHandler;
    private Runnable autoScrollRunnable;
    private RecyclerView newsRecyclerView;
    private View activeIndicator;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        activeIndicator = view.findViewById(R.id.indicator_active);
        newsRecyclerView = view.findViewById(R.id.news_carousel_recycler_view);

        List<NewsArticle> articleList = new ArrayList<>();
        articleList.add(new NewsArticle(R.drawable.news_solo_leveling, "NEWS", "Solo Leveling Officially Premieres"));
        articleList.add(new NewsArticle(R.drawable.news_anime_expo, "EVENT", "Anime Expo 2025 Announced"));
        articleList.add(new NewsArticle(R.drawable.news_one_piece, "UPDATE", "One Piece Hits Episode 1100"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        newsRecyclerView.setLayoutManager(layoutManager);
        NewsCarouselAdapter adapter = new NewsCarouselAdapter(articleList);
        newsRecyclerView.setAdapter(adapter);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(newsRecyclerView);

        // Listener untuk menggerakkan indikator
        newsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int scrollOffset = recyclerView.computeHorizontalScrollOffset();
                int scrollRange = recyclerView.computeHorizontalScrollRange() - recyclerView.getWidth();

                if (scrollRange > 0) {
                    ViewGroup indicatorContainer = view.findViewById(R.id.indicator_container);
                    float indicatorTravelRange = indicatorContainer.getWidth() - activeIndicator.getWidth();
                    float scrollPercentage = (float) scrollOffset / scrollRange;
                    activeIndicator.setTranslationX(indicatorTravelRange * scrollPercentage);
                }
            }
        });

        setupAutoScroll(layoutManager, adapter);
    }

    private void setupAutoScroll(LinearLayoutManager layoutManager, NewsCarouselAdapter adapter) {
        autoScrollHandler = new Handler(Looper.getMainLooper());
        autoScrollRunnable = () -> {
            if (newsRecyclerView != null) {
                int currentPosition = layoutManager.findFirstCompletelyVisibleItemPosition();
                if (currentPosition != RecyclerView.NO_POSITION) {
                    int nextPosition = (currentPosition + 1) % adapter.getItemCount();
                    newsRecyclerView.smoothScrollToPosition(nextPosition);
                }
            }
            autoScrollHandler.postDelayed(autoScrollRunnable, 3000);
        };
    }

    @Override
    public void onResume() {
        super.onResume();
        if (autoScrollHandler != null && autoScrollRunnable != null) {
            autoScrollHandler.postDelayed(autoScrollRunnable, 3000);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (autoScrollHandler != null) {
            autoScrollHandler.removeCallbacks(autoScrollRunnable);
        }
    }
}