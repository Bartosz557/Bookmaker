package com.example.bookmaker;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Coupon extends AppCompatActivity {

    private static Map<String, String[]> addedEvents = new HashMap<String, String[]>();
    private static double multiplier,price,winPrice;
    public static void addEventToCoupon(String id, String odd, String homeTeam, String awayTeam, int scoreBet, String sport )
            //scorBet - 1 home 2 draw 3 away
    {
        String[] values = new String[]{odd,homeTeam,awayTeam,Integer.toString(scoreBet),sport};
        if(!addedEvents.containsKey(id)) {
            addedEvents.put(id, values);
        }
        else{
            //deleting event if pressed the same odd
            if (odd == addedEvents.get(id)[0])
                addedEvents.remove(id);
            else {
                //switching event odds if pressed another odd
                addedEvents.remove(id);
                addedEvents.put(id, values);
            }
        }
        //checking coupon in logs
        for (Map.Entry<String, String[]> entry : addedEvents.entrySet()) {
            String itemId = entry.getKey();
            String odds = entry.getValue()[1];
            String log = ("Item " + itemId + " Odd" + odds);
            Log.d("events", log);
        }
        getMultiplier();
    }
    public static boolean delEvent(String id)
    {
        addedEvents.remove(id);
        for (Map.Entry<String, String[]> entry : addedEvents.entrySet()) {
            String itemId = entry.getKey();
            String odds = entry.getValue()[1];
            String log = ("Item " + itemId + " Odd" + odds);
            Log.d("events", log);
        }
        if(addedEvents.size()==0)
            return true;
        return false;
    }
    public static void setCouponBox(View couponBox)
    {
        if(addedEvents.size()>0)
            couponBox.setVisibility(View.VISIBLE);
        else
            couponBox.setVisibility(View.INVISIBLE);
    }
    static void getMultiplier()
    {
        multiplier=1;
        for (Map.Entry<String, String[]> entry : addedEvents.entrySet()) {
            double odds = Double.parseDouble(entry.getValue()[0]);
            multiplier*=odds;
        }
    }
    static public double setWinPrice(EditText priceStake)
    {
        CharSequence stake = priceStake.getText();
        if(stake!=null && stake.length() > 0) {
            price = Double.parseDouble(stake.toString());
            winPrice = price*multiplier*0.9;
            return winPrice;
        }
        return 0;
    }

     static public void createCoupon(SQLiteDatabase myDB) {
         saveCouponDB saveCoupon = new saveCouponDB(addedEvents, multiplier, price ,winPrice, myDB);
         saveCoupon.saveCoupon();
         addedEvents.clear();
     }
     static public int tryToBet()
    {
        if(addedEvents.size()>0 && winPrice>=1) {
            return 0;
        }else if(winPrice>0)
        {
            return 1;
        }else
            return 2;
    }
    static Map<String, String[]> setEvents()
    {
        return addedEvents;
    }
    static double setMultiplier()
    {
        return multiplier;
    }

}
