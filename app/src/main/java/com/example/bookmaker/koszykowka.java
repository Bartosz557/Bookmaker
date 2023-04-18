package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class koszykowka extends AppCompatActivity {

    private static View couponBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koszykowka);
        couponBox=findViewById(R.id.couponbox);
        Coupon.setCouponBox(couponBox);
        overridePendingTransition(0, 0);
        getSupportActionBar().hide();
        LinearLayout layout = findViewById(R.id.basketballparent);
        String[] sports = new String[]{"basketball_nba","basketball_wnba","basketball_euroleague","basketball_ncaab"};
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
