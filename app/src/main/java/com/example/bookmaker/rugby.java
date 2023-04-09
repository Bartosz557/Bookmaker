package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

public class rugby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rugby);
        overridePendingTransition(0, 0);
        getSupportActionBar().hide();
        LinearLayout layout = findViewById(R.id.rugbyparent);
        String[] sports = new String[]{"rugbyleague_nrl"};
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