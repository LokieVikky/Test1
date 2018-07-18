package com.example.lokie.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

public class Duplicate extends AppCompatActivity {

    String s1,s2,s3,s4,s5,s6;
    EditText name,age,doj,timein;
    RadioGroup radio1;
    RadioButton male,female;
    CheckBox chk1,chk2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duplicate);
        s1=getIntent().getStringExtra("a");
        s2=getIntent().getStringExtra("b");
        s3=getIntent().getStringExtra("c");
        s4=getIntent().getStringExtra("d");
        s5=getIntent().getStringExtra("e");
        s6=getIntent().getStringExtra("f");

        name= findViewById(R.id.editText6);
        age= findViewById(R.id.editText3);
        doj= findViewById(R.id.editText8);
        timein= findViewById(R.id.editText9);
        radio1= findViewById(R.id.radiogrp);
        chk1=findViewById(R.id.checkBox2);
        chk2=findViewById(R.id.checkBox3);
        male=findViewById(R.id.radioButton4);
        female=findViewById(R.id.radioButton3);

        name.setText(s1);
        age.setText(s2);
        doj.setText(s3);
        timein.setText(s4);

       switch(s5){
           case "Male":
               radio1.check(R.id.radioButton4);
           case "Female":
               radio1.check(R.id.radioButton3);
       }
       switch (s6){
           case "true":
               chk1.setChecked(true);
           case "false":
               chk2.setChecked(false);
       }




    }
}
