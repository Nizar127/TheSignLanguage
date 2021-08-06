package com.balqis.wetalklatest;

import android.graphics.drawable.Drawable;

public class OnBoardingItem {

    String title;
    String description;
    int image;

    public OnBoardingItem() {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
