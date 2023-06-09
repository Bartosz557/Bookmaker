package com.example.bookmaker;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class createCouponEvents extends AppCompatActivity {

    public void createLayout(LinearLayout layout, Context context)
    {
        couponFullScreen activity = (couponFullScreen) context;
        LayoutInflater inflater = LayoutInflater.from(context);
        Map<String, String[]> events = coupon.setEvents();
//        0 = odds;
//        1 = hometeam;
//        2 = awayteam;
//        3 = scoreBet;
        for (Map.Entry<String, String[]> entry : events.entrySet()) {
            Log.d("eventsincoupon","event");
            String itemId = entry.getKey();
            View view = inflater.inflate(R.layout.coupon_template, null);
            TextView odd = view.findViewById(R.id.addOdd);
            TextView winner = view.findViewById(R.id.addWinner);
            TextView betName = view.findViewById(R.id.addBetName);
            ImageButton close = view.findViewById(R.id.imageButton2);
            close.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    layout.removeView(view);
                    if(coupon.delEvent(itemId)) {
                        Log.d("elo ","finish");
                        activity.finish();
                    }
                }
            });

            odd.setText(entry.getValue()[0]);
            //xxx.setText(entry.getValue()[1]);
            int bet = Integer.parseInt(entry.getValue()[3]);
            String winnerbet;
            if(bet==0)
                winnerbet=entry.getValue()[1];
            else if (bet==1)
                winnerbet="Remis";
            else winnerbet=entry.getValue()[2];
            betName.setText(entry.getValue()[1]+" vs "+entry.getValue()[2]);
            winner.setText(winnerbet);
            layout.addView(view);
        }
    }
}
