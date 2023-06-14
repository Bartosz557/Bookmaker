package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class mainActivity extends AppCompatActivity {
    public void zaloguj(View view){
        //Intent intencja = new Intent(this, loginactivity.class);
        Toast.makeText(this,"zalogowano",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,mainpage.class);
        startActivity(i);
//        EditText login = (EditText) findViewById(R.id.editTextTextEmailAddress);
//        EditText password = (EditText) findViewById(R.id.editTextTextEmailAddress);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(0, 0);
        getSupportActionBar().hide();
    }

}