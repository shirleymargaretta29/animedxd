package com.example.labux_animedxd;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeViewHolder> {

    private Context context;
    private List<AnimeItem> animeList;

    public AnimeAdapter(Context context, List<AnimeItem> animeList) {
        this.context = context;
        this.animeList = animeList;
    }

    @NonNull
    @Override
    public AnimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_anime, parent, false);
        return new AnimeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeViewHolder holder, int position) {
        AnimeItem anime = animeList.get(position);

        holder.tvTitle.setText(anime.getTitle());
        holder.tvYear.setText(anime.getReleaseDate().split(",")[1].trim());
        holder.tvGenre.setText(anime.getGenre());
        holder.tvGenre.setPaintFlags(holder.tvGenre.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        holder.tvDescription.setText(anime.getDescription());
        holder.tvRating.setText(String.format("%.1f/10", anime.getRating()));
        holder.imgCover.setImageResource(anime.getImageResId());

        holder.itemView.setOnClickListener(v -> openDetail(anime));
        holder.tvMoreInfo.setOnClickListener(v -> openDetail(anime));

        // Klik "More Info"
        holder.tvMoreInfo.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title", anime.getTitle());
            intent.putExtra("genre", anime.getGenre());
            intent.putExtra("releaseDate", anime.getReleaseDate());
            intent.putExtra("duration", anime.getDuration());
            intent.putExtra("description", anime.getDescription());
            intent.putExtra("rating", anime.getRating());
            intent.putExtra("imageResId", anime.getImageResId());
            context.startActivity(intent);
        });
    }

    private void openDetail(AnimeItem anime) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("title", anime.getTitle());
        intent.putExtra("releaseDate", anime.getReleaseDate());
        intent.putExtra("duration", anime.getDuration());
        intent.putExtra("genre", anime.getGenre());
        intent.putExtra("description", anime.getDescription());
        intent.putExtra("imageResId", anime.getImageResId());
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return animeList.size();
    }

    public static class AnimeViewHolder extends RecyclerView.ViewHolder {
        ImageView imgCover;
        TextView tvTitle, tvYear, tvGenre, tvDescription, tvRating, tvMoreInfo;

        public AnimeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCover = itemView.findViewById(R.id.imgCover);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvYear = itemView.findViewById(R.id.tvYear);
            tvGenre = itemView.findViewById(R.id.tvGenre);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvMoreInfo = itemView.findViewById(R.id.tvMoreInfo);
        }
    }
}
