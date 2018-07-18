package com.example.lokie.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class GrdVw extends AppCompatActivity {
android.widget.GridView grdvw;
String grd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        grdvw = findViewById(R.id.grdvw);
        grd=getIntent().getStringExtra("gridname");
        ArrayList<String> gridview = new ArrayList<String>();
        gridview.add("Alpha");
        gridview.add("Beta");
        gridview.add("Cupcake");
        gridview.add("Donut");
        gridview.add(grd);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(GrdVw.this,R.layout.support_simple_spinner_dropdown_item,gridview);
        grdvw.setAdapter(arrayAdapter);

    }
}
