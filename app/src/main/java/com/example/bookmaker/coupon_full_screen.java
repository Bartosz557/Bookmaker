package com.example.bookmaker;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.R.anim;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
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

import java.io.IOException;
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
        //usun komentarz przy finalV, overpendending nie dziala na dellu
        //overridePendingTransition(R.anim.slide_up, android.R.anim.fade_out);
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
        int result = Coupon.tryToBet();
        switch(result) {
            case 0: {
                SQLiteDatabase myDB = openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);
                Coupon.createCoupon(myDB);
                finish();
                break;
            }
            case 1:
                // noti - to small bet
                break;
            case 2:
                // noti - no bet
                break;
        }
    }

}