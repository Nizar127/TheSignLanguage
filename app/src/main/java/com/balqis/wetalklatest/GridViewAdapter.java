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

    //    Context context;
//    int layoutResourceId;
//    ArrayList<ImageItem> data = new ArrayList<ImageItem>();
//
//
//    public GridViewAdapter(@NonNull Context context, int layoutResourceId, ArrayList<ImageItem> data) {
//        super(context, layoutResourceId, data);
//        this.layoutResourceId = layoutResourceId;
//        this.context = context;
//        this.data = data;
//
//


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        if (v == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(custom_layout_id, null);

        }
            ImageView imageView = v.findViewById(R.id.imageFront);
            TextView textView = v.findViewById(R.id.textFront);

            //get the item position
            ImageItem item = item_list.get(position);

            imageView.setImageResource(item.getDataImage());
            textView.setText(item.getTitle());
            return v;
        }
}

//        View row = convertView;
//        ViewHolder holder = null;
//
//        if (row == null) {
//            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
//            row = inflater.inflate(layoutResourceId, parent, false);
//            holder = new ViewHolder();
//            holder.imageTitle = (TextView) row.findViewById(R.id.text);
//            holder.image = (ImageView) row.findViewById(R.id.image);
//            row.setTag(holder);
//        } else {
//            holder = (ViewHolder) row.getTag();
//        }
//
//        ImageItem item = data.get(position);
//        holder.imageTitle.setText(item.getTitle());
//        holder.image.setImageBitmap(item.getImage());
//        return row;


//        static class ViewHolder {
//            TextView imageTitle;
//            ImageView image;
//        }


