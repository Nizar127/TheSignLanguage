package com.balqis.wetalklatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class FeaturePageActivity extends AppCompatActivity {

    GridViewAdapter customGridAdapter;
    GridView gridViewFeature;
    int choiceFeature;
    ImageView homebtn, backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature_page);

        backbtn = findViewById(R.id.backthisfeature);
        homebtn = findViewById(R.id.backtohome);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FeaturePageActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FeaturePageActivity.this, TheMainActivity.class);
                startActivity(intent);
            }
        });

        //aplphabet item
        List<ImageItem> itemList = new ArrayList<>();
        itemList.add(new ImageItem("Rain",R.drawable.rain));
        itemList.add(new ImageItem("Forget",R.drawable.forget));
        itemList.add(new ImageItem("Hello",R.drawable.hello));
        itemList.add(new ImageItem("Love",R.drawable.love));
        itemList.add(new ImageItem("Baby",R.drawable.baby));
        itemList.add(new ImageItem("Drink",R.drawable.drink));
        itemList.add(new ImageItem("Thirsty",R.drawable.thirsty));
        itemList.add(new ImageItem("Talk",R.drawable.cakap));
        itemList.add(new ImageItem("Food",R.drawable.food));
        itemList.add(new ImageItem("Link",R.drawable.link));
        itemList.add(new ImageItem("Child",R.drawable.child));
        itemList.add(new ImageItem("Cigarette",R.drawable.cigarette));
        itemList.add(new ImageItem("How",R.drawable.frame_047));
        itemList.add(new ImageItem("When",R.drawable.frame_048));
        itemList.add(new ImageItem("Where",R.drawable.frame_049));
        itemList.add(new ImageItem("Which",R.drawable.frame_050));
        itemList.add(new ImageItem("Who",R.drawable.frame_051));
        itemList.add(new ImageItem("Why",R.drawable.frame_052));


        gridViewFeature = findViewById(R.id.gridViewFeature);
        customGridAdapter = new GridViewAdapter(this,R.layout.roaw_grid,itemList);
        gridViewFeature.setAdapter(customGridAdapter);

/*        gridViewFeature.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FeaturePageActivity.this, StartupActivity.class);
                intent.putExtra("Image Int", position);
                intent.putExtra("Choice", choiceFeature);
                startActivity(intent);
                finish();
            }
        });*/


    }
}