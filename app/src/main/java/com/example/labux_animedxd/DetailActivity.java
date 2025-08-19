package com.example.labux_animedxd;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageButton btnBack = findViewById(R.id.btnBack);
        ImageView imgCoverDetail = findViewById(R.id.imgCoverDetail);
        TextView tvTitleDetail = findViewById(R.id.tvTitleDetail);
        TextView tvReleaseDate = findViewById(R.id.tvReleaseDate);
        TextView tvGenreDetail = findViewById(R.id.tvGenreDetail);
        TextView tvDuration = findViewById(R.id.tvDuration);
        TextView tvDescriptionDetail = findViewById(R.id.tvDescriptionDetail);
        Button btnPostReview = findViewById(R.id.btnPostReview);

        // Ambil data dari Intent
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String releaseDate = intent.getStringExtra("releaseDate");
        String duration = intent.getStringExtra("duration");
        String genre = intent.getStringExtra("genre");
        int imageResId = intent.getIntExtra("imageResId", 0);
        String description = intent.getStringExtra("description");

        // Set data ke view
        tvTitleDetail.setText(title);
        tvReleaseDate.setText("Release Date : " + releaseDate);
        tvDuration.setText(duration);
        tvGenreDetail.setText(genre);
        tvGenreDetail.setPaintFlags(tvGenreDetail.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tvDescriptionDetail.setText(description);

        if (imageResId != 0) {
            imgCoverDetail.setImageResource(imageResId);
        }

        // Tombol Back
        btnBack.setOnClickListener(v -> finish());

        // Tombol Post Review
        // Tombol Post Review → tampilkan dialog
        btnPostReview.setOnClickListener(v -> showPostReviewDialog());
    }

    private void showPostReviewDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogView = inflater.inflate(R.layout.dialog_post_review, null);

        // Tambahkan margin ke dialog view
        int margin = (int) getResources().getDimension(R.dimen.dialog_margin);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        dialogView.setPadding(margin, margin, margin, margin);

        EditText etReview = dialogView.findViewById(R.id.etReview);
        TextView tvErrorMessage = dialogView.findViewById(R.id.tvErrorMessage);
        Button btnSubmitReview = dialogView.findViewById(R.id.btnSubmitReview);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(dialogView)
                .create();

        btnSubmitReview.setOnClickListener(v -> {
            String reviewText = etReview.getText().toString().trim();

            if (reviewText.isEmpty()) {
                tvErrorMessage.setVisibility(View.VISIBLE);
            } else {
                tvErrorMessage.setVisibility(View.GONE);
                Toast.makeText(this, "Review submitted: " + reviewText, Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        if (dialog.getWindow() != null) {
            dialog.getWindow().setLayout(
                    (int) (getResources().getDisplayMetrics().widthPixels * 0.9), // 90% lebar layar
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
        }

        dialog.show();
    }

}

