package com.example.bookmaker;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class setCouponClick extends AppCompatActivity {
    public void setOnlickCouponBox(View view)
    {
        Log.d( "setOnlickCouponBox: ","clicked");
        Intent i = new Intent(this, couponFullScreen.class);
        startActivity(i);
    }
}
