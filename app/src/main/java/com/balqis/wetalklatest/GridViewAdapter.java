package com.balqis.wetalklatest;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import pl.droidsonroids.gif.GifImageView;

public class GridViewAdapter extends ArrayAdapter<ImageItem> {

    List<ImageItem> item_list = new ArrayList<>();
    int custom_layout_id;

    public GridViewAdapter(Context context, int resource, List<ImageItem> objects) {
        super(context, resource, objects);
        item_list = objects;
        custom_layout_id = resource;
    }

    @Override
    public int getCount() {
        return item_list.size();
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(custom_layout_id, null);

        }
            //ImageView imageView = v.findViewById(R.id.imageFront);
            GifImageView imageView = v.findViewById(R.id.imageFront);
            TextView textView = v.findViewById(R.id.textFront);

            //get the item position
            ImageItem item = item_list.get(position);

            imageView.setImageResource(item.getDataImage());
            textView.setText(item.getTitle());
            return v;
        }
}

