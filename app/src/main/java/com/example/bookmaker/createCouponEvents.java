package com.example.bookmaker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class createCouponEvents extends AppCompatActivity {

    public void createLayout(LinearLayout layout, Context context)
    {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.coupon_template, null);

        TextView odd = view.findViewById(R.id.addOdd);
        TextView winner = view.findViewById(R.id.addWinner);
        TextView betName = view.findViewById(R.id.addBetName);

        odd.setText("Hello world!");
        winner.setText("winner 1");
        betName.setText("name 2");

        layout.addView(view);
    }
}
