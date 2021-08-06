package com.balqis.wetalklatest;

import android.graphics.Bitmap;

public class ImageItem {
    //Bitmap image;
    String title;
    int dataImage;

    public ImageItem(String title, int dataImage) {
        //this.image = image;
        this.title = title;
        this.dataImage = dataImage;
    }

    public int getDataImage() {
        return dataImage;
    }

    public void setDataImage(int dataImage) {
        this.dataImage = dataImage;
    }

/*    public Bitmap getImage() {
        return image;
    }*/

/*
    public void setImage(Bitmap image) {
        this.image = image;
    }
*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
