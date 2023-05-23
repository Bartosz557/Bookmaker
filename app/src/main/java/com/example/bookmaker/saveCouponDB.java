package com.example.bookmaker;


import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.util.Log;
import android.content.Context;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
import android.content.Context;

public class saveCouponDB {

    private  Map<String, String[]> events;
    private double multiplier, winPrice,price;
    private SQLiteDatabase database;

    public saveCouponDB(Map<String, String[]> events, double multiplier,double price, double winPrice,SQLiteDatabase database){
        this.events=events;
        this.multiplier=multiplier;
        this.price=price;
        this.winPrice=winPrice;
        this.database=database;
    }

    public boolean saveCoupon()
    {
        saveToDB();
        return true;
    }

    private void saveToDB()
    {
        database.execSQL("CREATE TABLE IF NOT EXISTS BetCoupons (" +
                "bet_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "bet_odd REAL NOT NULL, " +
                "bet_price REAL NOT NULL, " +
                "potential_win REAL NOT NULL," +
                "bet_date DATE NOT NULL, " +
                "coupon_status CHECK (status IN ('pending', 'succes', 'failed')) " +
                ")");
        database.execSQL("CREATE TABLE IF NOT EXISTS events (" +
                "event_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "bet_id INTEGER NOT NULL, " +
                "event_api_id TEXT NOT NULL, " +
                "event_odds REAL NOT NULL, " +
                "bet_winner TEXT NOT NULL, " +
                "bet_status CHECK (status IN ('pending', 'succes', 'failed')), " +
                "FOREIGN KEY (bet_id) REFERENCES BetCoupons(bet_id)" +
                ")");
        //putting values to coupon table
        ContentValues betCouponValues = new ContentValues();
        betCouponValues.put("bet_odd", multiplier);
        betCouponValues.put("bet_price", price);
        betCouponValues.put("potential_win", winPrice);
        betCouponValues.put("bet_date", getData());
        betCouponValues.put("coupon_status", "pending");
        long insertedRowId = database.insert("events", null, betCouponValues);
        String insertedKeyValue = String.valueOf(insertedRowId);
        //putting coupon values to events table
        ContentValues values = new ContentValues();
        for (Map.Entry<String, String[]> entry : events.entrySet()) {
            String itemId = entry.getKey();
            String odds = entry.getValue()[1];
            values.clear(); // Clear previous values
            String scorebet="";
            if (entry.getValue()[3].equals("0")) {
                scorebet = entry.getValue()[1];
            } else if (entry.getValue()[3].equals("1")) {
                scorebet = "Draw";
            } else if (entry.getValue()[3].equals("2")) {
                scorebet = entry.getValue()[2];
            }
            values.put("bet_id", insertedKeyValue);
            values.put("event_api_id", itemId);
            values.put("event_odds", odds);
            values.put("bet_winner", scorebet);
            values.put("bet_status", "pending");
            database.insert("events", null, values);
        }
        Cursor betCouponCursor = database.rawQuery("SELECT * FROM BetCoupons", null);
        while (betCouponCursor.moveToNext()) {
            int betId = betCouponCursor.getInt(betCouponCursor.getColumnIndex("bet_id"));
            float betOdd = betCouponCursor.getFloat(betCouponCursor.getColumnIndex("bet_odd"));
            float betPrice = betCouponCursor.getFloat(betCouponCursor.getColumnIndex("bet_price"));
            float potentialWin = betCouponCursor.getFloat(betCouponCursor.getColumnIndex("potential_win"));
            String betDate = betCouponCursor.getString(betCouponCursor.getColumnIndex("bet_date"));
            String couponStatus = betCouponCursor.getString(betCouponCursor.getColumnIndex("coupon_status"));

            // Print the values
            Log.d("BetCoupons", "Bet ID: " + betId);
            Log.d("BetCoupons", "Bet Odd: " + betOdd);
            Log.d("BetCoupons", "Bet Price: " + betPrice);
            Log.d("BetCoupons", "Potential Win: " + potentialWin);
            Log.d("BetCoupons", "Bet Date: " + betDate);
            Log.d("BetCoupons", "Coupon Status: " + couponStatus);
        }
        betCouponCursor.close();
        ///////////////////////
        Cursor eventsCursor = database.rawQuery("SELECT * FROM events", null);
        while (eventsCursor.moveToNext()) {
            int eventId = eventsCursor.getInt(eventsCursor.getColumnIndex("event_id"));
            int betId = eventsCursor.getInt(eventsCursor.getColumnIndex("bet_id"));
            String eventApiId = eventsCursor.getString(eventsCursor.getColumnIndex("event_api_id"));
            float eventOdds = eventsCursor.getFloat(eventsCursor.getColumnIndex("event_odds"));
            String betWinner = eventsCursor.getString(eventsCursor.getColumnIndex("bet_winner"));
            String betStatus = eventsCursor.getString(eventsCursor.getColumnIndex("bet_status"));

            // Print the values
            Log.d("Events", "Event ID: " + eventId);
            Log.d("Events", "Bet ID: " + betId);
            Log.d("Events", "Event API ID: " + eventApiId);
            Log.d("Events", "Event Odds: " + eventOdds);
            Log.d("Events", "Bet Winner: " + betWinner);
            Log.d("Events", "Bet Status: " + betStatus);
        }
        eventsCursor.close();
        /////
            database.close();
    }

    public String getData()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        return formatter.format(now);
    }
}
