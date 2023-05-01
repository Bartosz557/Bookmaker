package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;
import android.R.anim;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class coupon_full_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        Log.d( "onCreate: ","created");
        setContentView(R.layout.activity_coupon_full_screen);
        setOdd();
        setTextEdit();
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

    public void setTextEdit()
    {
        EditText editText = findViewById(R.id.stake);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged (CharSequence s,int start, int count, int after){}
            @Override
            public void onTextChanged (CharSequence s,int start, int before, int count){}
            @Override
            public void afterTextChanged(Editable s) {
                setPotentialWin();
            }
        });
    }
    public void setOdd()
    {
        TextView oddText = findViewById(R.id.oddTV);
        oddText.setText(Double.toString(Math.round((Coupon.setMultiplier()) * 100.0) / 100.0));
    }

    public void setPotentialWin()
    {
        TextView winPriceText = findViewById(R.id.pWin);
        EditText priceStake = findViewById(R.id.stake);
        winPriceText.setText(Double.toString(Coupon.setWinPrice(priceStake)));
    }

    public void betClick(View view)
    {
        Coupon.createCoupon();
    }

}