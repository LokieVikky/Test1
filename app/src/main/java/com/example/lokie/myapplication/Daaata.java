package com.example.lokie.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
int d;
public class Daaata extends SQLiteOpenHelper{
    SQLiteDatabase sqldata;
    public Daaata(Context context) {
        super(context, "List.db", null, 1);
        sqldata=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table dataa(names text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public long savemethod(String s1)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("names",s1);
        long s = sqldata.insert("dataa",null,contentValues);
        return s;
    }
    public ArrayList<String> retrive()
    {


        ArrayList<String> retri=new ArrayList<String>();
        //String s1[]=new String[1];
        Cursor cursr;
       // cursr=sqldata.query("dataa",null,null,new String[]{},null,null,null);
        cursr=sqldata.rawQuery("SELECT names FROM dataa",null);
        if(cursr.getColumnCount()<1)
        {
         // s1[0]="0";
            retri.add("not exist");
        }else{
           // ArrayList<String> ard = new ArrayList<String>();
          //  int i,j;
         //  j= cursr.getCount();
           cursr.moveToFirst();
           // for ( i = 0;i<=j;i++)
           // {
            do {
                retri.add(cursr.getString(cursr.getColumnIndex("names")));
                cursr.moveToNext();}
            while (cursr.moveToNext());
          //  }

        }
        return retri;
    }

}
