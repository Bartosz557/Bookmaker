package com.example.bookmaker;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

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
                "bet_time TEXT NOT NULL, " +
                "bet_odd REAL NOT NULL, " +
                "bet_price REAL NOT NULL, " +
                "potential_win REAL NOT NULL," +
                "bet_date DATE NOT NULL " +
                ")");
        database.execSQL("CREATE TABLE IF NOT EXISTS events (" +
                "event_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "bet_id INTEGER NOT NULL, " +
                "event_api_id TEXT NOT NULL, " +
                "event_odds REAL NOT NULL, " +
                "bet_winner TEXT NOT NULL, " +
                "bet_status CHECK (status IN ('pending', 'succes', 'fail')), " +
                "FOREIGN KEY (bet_id) REFERENCES BetCoupons(bet_id)" +
                ")");
            ContentValues row1 = new ContentValues();
            row1.put("imie", "Marek");
            row1.put("wiek", 22);
            row1.put("numer", 1);
            database.insert("pierwszaBaza", null, row1);

//            Cursor myCursor = database.rawQuery("select imie, wiek, numer from pierwszaBaza",
//                    null);
//            while(myCursor.moveToNext()) {
//                String imie = myCursor.getString(0);
//                int wiek = myCursor.getInt(1);
//                int numer = myCursor.getInt(2);
//                Log.d("Imie:", imie);
//                Log.d("Wiek:", ""+ wiek);
//                Log.d("Numer:", ""+ numer);
//            }
//            myCursor.close();
            database.close();
    }
}
