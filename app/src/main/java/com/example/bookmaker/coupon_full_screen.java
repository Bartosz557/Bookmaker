package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;
import android.R.anim;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class coupon_full_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        Log.d( "onCreate: ","created");
        setContentView(R.layout.activity_coupon_full_screen);
        setOdd();
        overridePendingTransition(R.anim.slide_up, android.R.anim.fade_out);
        ImageButton backButton = findViewById(R.id.backbutton);
        createCouponEvents createLayouts = new createCouponEvents();
        LinearLayout layout = findViewById(R.id.couponlayout);
        createLayouts.createLayout(layout,this);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed() {
        finish();
    }

    public void setOdd()
    {
        TextView oddText = findViewById(R.id.oddTV);
        oddText.setText(Double.toString(Coupon.setMultiplier()));
    }

    public void betClick(View view)
    {
        EditText priceStake = findViewById(R.id.stake);
        Coupon.createCoupon(priceStake);
    }

}