package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class golf extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golf);
        overridePendingTransition(0, 0);
        getSupportActionBar().hide();
    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}