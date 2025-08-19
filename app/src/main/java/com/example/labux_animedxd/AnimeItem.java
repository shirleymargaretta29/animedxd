package com.example.labux_animedxd;

public class AnimeItem {
    private String title;
//    private String year;
    private String releaseDate;
    private String duration;
    private String genre;
    private String description;
    private double rating;
    private int imageResId;

    public AnimeItem(String title, String releaseDate, String duration, String genre, String description, double rating, int imageResId) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.genre = genre;
        this.description = description;
        this.rating = rating;
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    public double getRating() {
        return rating;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getDuration() {
        return duration;
    }
}
