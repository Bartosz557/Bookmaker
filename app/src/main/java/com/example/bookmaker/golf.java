package com.example.bookmaker;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class golf extends setCouponClick {

    private static View couponBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golf);
        couponBox=findViewById(R.id.couponbox);
        coupon.setCouponBox(couponBox);
        overridePendingTransition(0, 0);
        getSupportActionBar().hide();
        LinearLayout layout = findViewById(R.id.golfparent);
        // only winners bets
    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}