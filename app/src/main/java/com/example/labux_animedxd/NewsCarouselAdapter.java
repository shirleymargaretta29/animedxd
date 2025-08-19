package com.example.labux_animedxd;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NewsCarouselAdapter extends RecyclerView.Adapter<NewsCarouselAdapter.ViewHolder> {

    private List<NewsArticle> newsArticleList;

    public NewsCarouselAdapter(List<NewsArticle> newsArticleList) {
        this.newsArticleList = newsArticleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsArticle article = newsArticleList.get(position);
        holder.newsImage.setImageResource(article.getImageResource());
        holder.newsLabel.setText(article.getLabelText());
        holder.newsTitle.setText(article.getTitle());

        holder.newsImage.setAlpha(0.7f);
        // --- KODE BARU UNTUK BACKGROUND LABEL ---
        // Membuat background melengkung secara programatik
        android.graphics.drawable.GradientDrawable labelBackground = new android.graphics.drawable.GradientDrawable();
        labelBackground.setShape(android.graphics.drawable.GradientDrawable.RECTANGLE);
        labelBackground.setCornerRadius(30f); // Tingkat kelengkungan

        // Mengatur warna berdasarkan teks label
        String label = article.getLabelText().toUpperCase();
        if (label.equals("NEWS")) {
            labelBackground.setColor(android.graphics.Color.parseColor("#2A4DC1"));
        } else if (label.equals("EVENT")) {
            labelBackground.setColor(android.graphics.Color.parseColor("#935BCA"));
        } else if (label.equals("UPDATE")) {
            labelBackground.setColor(android.graphics.Color.parseColor("#569BE2"));
        } else {
            // Warna default jika ada label lain
            labelBackground.setColor(android.graphics.Color.GRAY);
        }

        // Terapkan background yang sudah dibuat ke TextView
        holder.newsLabel.setBackground(labelBackground);
        // --- BATAS KODE ---
    }

    @Override
    public int getItemCount() {
        return newsArticleList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView newsImage;
        TextView newsLabel;
        TextView newsTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Cari View khusus untuk background
            View cardBackground = itemView.findViewById(R.id.card_background);

            // Buat dan terapkan background melengkung HANYA ke View tersebut
            android.graphics.drawable.GradientDrawable drawable = new android.graphics.drawable.GradientDrawable();
            drawable.setShape(android.graphics.drawable.GradientDrawable.RECTANGLE);
            drawable.setCornerRadius(40f);
            cardBackground.setBackground(drawable);

            // Penting: potong view utama agar mengikuti bentuk background
            ((ViewGroup) itemView).setClipToOutline(true);

            // Sisanya tetap sama
            newsImage = itemView.findViewById(R.id.news_image);
            newsLabel = itemView.findViewById(R.id.news_label);
            newsTitle = itemView.findViewById(R.id.news_title);
        }
    }
}