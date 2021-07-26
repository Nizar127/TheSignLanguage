package com.balqis.wetalklatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    int choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button btnalpha = (Button) findViewById(R.id.alphabets);
        Button btnnum = (Button) findViewById(R.id.numbers);
        Button btnfuw = (Button) findViewById(R.id.fuw);
        ImageButton backbtn = (ImageButton) findViewById(R.id.backbutton_sign);
        ImageButton homebtn = (ImageButton) findViewById(R.id.homebutton_sign);
        btnalpha.setOnClickListener(this);
        btnnum.setOnClickListener(this);
        btnfuw.setOnClickListener(this);
        backbtn.setOnClickListener(this);
        homebtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(FirstActivity.this, SearchText.class);
        switch (v.getId())
        {
            case R.id.alphabets:
                intent.putExtra("Userchoice", 1);
                startActivity(intent);
                finish();
                break;

            case R.id.numbers:
                intent.putExtra("Userchoice", 2);
                startActivity(intent);
                finish();
                break;

            case R.id.fuw:
                intent.putExtra("Userchoice", 3);
                startActivity(intent);
                finish();
                break;

            case R.id.backbutton_sign:
                
                startActivity(new Intent(FirstActivity.this, StartupActivity.class));
                //intent.putExtra("Image Int", position);
                intent.putExtra("Choice", choice);
                finish();
                break;

            case R.id.homebutton_sign:
                startActivity(new Intent(FirstActivity.this, DashboardActivity.class));
                finish();
                break;
        }
    }
}