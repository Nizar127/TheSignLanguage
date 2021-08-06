package com.balqis.wetalklatest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    int choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        Button btnalpha = (Button) findViewById(R.id.alphabets);
        Button btnnum = (Button) findViewById(R.id.numbers);
        Button btnfuw = (Button) findViewById(R.id.fuw);
        Button btnView = findViewById(R.id.viewSave);
        ImageButton backbtn = (ImageButton) findViewById(R.id.backbutton_sign);
        ImageButton homebtn = (ImageButton) findViewById(R.id.homebutton_sign);
        btnalpha.setOnClickListener(this);
        btnnum.setOnClickListener(this);
        btnfuw.setOnClickListener(this);
        btnView.setOnClickListener(this);

/*
        btnnum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),NumberActivity.class);
                intent.putExtra("Userchoice", 2);
                startActivity(intent);
                finish();
            }
        });
*/

        backbtn.setOnClickListener(this);
        homebtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(FirstActivity.this, AlphabetActivity.class);
        switch (v.getId())
        {
            case R.id.alphabets:
                intent.putExtra("Userchoice", 1);
                startActivity(intent);
                finish();
                break;

            case R.id.numbers:
                startActivity(new Intent(FirstActivity.this, NumberActivity.class));
                intent.putExtra("Userchoice", 2);
                //startActivity(intent);
                finish();
                break;

            case R.id.fuw:
                startActivity(new Intent(FirstActivity.this, FeaturePageActivity.class));
                intent.putExtra("Userchoice", 3);
                //startActivity(intent);
                finish();
                break;

            case R.id.viewSave:
                startActivity(new Intent(FirstActivity.this, Save_Page.class));
                intent.putExtra("Userchoice",4);
                finish();
                break;

            case R.id.backbutton_sign:
                Toast.makeText(getApplicationContext(), "You Have to Press Back Button on Your Devices To Return to Dashboard", Toast.LENGTH_LONG).show();
                //startActivity(new Intent(FirstActivity.this, StartupActivity.class));

                //intent.putExtra("Image Int", position);
                //intent.putExtra("Choice", choice);
                //finish();
                break;

            case R.id.homebutton_sign:
                startActivity(new Intent(FirstActivity.this, TheMainActivity.class));
                finish();
                break;
        }
    }

}