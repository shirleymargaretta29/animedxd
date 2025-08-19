package com.example.labux_animedxd;

public class NewsArticle {

    private int imageResource;
    private String labelText;
    private String title;

    public NewsArticle(int imageResource, String labelText, String title) {
        this.imageResource = imageResource;
        this.labelText = labelText;
        this.title = title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getLabelText() {
        return labelText;
    }

    public String getTitle() {
        return title;
    }
}