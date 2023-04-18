package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class golf extends AppCompatActivity {

    private static View couponBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_golf);
        couponBox=findViewById(R.id.couponbox);
        Coupon.setCouponBox(couponBox);
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