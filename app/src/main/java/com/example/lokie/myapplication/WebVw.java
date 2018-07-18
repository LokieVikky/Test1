package com.example.lokie.myapplication;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class WebVw extends AppCompatActivity {
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        web= findViewById(R.id.webvw);
        ActivityCompat.requestPermissions(WebVw.this, new String[]{Manifest.permission.INTERNET}, 1);
        web.loadUrl("http://www.androidmanifester.com/");


    }
}
