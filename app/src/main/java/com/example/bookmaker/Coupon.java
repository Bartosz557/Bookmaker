package com.example.bookmaker;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.HashMap;
import java.util.Map;

public class Coupon extends AppCompatActivity {

    private static Map<String, Double> addedEvents = new HashMap<String, Double>();
    private static double multiplier;
    public static void addEventToCoupon(String id, double odd )
    {
        if(!addedEvents.containsKey(id)) {
            addedEvents.put(id, odd);
        }
        else{
            //deleting event if pressed the same odd
            if (odd == addedEvents.get(id))
                addedEvents.remove(id);
            else {
                //switching event odds if pressed another odd
                addedEvents.remove(id);
                addedEvents.put(id, odd);
            }
        }
        //checking coupon in logs
        for (Map.Entry<String, Double> entry : addedEvents.entrySet()) {
            String itemId = entry.getKey();
            double odds = entry.getValue();
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
        for (Map.Entry<String, Double> entry : addedEvents.entrySet()) {
            double odds = entry.getValue();
            multiplier*=odds;
        }
    }

    static Map<String, Double> setEvents()
    {
        return addedEvents;
    }
    static double setMultiplier()
    {
        return multiplier;
    }

}
