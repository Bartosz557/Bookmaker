package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class couponslist extends AppCompatActivity {

    static int currentBetId;
    float betOdd = 0;
    float betPrice = 0;
    String potentialWin = "";
    String betDate = "";
    String couponStatus = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_couponslist);
        readCoupons();
    }


    private void readCoupons()
    {
        SQLiteDatabase myDB = openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);
        Cursor betCouponCursor = myDB.rawQuery("SELECT * FROM BetCoupons", null);
        while (betCouponCursor.moveToNext()) {
            int betIdIndex = betCouponCursor.getColumnIndex("bet_id");
            int betOddIndex = betCouponCursor.getColumnIndex("bet_odd");
            int betPriceIndex = betCouponCursor.getColumnIndex("bet_price");
            int potentialWinIndex = betCouponCursor.getColumnIndex("potential_win");
            int betDateIndex = betCouponCursor.getColumnIndex("bet_date");
            int couponStatusIndex = betCouponCursor.getColumnIndex("coupon_status");
            int betId=0;
            if (betIdIndex != -1)
                betId = betCouponCursor.getInt(betIdIndex);
            if (betOddIndex != -1)
                betOdd = betCouponCursor.getFloat(betOddIndex);
            if (betPriceIndex != -1)
                betPrice = betCouponCursor.getFloat(betPriceIndex);
            if (betDateIndex != -1)
                betDate = betCouponCursor.getString(betDateIndex);
            if (couponStatusIndex != -1)
                couponStatus = betCouponCursor.getString(couponStatusIndex);

            if(couponStatus.equals("failed"))
                potentialWin="0";
            else if(couponStatus.equals("pending"))
                potentialWin="-";
            else if (potentialWinIndex != -1)
                    potentialWin = Float.toString(betCouponCursor.getFloat(potentialWinIndex));

            if (betDateIndex != -1) {
                betDate = betCouponCursor.getString(betDateIndex);
                // Process the retrieved bet date value
            } else {
                // Handle the case when the column index is -1 (column not found)
            }//getting values
            printCoupons(betId);
        }
    }

    private void printCoupons(int betId)
    {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.couponboxtemplate, null);
        TextView oddView = view.findViewById(R.id.textView14);
        TextView priceView = view.findViewById(R.id.textView15);
        TextView date = view.findViewById(R.id.data);
        TextView winPrice =  view.findViewById(R.id.textView16);
        ImageView statusView = view.findViewById(R.id.imageView);
        LinearLayout layout = findViewById(R.id.couponlayout);
//        int betId = 0;
//        float betOdd = 0;
//        float betPrice = 0;
//        String potentialWin = "";
//        String betDate = "";
//        String couponStatus = "";
        oddView.setText(Float.toString(betOdd));
        priceView.setText(Float.toString(betPrice));
        date.setText(betDate);
        winPrice.setText(potentialWin);
        //statusView.setText(couponstatus); set status image
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentBetId=betId;
                Log.d( "onClick: ",Integer.toString(currentBetId));
                createEventList();
            }
        });
        layout.addView(view);

    }
    public void createEventList()
    {
        Intent i = new Intent(this,eventlist.class);
        startActivity(i);
    }


}