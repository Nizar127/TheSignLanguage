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

public class AlphabetActivity extends AppCompatActivity {

    GridViewAdapter customGridAdapter;
    GridView gridViewAlphabet;
    int choiceAlphabet;
    ImageView homebtn, backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        backbtn = findViewById(R.id.backthisbtn);
        homebtn = findViewById(R.id.backtohome);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlphabetActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlphabetActivity.this, TheMainActivity.class);
                startActivity(intent);
            }
        });

        //aplphabet item
        List<ImageItem> itemList = new ArrayList<>();
        itemList.add(new ImageItem("A",R.drawable.frame_001));
        itemList.add(new ImageItem("B",R.drawable.frame_002));
        itemList.add(new ImageItem("C",R.drawable.frame_003));
        itemList.add(new ImageItem("D",R.drawable.frame_004));
        itemList.add(new ImageItem("E",R.drawable.frame_005));
        itemList.add(new ImageItem("F",R.drawable.frame_006));
        itemList.add(new ImageItem("G",R.drawable.frame_007));
        itemList.add(new ImageItem("H",R.drawable.frame_008));
        itemList.add(new ImageItem("I",R.drawable.frame_009));
        itemList.add(new ImageItem("J",R.drawable.frame_010));
        itemList.add(new ImageItem("K",R.drawable.frame_011));
        itemList.add(new ImageItem("L",R.drawable.frame_012));
        itemList.add(new ImageItem("M",R.drawable.frame_013));
        itemList.add(new ImageItem("N",R.drawable.frame_014));
        itemList.add(new ImageItem("O",R.drawable.frame_015));
        itemList.add(new ImageItem("P",R.drawable.frame_016));
        itemList.add(new ImageItem("Q",R.drawable.frame_017));
        itemList.add(new ImageItem("R",R.drawable.frame_018));
        itemList.add(new ImageItem("S",R.drawable.frame_019));
        itemList.add(new ImageItem("T",R.drawable.frame_020));
        itemList.add(new ImageItem("U",R.drawable.frame_021));
        itemList.add(new ImageItem("V",R.drawable.frame_022));
        itemList.add(new ImageItem("W",R.drawable.frame_023));
        itemList.add(new ImageItem("X",R.drawable.frame_024));
        itemList.add(new ImageItem("Y",R.drawable.frame_025));
        itemList.add(new ImageItem("Z",R.drawable.frame_026));



        gridViewAlphabet = findViewById(R.id.gridViewAlphabet);
        customGridAdapter = new GridViewAdapter(this,R.layout.roaw_grid,itemList);
        gridViewAlphabet.setAdapter(customGridAdapter);

/*        gridViewAlphabet.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(AlphabetActivity.this, StartupActivity.class);
                intent.putExtra("Image Int", position);
                intent.putExtra("Choice", choiceAlphabet);
                startActivity(intent);
                finish();
            }
        });*/

    }
}