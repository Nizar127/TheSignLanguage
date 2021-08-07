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

public class NumberActivity extends AppCompatActivity {

    GridViewAdapter customGridAdapter;
    GridView gridViewNumber;
    int choiceNumber;
    ImageView backbtn, homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        backbtn = findViewById(R.id.backthisbtn2);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(NumberActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        homebtn = findViewById(R.id.backtohomenumber);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NumberActivity.this, TheMainActivity.class);
                startActivity(intent);
            }
        });
        List<ImageItem> itemList = new ArrayList<>();
        itemList.add(new ImageItem("1",R.drawable.frame_001));
        itemList.add(new ImageItem("2",R.drawable.frame_002));
        itemList.add(new ImageItem("3",R.drawable.frame_003));
        itemList.add(new ImageItem("4",R.drawable.frame_004));
        itemList.add(new ImageItem("5",R.drawable.frame_005));
        itemList.add(new ImageItem("6",R.drawable.frame_006));
        itemList.add(new ImageItem("7",R.drawable.frame_007));
        itemList.add(new ImageItem("8",R.drawable.frame_008));
        itemList.add(new ImageItem("9",R.drawable.frame_009));
        itemList.add(new ImageItem("10",R.drawable.frame_010));
        itemList.add(new ImageItem("11",R.drawable.frame_011));
        itemList.add(new ImageItem("12",R.drawable.frame_012));
        itemList.add(new ImageItem("13",R.drawable.frame_013));
        itemList.add(new ImageItem("14",R.drawable.frame_014));
        itemList.add(new ImageItem("15",R.drawable.frame_015));
        itemList.add(new ImageItem("16",R.drawable.frame_016));
        itemList.add(new ImageItem("17",R.drawable.frame_017));
        itemList.add(new ImageItem("18",R.drawable.frame_018));
        itemList.add(new ImageItem("19",R.drawable.frame_019));
        itemList.add(new ImageItem("20",R.drawable.frame_020));
        itemList.add(new ImageItem("21",R.drawable.frame_021));
        itemList.add(new ImageItem("22",R.drawable.frame_022));
        itemList.add(new ImageItem("23",R.drawable.frame_023));
        itemList.add(new ImageItem("24",R.drawable.frame_024));
        itemList.add(new ImageItem("25",R.drawable.frame_025));
        itemList.add(new ImageItem("26",R.drawable.frame_026));
        itemList.add(new ImageItem("27",R.drawable.frame_027));
        itemList.add(new ImageItem("28",R.drawable.frame_028));
        itemList.add(new ImageItem("29",R.drawable.frame_029));
        itemList.add(new ImageItem("30",R.drawable.frame_030));
        itemList.add(new ImageItem("31",R.drawable.frame_031));
        itemList.add(new ImageItem("32",R.drawable.frame_032));
        itemList.add(new ImageItem("33",R.drawable.frame_033));
        itemList.add(new ImageItem("34",R.drawable.frame_034));
        itemList.add(new ImageItem("35",R.drawable.frame_035));
        itemList.add(new ImageItem("36",R.drawable.frame_036));
        itemList.add(new ImageItem("37",R.drawable.frame_037));
        itemList.add(new ImageItem("38",R.drawable.frame_038));
        itemList.add(new ImageItem("39",R.drawable.frame_039));
        itemList.add(new ImageItem("40",R.drawable.frame_040));
        itemList.add(new ImageItem("41",R.drawable.frame_041));
        itemList.add(new ImageItem("42",R.drawable.frame_042));
        itemList.add(new ImageItem("43",R.drawable.frame_043));
        itemList.add(new ImageItem("44",R.drawable.frame_044));
        itemList.add(new ImageItem("45",R.drawable.frame_045));
        itemList.add(new ImageItem("46",R.drawable.frame_046));




        gridViewNumber = findViewById(R.id.gridViewnumber);
        customGridAdapter = new GridViewAdapter(this,R.layout.roaw_grid,itemList);
        gridViewNumber.setAdapter(customGridAdapter);

/*        gridViewNumber.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NumberActivity.this, StartupActivity.class);
                intent.putExtra("Image Int", position);
                intent.putExtra("Choice", choiceNumber);
                startActivity(intent);
                finish();
            }
        });*/
    }
}