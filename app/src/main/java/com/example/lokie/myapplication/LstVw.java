package com.example.lokie.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class LstVw extends AppCompatActivity {

    String lst;
    ListView lstvw;
    Daaata d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
            lstvw=findViewById(R.id.lstvw);


        ArrayList<String> listview = new ArrayList<String>();
        listview.add("Alpha");
        listview.add("Beta");
        listview.add("Cupcake");
        listview.add("Donut");
       listview.add(lst);
      // d.retrive();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(LstVw.this,R.layout.support_simple_spinner_dropdown_item,listview);
        lstvw.setAdapter(arrayAdapter);
        }
        catch(Exception e){
            Toast.makeText(this, "erro", Toast.LENGTH_SHORT).show();
        }



    }
}
