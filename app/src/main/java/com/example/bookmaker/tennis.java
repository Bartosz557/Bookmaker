package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class tennis extends AppCompatActivity {

    private static View couponBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tennis);
        couponBox=findViewById(R.id.couponbox);
        Coupon.setCouponBox(couponBox);
        overridePendingTransition(0, 0);
        getSupportActionBar().hide();
    }
    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }
}