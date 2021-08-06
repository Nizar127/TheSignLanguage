package com.balqis.wetalklatest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import pl.droidsonroids.gif.GifImageView;

import static android.content.ContentValues.TAG;

public class TheMainActivity extends AppCompatActivity {

    static final int REQUEST_CODE_SPEECH_INPUT = 1;
    EditText entertext;
    GifImageView imagev;
    Button searchbtn;
    ImageButton vsearchbtn, exitbtn, signbtn, saveBtn;
    DBHelper DB;
    int count =0;
    ArrayList<ImageItem> mWordItem;

    SpeechRecognizer sr;
    Bitmap bitmap;
    StringBuffer url;
    List<StringBuffer> mURLs = new LinkedList<StringBuffer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_main);

        searchbtn = findViewById(R.id.search_txt);
        saveBtn = findViewById(R.id.save_txt);
        vsearchbtn = (ImageButton) findViewById(R.id.VoiceConvert);
        signbtn = (ImageButton) findViewById(R.id.readBook);
        exitbtn = (ImageButton) findViewById(R.id.TouchToExit);
        entertext = (EditText) findViewById(R.id.entert);
        imagev = findViewById(R.id.imageView1);
        DB = new DBHelper(this);

        mWordItem = new ArrayList<>();


        imagev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchTxt();
            }
        });

        vsearchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speak to text");

                try{
                    startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
                    //startActivityForResult(intent, REQUEST_CODE);
                }catch (Exception e){

                }
            }
        });


        signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Moving to sign language dictionary!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(TheMainActivity.this, FirstActivity.class);
                startActivity(intent);
                finish();
            }
        });

        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitBtn();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog();

            }
        });
    }

    private void exitBtn() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Exit Application?");
        alertDialogBuilder
                .setMessage("Click yes to exit!")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void searchTxt() {
        //entertext.getText().toString();
        String data = entertext.getText().toString();
        Log.d(TAG, "searchTxt: "+data);
        filter(data);


    }

    private void filter(String data) {
        ArrayList<ImageItem> arrayList = new ArrayList<>();

        mWordItem.add(new ImageItem("1",R.drawable.frame_001));
        mWordItem.add(new ImageItem("2",R.drawable.frame_002));
        mWordItem.add(new ImageItem("3",R.drawable.frame_003));
        mWordItem.add(new ImageItem("4",R.drawable.frame_004));
        mWordItem.add(new ImageItem("5",R.drawable.frame_005));
        mWordItem.add(new ImageItem("6",R.drawable.frame_006));
        mWordItem.add(new ImageItem("7",R.drawable.frame_007));
        mWordItem.add(new ImageItem("8",R.drawable.frame_008));
        mWordItem.add(new ImageItem("9",R.drawable.frame_009));
        mWordItem.add(new ImageItem("10",R.drawable.frame_010));
        mWordItem.add(new ImageItem("11",R.drawable.frame_011));
        mWordItem.add(new ImageItem("12",R.drawable.frame_012));
        mWordItem.add(new ImageItem("13",R.drawable.frame_013));
        mWordItem.add(new ImageItem("14",R.drawable.frame_014));
        mWordItem.add(new ImageItem("15",R.drawable.frame_015));
        mWordItem.add(new ImageItem("16",R.drawable.frame_016));
        mWordItem.add(new ImageItem("17",R.drawable.frame_017));
        mWordItem.add(new ImageItem("18",R.drawable.frame_018));
        mWordItem.add(new ImageItem("19",R.drawable.frame_019));
        mWordItem.add(new ImageItem("20",R.drawable.frame_020));
        mWordItem.add(new ImageItem("21",R.drawable.frame_021));
        mWordItem.add(new ImageItem("22",R.drawable.frame_022));
        mWordItem.add(new ImageItem("23",R.drawable.frame_023));
        mWordItem.add(new ImageItem("24",R.drawable.frame_024));
        mWordItem.add(new ImageItem("25",R.drawable.frame_025));
        mWordItem.add(new ImageItem("26",R.drawable.frame_026));
        mWordItem.add(new ImageItem("27",R.drawable.frame_027));
        mWordItem.add(new ImageItem("28",R.drawable.frame_028));
        mWordItem.add(new ImageItem("29",R.drawable.frame_029));
        mWordItem.add(new ImageItem("30",R.drawable.frame_030));
        mWordItem.add(new ImageItem("31",R.drawable.frame_031));
        mWordItem.add(new ImageItem("32",R.drawable.frame_032));
        mWordItem.add(new ImageItem("33",R.drawable.frame_033));
        mWordItem.add(new ImageItem("34",R.drawable.frame_034));
        mWordItem.add(new ImageItem("35",R.drawable.frame_035));
        mWordItem.add(new ImageItem("36",R.drawable.frame_036));
        mWordItem.add(new ImageItem("37",R.drawable.frame_037));
        mWordItem.add(new ImageItem("38",R.drawable.frame_038));
        mWordItem.add(new ImageItem("39",R.drawable.frame_039));
        mWordItem.add(new ImageItem("40",R.drawable.frame_040));
        mWordItem.add(new ImageItem("41",R.drawable.frame_041));
        mWordItem.add(new ImageItem("42",R.drawable.frame_042));
        mWordItem.add(new ImageItem("43",R.drawable.frame_043));
        mWordItem.add(new ImageItem("44",R.drawable.frame_044));
        mWordItem.add(new ImageItem("45",R.drawable.frame_045));
        mWordItem.add(new ImageItem("46",R.drawable.frame_046));
        mWordItem.add(new ImageItem("A",R.drawable.frame_001));
        mWordItem.add(new ImageItem("B",R.drawable.frame_002));
        mWordItem.add(new ImageItem("C",R.drawable.frame_003));
        mWordItem.add(new ImageItem("D",R.drawable.frame_004));
        mWordItem.add(new ImageItem("E",R.drawable.frame_005));
        mWordItem.add(new ImageItem("F",R.drawable.frame_006));
        mWordItem.add(new ImageItem("G",R.drawable.frame_007));
        mWordItem.add(new ImageItem("H",R.drawable.frame_008));
        mWordItem.add(new ImageItem("I",R.drawable.frame_009));
        mWordItem.add(new ImageItem("J",R.drawable.frame_010));
        mWordItem.add(new ImageItem("K",R.drawable.frame_011));
        mWordItem.add(new ImageItem("L",R.drawable.frame_012));
        mWordItem.add(new ImageItem("M",R.drawable.frame_013));
        mWordItem.add(new ImageItem("N",R.drawable.frame_014));
        mWordItem.add(new ImageItem("O",R.drawable.frame_015));
        mWordItem.add(new ImageItem("P",R.drawable.frame_016));
        mWordItem.add(new ImageItem("Q",R.drawable.frame_017));
        mWordItem.add(new ImageItem("R",R.drawable.frame_018));
        mWordItem.add(new ImageItem("S",R.drawable.frame_019));
        mWordItem.add(new ImageItem("T",R.drawable.frame_020));
        mWordItem.add(new ImageItem("U",R.drawable.frame_021));
        mWordItem.add(new ImageItem("V",R.drawable.frame_022));
        mWordItem.add(new ImageItem("W",R.drawable.frame_023));
        mWordItem.add(new ImageItem("X",R.drawable.frame_024));
        mWordItem.add(new ImageItem("Y",R.drawable.frame_025));
        mWordItem.add(new ImageItem("Z",R.drawable.frame_026));
        mWordItem.add(new ImageItem("Rain",R.drawable.rain));
        mWordItem.add(new ImageItem("Forget",R.drawable.forget));
        mWordItem.add(new ImageItem("Hello",R.drawable.hello));
        mWordItem.add(new ImageItem("Love",R.drawable.love));
        mWordItem.add(new ImageItem("Baby",R.drawable.baby));
        mWordItem.add(new ImageItem("Drink",R.drawable.drink));
        mWordItem.add(new ImageItem("Thirsty",R.drawable.thirsty));
        mWordItem.add(new ImageItem("Talk",R.drawable.cakap));
        mWordItem.add(new ImageItem("Food",R.drawable.food));
        mWordItem.add(new ImageItem("Link",R.drawable.link));
        mWordItem.add(new ImageItem("Child",R.drawable.child));
        mWordItem.add(new ImageItem("Cigarette",R.drawable.cigarette));
        mWordItem.add(new ImageItem("How",R.drawable.frame_047));
        mWordItem.add(new ImageItem("When",R.drawable.frame_048));
        mWordItem.add(new ImageItem("Where",R.drawable.frame_049));
        mWordItem.add(new ImageItem("Which",R.drawable.frame_050));
        mWordItem.add(new ImageItem("Who",R.drawable.frame_051));
        mWordItem.add(new ImageItem("Why",R.drawable.frame_052));

        //match the string from the arraylist
        //get the title and set the data image into imageview
        for (ImageItem wordItem : mWordItem){
            if(wordItem.getTitle().toLowerCase().contains(data.toLowerCase())){
                arrayList.add(wordItem);
                Log.d(TAG, "filter: "+arrayList);
            }
        }

        imagev.setImageResource(arrayList.get(0).getDataImage());

    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Save Your Word Here");

        final View customLayout = getLayoutInflater().inflate(R.layout.save_layout,null);
        builder.setView(customLayout);
        builder.setPositiveButton("SAVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText name = customLayout.findViewById(R.id.nameEdit);
                EditText word = customLayout.findViewById(R.id.wordEditSave);

                String namaTxt = name.getText().toString();
                Log.d(TAG, "namaTxt: "+namaTxt);

                String wordTxt = word.getText().toString();
                Log.d(TAG, "wordtxt: "+wordTxt);

                if (TextUtils.isEmpty(namaTxt)){
                    Toast.makeText(TheMainActivity.this, "Please State Your Name",Toast.LENGTH_SHORT).show();

                } else if(TextUtils.isEmpty(wordTxt)){
                    Toast.makeText(TheMainActivity.this, "Please State Your Word To Be Saved",Toast.LENGTH_SHORT).show();

                }else {
                    //Boolean checkinsertdata = DB.insertuserdata(namaTxt, wordTxt);
                    Boolean checkinsertdata = true;
                    //String checkinsertdata = DB.insertuserdata(namaTxt,wordTxt);
                    Log.d(TAG, "SaveData: "+checkinsertdata);
                    if(checkinsertdata == true){
                        DB.insertuserdata(namaTxt,wordTxt);
                        Toast.makeText(TheMainActivity.this, "New Word Saved",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(TheMainActivity.this, "No Word Saved. Please Try Again",Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable  Intent data)
    {
            if (requestCode == REQUEST_CODE_SPEECH_INPUT && resultCode == RESULT_OK) {
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(
                            RecognizerIntent.EXTRA_RESULTS);
                    entertext.setText(Objects.requireNonNull(result).get(0));
                }
            }
        super.onActivityResult(requestCode, resultCode, data);
    }
}