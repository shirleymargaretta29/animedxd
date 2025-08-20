package com.example.labux_animedxd;

public class MangaItem {

    private int coverImage;
    private String title;
    private String description;

    public MangaItem(int coverImage, String title, String description) {
        this.coverImage = coverImage;
        this.title = title;
        this.description = description;
    }

    public int getCoverImage() {
        return coverImage;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}