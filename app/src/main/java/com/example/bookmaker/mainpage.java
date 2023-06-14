package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mainpage extends AppCompatActivity {

    static View couponBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        couponBox=findViewById(R.id.couponbox);
        coupon.setCouponBox(couponBox);
        overridePendingTransition(0, 0);
        getSupportActionBar().hide();
    }

    @Override
    protected void onResume() {
        super.onResume();
        coupon.setCouponBox(couponBox);
    }

    //buttons
    public void couponList(View view)
    {
        Intent i = new Intent(this,couponslist.class);
        startActivity(i);
    }

    public void football(View view)
    {
        Intent i = new Intent(this,football.class);
        startActivity(i);
    }
    public void tennis(View view)
    {
        Intent i = new Intent(this,tennis.class);
        startActivity(i);
    }
    public void koszykowka(View view)
    {
        Intent i = new Intent(this, basketball.class);
        startActivity(i);
    }
    public void mma(View view)
    {
        Intent i = new Intent(this,mma.class);
        startActivity(i);
    }
    public void golf(View view)
    {
        Intent i = new Intent(this,golf.class);
        startActivity(i);
    }
    public void hokej(View view)
    {
        Intent i = new Intent(this, hockey.class);
        startActivity(i);
    }
    public void footballus(View view)
    {
        Intent i = new Intent(this,footballUS.class);
        startActivity(i);
    }
    public void footballaus(View view)
    {
        Intent i = new Intent(this,footballAUS.class);
        startActivity(i);
    }
    public void rugby(View view)
    {
        Intent i = new Intent(this,rugby.class);
        startActivity(i);
    }
    public void baseball(View view)
    {
        Intent i = new Intent(this,baseball.class);
        startActivity(i);
    }
    public void krykiet(View view)
    {
        Intent i = new Intent(this, cricket.class);
        startActivity(i);
    }
    public void polityka(View view)
    {
        Intent i = new Intent(this, politics.class);
        startActivity(i);
    }

}