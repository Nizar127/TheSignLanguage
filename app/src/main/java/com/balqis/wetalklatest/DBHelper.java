package com.balqis.wetalklatest;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import static androidx.constraintlayout.motion.widget.MotionScene.TAG;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "WeTalk";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "UserData";



    public DBHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        //DB.execSQL("create Table UserData(id TEXT primary key, name TEXT,word TEXT)");
        String query;
        query = "CREATE TABLE " + TABLE_NAME + "(ID INTEGER PRIMARY KEY, name TEXT, word TEXT)";
        DB.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    /*    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop Table if exists UserData");
    }*/

    public void insertuserdata(String name, String word)
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("word", word);
        long ID=DB.insert(TABLE_NAME, null,contentValues);
        Log.d(TAG, "insertuserdata: "+ID);
        DB.close();

    }



    public void updateuserdata(String ID, String name, String word){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("word", word);
        //updating row
        sqLiteDatabase.update(TABLE_NAME, values, "ID=" +ID, null);
        sqLiteDatabase.close();


    }

    //DELETE
    public void deletedata(String ID){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //delete row
        sqLiteDatabase.delete(TABLE_NAME, "ID=" + ID, null);
        sqLiteDatabase.close();
    }


    public ArrayList<wordData> getData(){
        ArrayList<wordData> arrayList = new ArrayList<>();

        String select_query = "SELECT * FROM " + TABLE_NAME+";";
//
       SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(select_query,null);
//       // String test = db.query()
//
//        //loop
       if(cursor.moveToFirst()){
            do{
               wordData thedata = new wordData();
                thedata.setID(cursor.getString(0));
                thedata.setName(cursor.getString(1));
                thedata.setWord(cursor.getString(2));
                arrayList.add(thedata);
//                Log.d(TAG, "getData: "+getData());
            }while (cursor.moveToNext());
        }
       cursor.close();
        db.close();
        Log.d(TAG, "getData: "+arrayList.size());
        return arrayList;

    }

}
