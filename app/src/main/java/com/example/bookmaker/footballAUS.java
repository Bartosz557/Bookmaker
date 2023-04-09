package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class footballAUS extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_aus);
        overridePendingTransition(0, 0);
        getSupportActionBar().hide();
        LinearLayout layout = findViewById(R.id.ausfootballparent);
        String[] sports = new String[]{"aussierules_afl"};
        boolean createHeader=false;
        boolean lastarray = false;
        if(sports.length>1)
            createHeader=true;
        for(int i=0;i<sports.length;i++) {
            if(i==sports.length-1)
                lastarray=true;
            GetOdds getOdds = new GetOdds(this,layout,sports[i],createHeader,lastarray);
            getOdds.execute();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}