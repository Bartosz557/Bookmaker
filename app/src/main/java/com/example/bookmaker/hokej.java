package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

public class hokej extends AppCompatActivity {

    private static View couponBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hokej);
        couponBox=findViewById(R.id.couponbox);
        Coupon.setCouponBox(couponBox);
        overridePendingTransition(0, 0);
        getSupportActionBar().hide();
        LinearLayout layout = findViewById(R.id.hockeyparent);
        String[] sports = new String[]{"icehockey_nhl","icehockey_sweden_hockey_league","icehockey_sweden_allsvenskan"};
        boolean createHeader=false;
        boolean lastarray = false;
        if(sports.length>1)
            createHeader=true;
        for(int i=0;i<sports.length;i++) {
            if(i==sports.length-1)
                lastarray=true;
            GetOdds getOdds = new GetOdds(this,layout,sports[i],createHeader,lastarray,couponBox);
            getOdds.execute();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}