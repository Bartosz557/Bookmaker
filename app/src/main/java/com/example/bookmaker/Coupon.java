package com.example.bookmaker;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

public class AddBetToQ {

    static Map<String, Double> addedEvents = new HashMap<String, Double>();
    static double[] prices;
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
    }

}
