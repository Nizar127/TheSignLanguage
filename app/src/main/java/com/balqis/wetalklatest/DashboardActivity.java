package com.balqis.wetalklatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DashboardActivity extends AppCompatActivity {

    GridView gridView;
    GridViewAdapter customGridAdapter;
    int choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        List<ImageItem> itemList = new ArrayList<>();
        itemList.add(new ImageItem("image_1", R.drawable.frame_001));
        itemList.add(new ImageItem("image_2", R.drawable.frame_002));
        itemList.add(new ImageItem("image_3", R.drawable.frame_003));
        itemList.add(new ImageItem("image_4", R.drawable.frame_004));
        itemList.add(new ImageItem("image_5", R.drawable.frame_005));
        itemList.add(new ImageItem("image_6", R.drawable.frame_006));
        itemList.add(new ImageItem("image_7", R.drawable.frame_007));
        itemList.add(new ImageItem("image_8", R.drawable.frame_008));
        itemList.add(new ImageItem("image_9", R.drawable.frame_009));
        itemList.add(new ImageItem("image_10", R.drawable.frame_010));
        itemList.add(new ImageItem("image_11", R.drawable.frame_011));
        itemList.add(new ImageItem("image_12", R.drawable.frame_012));
        itemList.add(new ImageItem("image_13", R.drawable.frame_013));
        itemList.add(new ImageItem("image_14", R.drawable.frame_014));
        itemList.add(new ImageItem("image_15", R.drawable.frame_015));
        itemList.add(new ImageItem("image_16", R.drawable.frame_016));
        itemList.add(new ImageItem("image_17", R.drawable.frame_017));
        itemList.add(new ImageItem("image_18", R.drawable.frame_018));
        itemList.add(new ImageItem("image_19", R.drawable.frame_019));
        itemList.add(new ImageItem("image_20", R.drawable.frame_020));

        gridView = (GridView) findViewById(R.id.gridView);

       /* Bundle thechoice = getIntent().getExtras();
        choice = thechoice.getInt("Userchoice");
        Log.d(TAG, "onCreate:"+ choice);*/
        customGridAdapter = new GridViewAdapter(this, R.layout.roaw_grid, itemList);
        gridView.setAdapter(customGridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(DashboardActivity.this, StartupActivity.class);
                intent.putExtra("Image Int", position);
                intent.putExtra("Choice", choice);
                startActivity(intent);
                finish();
            }
        });
    }

/*    private ArrayList<ImageItem> getData(int choice) {
        final ArrayList<ImageItem> imageItems = new ArrayList<ImageItem>();

        int[] arr_st = {R.array.image_ids,
                R.array.image_num,
                R.array.image_fuw};
        TypedArray imgs = getResources().obtainTypedArray(arr_st[choice - 1]);

        for (int i = 0; i < imgs.length(); i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),
                    imgs.getResourceId(i, -1));
            imageItems.add(new ImageItem(bitmap, " " + i + 1));
        }
        return imageItems;
    }*/
}