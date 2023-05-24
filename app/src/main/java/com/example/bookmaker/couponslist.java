package com.example.bookmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class couponslist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0, 0);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_couponslist);
    }


    private void printCoupons()
    {
        SQLiteDatabase myDB = openOrCreateDatabase("my.db", Context.MODE_PRIVATE, null);
        readCoupons(myDB);

    }

    private void readCoupons(SQLiteDatabase database)
    {
        Cursor betCouponCursor = database.rawQuery("SELECT * FROM BetCoupons", null);
        while (betCouponCursor.moveToNext()) {
            int betIdIndex = betCouponCursor.getColumnIndex("bet_id");
            int betOddIndex = betCouponCursor.getColumnIndex("bet_odd");
            int betPriceIndex = betCouponCursor.getColumnIndex("bet_price");
            int potentialWinIndex = betCouponCursor.getColumnIndex("potential_win");
            int betDateIndex = betCouponCursor.getColumnIndex("bet_date");
            int couponStatusIndex = betCouponCursor.getColumnIndex("coupon_status");

            int betId = 0;
            float betOdd = 0;
            float betPrice = 0;
            String potentialWin = "";
            String betDate = "";
            String couponStatus = "";

            if (couponStatusIndex != -1) {
                couponStatus = betCouponCursor.getString(couponStatusIndex);
                // Process the retrieved coupon status value
            } else {
                // Handle the case when the column index is -1 (column not found)
            }

            if (betIdIndex != -1) {
                betId = betCouponCursor.getInt(betIdIndex);
                // Process the retrieved bet ID value
            } else {
                // Handle the case when the column index is -1 (column not found)
            }

            if (betOddIndex != -1) {
                betOdd = betCouponCursor.getFloat(betOddIndex);
                // Process the retrieved bet odd value
            } else {
                // Handle the case when the column index is -1 (column not found)
            }

            if (betPriceIndex != -1) {
                betPrice = betCouponCursor.getFloat(betPriceIndex);
                // Process the retrieved bet price value
            } else {
                // Handle the case when the column index is -1 (column not found)
            }

            if(couponStatus.equals("failed"))
                potentialWin="0";
            else if(couponStatus.equals("pending"))
                potentialWin="-";
            else if (potentialWinIndex != -1) {
                    potentialWin = Float.toString(betCouponCursor.getFloat(potentialWinIndex));
                    // Process the retrieved potential win value
                } else {
                    // Handle the case when the column index is -1 (column not found)
                }

            if (betDateIndex != -1) {
                betDate = betCouponCursor.getString(betDateIndex);
                // Process the retrieved bet date value
            } else {
                // Handle the case when the column index is -1 (column not found)
            }//getting values


        }
    }
}