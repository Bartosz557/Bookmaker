package com.example.bookmaker;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class baseball extends setCouponClick {
    private static View couponBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseball);
        couponBox=findViewById(R.id.couponbox);
        coupon.setCouponBox(couponBox);
        overridePendingTransition(0, 0);
        getSupportActionBar().hide();
        LinearLayout layout = findViewById(R.id.baseballparent);
        String[] sports = new String[]{"baseball_mlb","baseball_mlb_preseason"};
        boolean createHeader=false;
        boolean lastarray = false;
        if(sports.length>1)
            createHeader=true;
        for(int i=0;i<sports.length;i++) {
            if(i==sports.length-1)
                lastarray=true;
            getOdds getOdds = new getOdds(this,layout,sports[i],createHeader,lastarray,couponBox);
            getOdds.execute();
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}