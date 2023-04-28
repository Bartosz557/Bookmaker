package com.example.bookmaker;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.HashMap;
import java.util.Map;

public class Coupon extends AppCompatActivity {

    private static Map<String, String[]> addedEvents = new HashMap<String, String[]>();

    private static double multiplier;
    public static void addEventToCoupon(String id, String odd, String homeTeam, String awayTeam, int scoreBet )
    {
        String[] values = new String[]{odd,homeTeam,awayTeam,Integer.toString(scoreBet)};
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


    //save to databse!
     static public void createCoupon(EditText priceStake)
    {
        double winPrice = Double.parseDouble(priceStake.getText().toString())*multiplier*0.9;
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
