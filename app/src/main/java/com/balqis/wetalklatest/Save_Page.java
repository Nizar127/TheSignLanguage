package com.balqis.wetalklatest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Save_Page extends AppCompatActivity {

    ArrayList<wordData> arrayList;
    RecyclerView recyclerView;
    //viewSavedAdapter adapter;
    SavePageAdapter adapter;
    TextView noword;
    ImageView backBtn;
    DBHelper DB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_page);

        DB = new DBHelper(this);
        backBtn = findViewById(R.id.backBtnSize);
        noword = findViewById(R.id.SaveView);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TheMainActivity.class);
                startActivity(intent);
            }
        });
        recyclerView = findViewById(R.id.recyclerview);
        try{
            displayData();
            //Log.d(TAG, "display: "+displayData());
            noword.setVisibility(View.GONE);
        }catch (Exception e){
            noword.setVisibility(View.VISIBLE);
            Log.d(TAG, "onCreate: "+noword);
            Log.d(TAG, "onCreate: "+e);
            Toast.makeText(getApplicationContext(), "There is no data in here",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }


    }

    private void displayData() {
        arrayList = new ArrayList<>(DB.getData());
        Log.d(TAG, "displayData: "+arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.d(TAG, "recyclerview: "+recyclerView);
        //recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new SavePageAdapter(Save_Page.this,this,arrayList);
        //adapter = new viewSavedAdapter(getApplicationContext(), this, arrayList);
        Log.d(TAG, "displayDataLayout2: ");
        recyclerView.setAdapter(adapter);
    }
}
