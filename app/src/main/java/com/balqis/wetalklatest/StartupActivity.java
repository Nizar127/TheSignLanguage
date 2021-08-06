package com.balqis.wetalklatest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class StartupActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton finishbtn, previousbtn, homebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int choice;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        homebtn = findViewById(R.id.homebutton_sign);
        int position = getIntent().getExtras().getInt("Image Int");
        choice = getIntent().getExtras().getInt("Choice");
        ImageView imagev = (ImageView) findViewById(R.id.imagedisplay);

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartupActivity.this, TheMainActivity.class);
                startActivity(intent);
            }
        });
        finishbtn = (ImageButton) findViewById(R.id.Exit_button);
        previousbtn = (ImageButton) findViewById(R.id.Gobackbutton);

        finishbtn.setOnClickListener(this);
        previousbtn.setOnClickListener(this);

        /* Compute index based on choice(Alphabets/Numbers/Frequently Used words) */
        if (choice == 2)
            position = position + 26;
        else if (choice == 3)
            position = position + 46;

        /* Array which contains id for Alphabets, Numbers and Frequently Used words stored in drawable */
        int[] bLogos = {
                R.drawable.frame_001,
                R.drawable.frame_002,
                R.drawable.frame_003,
                R.drawable.frame_004,
                R.drawable.frame_005,
                R.drawable.frame_006,
                R.drawable.frame_007,
                R.drawable.frame_008,
                R.drawable.frame_009,
                R.drawable.frame_010,
                R.drawable.frame_011,
                R.drawable.frame_012,
                R.drawable.frame_013,
                R.drawable.frame_014,
                R.drawable.frame_015,
                R.drawable.frame_016,
                R.drawable.frame_017,
                R.drawable.frame_018,
                R.drawable.frame_019,
                R.drawable.frame_020,

        };
        int cImage = bLogos[position];
        imagev.setImageResource(cImage);

        imagev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartupActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v.getId() == R.id.Gobackbutton) {
            Intent intent = new Intent(StartupActivity.this, DashboardActivity.class);
            startActivity(intent);
            finish();
        }

        if (v.getId() == R.id.Exit_button) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle(R.string.exit_application);
            alertDialogBuilder
                    .setMessage("Click yes to exit!")
                    .setCancelable(false)
                    .setPositiveButton(R.string.yes,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    moveTaskToBack(true);
                                    Process.killProcess(Process.myPid());
                                    System.exit(1);
                                }
                            })
                    .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                            dialog.cancel();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }
    }

}